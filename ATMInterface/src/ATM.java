import java.util.Scanner;

public class ATM {
    private BankAccount account;

    // Constructor to initialize ATM with a user's bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the menu
    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Method to process user's withdrawal
    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Transaction successful!");
        } else {
            System.out.println("Transaction failed.");
        }
    }

    // Method to process user's deposit
    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Transaction successful!");
    }

    // Method to check the balance
    public void checkBalance() {
        System.out.println("Your current balance is: " + account.checkBalance());
    }

    // Method to start the ATM
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
