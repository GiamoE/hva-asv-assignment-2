package nl.hva.service.model;

public class Account {

    private String iban;
    private String accountHolderName;
    private double balance;
    public boolean inactive;

    public Account(String iban, String accountHolderName, double balance, boolean inactive) {
        this.iban = iban;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.inactive = inactive;
    }

    public boolean isInactive() {
        return inactive;
    }

    public boolean withdraw(double amount) {
        if(balance < amount) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        balance -= amount;
    }

    public void setInactive(boolean active) {
        this.inactive = active;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                ", inactive=" + inactive +
                '}';
    }
}
