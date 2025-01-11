import assert from 'assert';
import yahooFinance from 'yahoo-finance2';

async function testStockPriceQuery() {
  try {
    const quote = await yahooFinance.quote('^DJI');
    assert(quote.regularMarketPrice > 0, 'Stock price should be greater than 0');
    console.log('✓ Stock price query test passed');
  } catch (error) {
    console.error('✗ Stock price query test failed:', error.message);
  }
}

testStockPriceQuery();