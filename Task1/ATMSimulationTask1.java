import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulationTask1 {
    // Initial balance and PIN
    private static int balance = 1000;
    private static int pin = 1234;
    // List to keep track of transaction history
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for PIN and validate it
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        // Check if entered PIN is correct
        if (enteredPin != pin) {
            System.out.println("Incorrect PIN. Exiting...");
            scanner.close();
            return;
        }

        int option;
        do {
            // Display ATM menu
            System.out.println("\nWelcome to the ATM");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            // Handle user's menu choice
            switch(option) {
                case 1:
                    // Check balance
                    checkBalance();
                    break;
                case 2:
                    // Withdraw money
                    withdrawMoney(scanner);
                    break;
                case 3:
                    // Deposit money
                    depositMoney(scanner);
                    break;
                case 4:
                    // Change PIN
                    changePin(scanner);
                    break;
                case 5:
                    // Show transaction history
                    showTransactionHistory();
                    break;
                case 6:
                    // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    // Invalid option handling
                    System.out.println("Invalid option. Please try again.");
            }
        } while(option != 6);

        scanner.close();
    }

    // Method to check balance and log the transaction
    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
        transactionHistory.add("Checked balance: $" + balance);
    }

    // Method to handle money withdrawal
    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        int withdrawAmount = scanner.nextInt();
        
        // Check if sufficient balance is available
        if (withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("You have withdrawn: $" + withdrawAmount);
            System.out.println("Your new balance is: $" + balance);
            transactionHistory.add("Withdrew: $" + withdrawAmount);
        } else {
            // Insufficient balance handling
            System.out.println("Insufficient balance!");
            transactionHistory.add("Failed withdrawal attempt: $" + withdrawAmount + " (Insufficient balance)");
        }
    }

    // Method to handle money deposit
    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        int depositAmount = scanner.nextInt();
        
        balance += depositAmount;
        System.out.println("You have deposited: $" + depositAmount);
        System.out.println("Your new balance is: $" + balance);
        transactionHistory.add("Deposited: $" + depositAmount);
    }

    // Method to handle PIN change
    private static void changePin(Scanner scanner) {
        System.out.print("Enter your current PIN: ");
        int currentPin = scanner.nextInt();
        
        // Validate current PIN
        if (currentPin == pin) {
            System.out.print("Enter your new PIN: ");
            int newPin = scanner.nextInt();
            pin = newPin;
            System.out.println("Your PIN has been successfully changed.");
            transactionHistory.add("Changed PIN");
        } else {
            // Incorrect current PIN handling
            System.out.println("Incorrect current PIN. PIN change failed.");
            transactionHistory.add("Failed PIN change attempt");
        }
    }

    // Method to show transaction history
    private static void showTransactionHistory() {
        // Check if there are any transactions
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}
