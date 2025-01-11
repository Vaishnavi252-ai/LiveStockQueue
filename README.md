# LiveStockQueue
The `LivestockQueue` in your project is a core component responsible for storing and managing the live stock price data retrieved from the Yahoo Finance API at regular intervals. It ensures that the application maintains a record of stock prices over time, allowing for continuous updates to the line graph that visually represents stock price trends
Project Overview
The Livestock Stock Price Monitoring Application is a real-time stock tracking tool designed to continuously monitor and display the stock prices of a selected company using the Yahoo Finance API. The application queries stock prices at regular intervals and displays a dynamic, real-time updating line graph that plots the stock price against time. This project serves as a practical implementation of Java, JavaFX for graphical visualization, Gradle for dependency management, and the Yahoo Finance API for live stock data retrieval.

Features
Real-Time Stock Data Retrieval:
The application queries the latest stock price from Yahoo Finance every five seconds, ensuring that the data remains current.

Stock Price Queue Management:
The application maintains a queue of stock prices that stores recent price data. As new prices are queried, older entries are dequeued to keep the size manageable. This mechanism ensures efficient memory usage while maintaining the data needed for plotting.

Dynamic Line Graph Visualization:
A core feature of the application is its graphical interface, which uses JavaFX to display a real-time updating line graph. The graph plots time on the x-axis and stock price on the y-axis, allowing users to visually track stock price trends over time.

Error Handling and Stability:
The application is designed to handle potential issues, such as connectivity problems or unexpected API responses. It ensures a smooth user experience by handling errors gracefully without crashing.

Scalable Design:
The modular design of the application makes it easy to extend functionality. New features, such as querying multiple stocks or exporting data, can be added with minimal changes to the existing codebase.

Technology Stack
Java: Core language used to build the application logic.
JavaFX: Used for creating a user-friendly graphical interface and real-time graph plotting.
Yahoo Finance API: Provides live stock data for the selected company.
Gradle: Dependency management and build automation tool used for compiling and running the application.
JUnit: Used for testing the functionality of various components to ensure reliability and accuracy.
How It Works
The application starts by initializing the queue and setting up a JavaFX interface.
It queries stock prices from Yahoo Finance at a regular interval (every five seconds) using the queryStock() method.
The retrieved stock price is added to the queue, and the graph is updated accordingly.
If the queue exceeds a predefined limit, older stock prices are dequeued to keep the data manageable.
The graph refreshes each time a new price is added, showing all the current stock prices stored in the queue.
Usage Instructions
Ensure that Java and Gradle are installed on your system.
Clone or download the project repository.
Navigate to the project directory and run the following command to build the project:
bash
Copy code
gradle clean build
Once the build is successful, run the application using:
bash
Copy code
gradle run
The graphical interface will launch, and the line graph will start displaying real-time stock prices queried from Yahoo Finance.
Setup Requirements
Java Development Kit (JDK): Ensure JDK version 17 or higher is installed.
Gradle: Install Gradle for build automation.
Yahoo Finance API: The application uses the Yahoo Finance API for stock data retrieval.
JavaFX: Ensure JavaFX is configured properly, as it is required for the graphical interface.
Project Structure
App.java: The main class that initializes the application and manages querying stock prices.
LivestockQueue.java: A helper class that manages the queue of stock prices and ensures proper data handling.
build.gradle: Contains the Gradle configuration, including dependencies and build instructions.
src/main/java: Contains the main application source code.
src/test/java: Contains unit tests for the application to ensure code quality and reliability.
Future Enhancements
Multi-Stock Support: Add the ability to track multiple stocks simultaneously and display multiple graphs.
Data Export: Allow users to export recorded stock prices as a CSV or Excel file for analysis.
Historical Data Plotting: Enable users to view and analyze historical stock data alongside real-time updates.
Graph Customization: Provide options to customize the graph, such as changing colors, intervals, and data labels.
