import java.util.*;

public class final_ATM {
    
     static double balance = 0;
     static ArrayList<String> transactionHistory = new ArrayList<String>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ch = 0;
        
        while (ch != 5) {
            System.out.println("Please select an option:\n1.Deposit\n2.Withdraw\n3.Show balance\n4.Transaction history\n5.Exit");
            ch = scanner.nextInt();
            
            switch (ch) {
                case 1:
                    System.out.println("Enter the deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter the withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    showBalance();
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    public static void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            balance += amount;
            String transaction = String.format("Deposit: +%.2f", amount);
            transactionHistory.add(transaction);
            System.out.println("Deposit successful.");
        }
    }
    
    public static void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            String transaction = String.format("Withdrawal: -%.2f", amount);
            transactionHistory.add(transaction);
            System.out.println("Withdrawal successful.");
        }
    }
    
    public static void showBalance() {
        System.out.printf("Current balance: %.2f\n", balance);
    }
    
    public static void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("Transaction history is empty.");
        } else {
            System.out.println("Transaction history:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}
