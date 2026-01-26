package savr.model;

public class AutoDebit {
    private String pocketName;
    private double amount;

    public AutoDebit(String pName, double amt) {
        pocketName = pName;
        amount = amt;
    }

    public String autoDebitPocketName() {
        return pocketName;
    }

    public double autoDebitAmount() {
        return amount;
    }
}
