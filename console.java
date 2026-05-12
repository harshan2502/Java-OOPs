import java.util.Scanner;

// Abstraction
abstract class Account {
    private String accountHolder;
    private int accountNumber;
    protected double balance;

    public Account(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Encapsulation
    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    // Abstract methods
    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    public void showBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

// Inheritance
class SavingsAccount extends Account {
    public SavingsAccount(String name, int accNo, double balance) {
        super(name, accNo, balance);
    }

    // Polymorphism
    @Override
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited: " + amount);
        }
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Amount Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String name, int accNo, double balance) {
        super(name, accNo, balance);
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited: " + amount);
    }

    @Override
    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Amount Withdrawn: " + amount);
    }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Choose Account Type: ");
        int type = sc.nextInt();

        Account account;

        if (type == 1) {
            account = new SavingsAccount(name, accNo, balance);
        } else {
            account = new CurrentAccount(name, accNo, balance);
        }

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    account.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter Withdrawal Amount: ");
                    account.withdraw(sc.nextDouble());
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    System.out.println("Account Holder: " + account.getAccountHolder());
                    System.out.println("Account Number: " + account.getAccountNumber());
                    break;
                case 5:
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
