import yahoofinance.YahooFinance;
import yahoofinance.Stock;
import java.util.LinkedList;
import java.util.Queue;
import java.time.Instant;
import java.math.BigDecimal;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
    static class StockPrice {
        BigDecimal price;
        Instant timestamp;

        StockPrice(BigDecimal price, Instant timestamp) {
            this.price = price;
            this.timestamp = timestamp;
        }
    }

    static class StockPriceQueue {
        private Queue<StockPrice> queue = new LinkedList<>();
        private final int maxSize;

        public StockPriceQueue(int maxSize) {
            this.maxSize = maxSize;
        }

        public void enqueue(StockPrice item) {
            if (queue.size() >= maxSize) {
                queue.poll(); // Remove oldest item if queue is full
            }
            queue.offer(item);
        }
    }

    private static final StockPriceQueue priceQueue = new StockPriceQueue(100);

    private static void getDowJonesPrice() {
        try {
            Stock dowJones = YahooFinance.get("^DJI");
            BigDecimal price = dowJones.getQuote().getPrice();
            Instant timestamp = Instant.now();

            priceQueue.enqueue(new StockPrice(price, timestamp));
            System.out.printf("[%s] Dow Jones: $%s%n", timestamp, price);
        } catch (IOException e) {
            System.err.println("Error fetching stock price: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting Dow Jones price tracker...");
        
        // Initial query
        getDowJonesPrice();

        // Schedule queries every 5 seconds
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(App::getDowJonesPrice, 5, 5, TimeUnit.SECONDS);

        // Keep the main thread alive
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            executor.shutdown();
        }
    }
}