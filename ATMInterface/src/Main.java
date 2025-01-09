import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize a bank account with a balance of 1000
        BankAccount userAccount = new BankAccount(1000);

        // Initialize the ATM with the bank account
        ATM atm = new ATM(userAccount);

        // Start the ATM interface
        atm.start();
    }
}
