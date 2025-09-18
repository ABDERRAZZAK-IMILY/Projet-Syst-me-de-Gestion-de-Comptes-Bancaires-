# Bank Account Management System
 ### Description
   This is a console-based Java 8 application for managing bank accounts (current and savings). It supports creating accounts, performing deposits, withdrawals, transfers, and viewing account balances and transaction history. Data persists in memory until the application closes.
## Technologies Used

Java 8
Java Time API (for operation dates)
Collections: ArrayList, HashMap
UUID for unique operation identifiers
Scanner for console input
Stream API (for bonus filtering)

## Project Structure

com.bank.model: Model classes (Compte, CompteCourant, CompteEpargne, Operation, Versement, Retrait)
com.bank.metier: Business logic (CompteService)
com.bank.util: Utility functions (InputValidator)
com.bank.ui: Console interface (Menu)

## Prerequisites

JDK 8
Eclipse IDE (or any Java 8 compatible IDE)

Installation and Execution

Clone the GitHub repository:git clone <repository-url>


Open the project in Eclipse.
Compile and run the Menu class in the com.bank.ui package.

Generating and Running JAR

Compile the source files:javac com/bank/**/*.java


Create the JAR file:jar cfe bank.jar com.bank.ui.Menu com/bank/**/*.class


Run the JAR:java -jar bank.jar



## Usage

Run the application to access an interactive console menu.
Choose options to create accounts, deposit, withdraw, transfer funds, or view balances and operations.
Account codes are automatically generated in the format CPT-XXXXX.
Input validation ensures positive amounts and correct code formats.

## Screenshots
  ### Class Diagram

![alt text](<Capture d’écran_18-9-2025_9565_app.diagrams.net.jpeg>)