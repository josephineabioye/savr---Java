package savr.model;
import java.util.*;

public class Account {
    private String name;
    private double balance;
    private List<Pocket> pockets;

    public Account(String name, double bal) {
        this.name = name;
        balance = bal;
        pockets = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }

    public void addPocket(Pocket pocket) {
        pockets.add(pocket);
    }
    public String transferToPocket(String pocketName, double amount) {
        if (amount <= 0) {
            return "Amount must be greater than zero.";
        }
        if (balance <= 0){
            return "Account is not Funded";
        }
        if (balance < amount){
            return "Insufficient account balance";
        }
        for (Pocket temp : pockets) {
            if (temp.getPocketName().equalsIgnoreCase(pocketName)) {
                String result = temp.addFunds(amount);

                // Only deduct if pocket actually accepted the money
                if (result.startsWith("Amount credited")) {
                    balance -= amount;
                }
                return result;
            }
        }
        return "Pocket not found.";

    }


    }
