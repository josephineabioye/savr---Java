package savr;

import savr.model.Account;
import savr.model.Pocket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Account account1 = new Account("Josephine A", 1000);

        Pocket rent = new Pocket("Rent", 500, 0);
        Pocket laptop = new Pocket("Laptop", 1200, 200);
        account1.addPocket(rent);
        account1.addPocket(laptop);

        System.out.println(account1.getAccountBalance());

        System.out.println(account1.transferToPocket("Rent", 200));
        System.out.println(account1.transferToPocket("Laptop", 150));

        System.out.println(account1.getAccountBalance());

        System.out.println(account1.transferToPocket("Rent", 200));

        System.out.println(rent.isGoalReached());

        System.out.println(rent.addFunds(100));

        System.out.println(rent.getPocketBalance());
        System.out.println(rent.getPocketName());
        System.out.println(rent.isGoalReached());

        System.out.println(account1.getAccountBalance());
        account1.deposit(300);

        System.out.println(account1.getAccountBalance());

    }
}