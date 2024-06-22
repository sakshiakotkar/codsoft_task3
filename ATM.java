package com.codsoftintern;
import java.util.Scanner;
    //class to represent the user's bank account,
    class UserBankAccount {
        private double balance;

        public UserBankAccount(double balance) {
            this.balance = balance;
        }
        //getter method
        public double getBalance() {
            return balance;
        }
        //methods to deposit
        public void deposit(double amount) {
            balance += amount;
        }
        //method for withdrawing
        public boolean withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        }
    }
    //class to represent the ATM machine.
    public class ATM {
        private UserBankAccount account;
        private Scanner sc;

        public ATM(UserBankAccount account) {
            this.account = account;
            this.sc = new Scanner(System.in);
        }

        public void displayMenu() {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
        }

        public void processOption(int option) {
            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        public void checkBalance() {
            System.out.println("Your balance is: $" + account.getBalance());
        }

        public void deposit() {
            System.out.print("Enter the deposit amount: $");
            double amount = sc.nextDouble();
            account.deposit(amount);
            System.out.println("Deposited successful.");
        }

        public void withdraw() {
            System.out.print("Enter the withdrawal amount: $");
            double amount = sc.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. Please take your cash.");
            } else {
                System.out.println("Insufficient balance.");
            }
        }

        public static void main(String[] args) {
            UserBankAccount userAccount = new UserBankAccount(3000); // Starting balance of $1000
            ATM atm = new ATM(userAccount);

            while (true) {
                atm.displayMenu();
                System.out.print("Enter your choice: ");
                int option = atm.sc.nextInt();
                atm.processOption(option);
            }
        }
    }


