import java.util.ArrayList;

class Account {
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: " + amount);
        System.out.println("Deposit of " + amount + " made to account " + accountNumber);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: " + amount);
            System.out.println("Withdrawal of " + amount + " made from account " + accountNumber);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(Account destinationAccount, double amount) {
        if (amount <= balance) {
            balance -= amount;
            destinationAccount.deposit(amount);
            transactionHistory.add("Transfer: " + amount + " to account " + destinationAccount.getAccountNumber());
            System.out.println("Transfer of " + amount + " made from account " + accountNumber + " to account " + destinationAccount.getAccountNumber());
        } else {
            System.out.println("Insufficient funds for the transfer.");
        }
    }
}

class Client {
    private String name;
    private String address;
    private ArrayList<Account> accounts;

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Account account1 = new Account("123456", 1000.0);
        Account account2 = new Account("789012", 500.0);

        Client client1 = new Client("John Doe", "321 Pine St");
        Client client2 = new Client("Jane Smith", "654 Elm St");

        client1.addAccount(account1);
        client2.addAccount(account2);

        account1.withdraw(200.0);
        account2.deposit(100.0);

        System.out.println("Account 1 balance: $" + account1.getBalance());
        System.out.println("Account 2 balance: $" + account2.getBalance());
    }
}