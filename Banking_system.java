/*
Pooja would like to transaction X amount from a Banking application. The application only accepts the transaction if Pooja’s
account balance has enough cash to perform the transaction (including bank charges). For each successful withdrawal the
bank charges Rs 100. An application requires to perform this operation for that Pooja wants to login with username and
password. Application accepts password from the following constraint:
-At least 1 letter between [a-z]
-At least 1 number between [0-9]
-At least 1 letter between [A-Z]
-At least 1 character from [$#@]

Minimum length of password: 6
-Maximum length of password: 12
Construct a program in Java to perform above operations in Banking application: check Login, transaction Details.
*/
import java.util.Scanner;

public class Banking_system {

    // static variables for minimum and maximum password length
    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final int MAX_PASSWORD_LENGTH = 12;

    // static variables for user information and account balance
    private static String username = "pooja";
    private static String password = "Pooja123#";
    private static double accountBalance = 5000.0;

    // static variable for bank charge
    private static final double BANK_CHARGE = 100.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ask user to enter username and password
        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        // check if the username and password are valid
        if (isValidLogin(inputUsername, inputPassword)) {

            // if login is valid, ask user to enter transaction amount
            System.out.print("Enter transaction amount: ");
            double transactionAmount = scanner.nextDouble();

            // check if the account has enough balance to perform the transaction
            if (hasEnoughBalance(transactionAmount)) {

                // perform the transaction and deduct the amount from the account balance
                accountBalance -= (transactionAmount + BANK_CHARGE);

                // print the transaction details
                System.out.println("Transaction successful!");
                System.out.println("Transaction amount: " + transactionAmount);
                System.out.println("Bank charge: " + BANK_CHARGE);
                System.out.println("Account balance: " + accountBalance);

            } else {
                System.out.println("Transaction failed: Insufficient balance");
            }
        } else {
            System.out.println("Invalid login credentials!");
        }
    }

    // method to check if the login credentials are valid
    private static boolean isValidLogin(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && isPasswordValid(inputPassword);
    }

    // method to check if the password meets the requirements
    private static boolean isPasswordValid(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }
        boolean hasLowercaseLetter = false;
        boolean hasUppercaseLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowercaseLetter = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercaseLetter = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (c == '$' || c == '#' || c == '@') {
                hasSpecialCharacter = true;
            }
        }
        return hasLowercaseLetter && hasUppercaseLetter && hasNumber && hasSpecialCharacter;
    }

    // method to check if the account has enough balance to perform the transaction
    private static boolean hasEnoughBalance(double transactionAmount) {
        return (accountBalance - (transactionAmount + BANK_CHARGE)) >= 0;
    }
}
