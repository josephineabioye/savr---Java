package savr.model;

import java.time.LocalDate;

public class AutoDebit {
    private String pocketName;
    private double amount;
    private Frequency frequency;

    private LocalDate lastRun;
    private LocalDate nextRun;

    public AutoDebit(String pName, double amt, Frequency frequency) {
        pocketName = pName;
        amount = amt;
        this.frequency = frequency;
        this.lastRun = null;
        this.nextRun = calculateNextRun(LocalDate.now());
    }

    public String autoDebitPocketName() {
        return pocketName;
    }

    public double autoDebitAmount() {
        return amount;
    }
}
