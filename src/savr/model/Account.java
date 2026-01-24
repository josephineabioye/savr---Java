package savr.model;
import java.util.*;

public class Account {
    private String name;
    private int balance;
    private List<Pocket> pockets;

    public Account(String name, int bal) {
        this.name = name;
        balance = bal;
        pockets = new ArrayList<>();
    }

    public void deposit(int amount) {
        balance = balance + amount;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }

    public void addPocket(Pocket pocket) {
        pockets.add(pocket);
    }
    public void transferToPocket(String pocketName, int amount) {
        for(Pocket temp : pockets) {
                if (temp.getPocketName().equals(pocketName)) {
                    if(balance >= amount) {
                       balance -= amount;
                       temp.addFunds(amount);
                    }
                    return;
                }
        }
    }
}
