package savr;

import savr.model.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Enter Account Name");
        String acctName = reader.nextLine();
        System.out.println("Enter Initial Balance");
        double initialBal = reader.nextDouble();

        Account account1 = new Account(acctName, initialBal);

        boolean running = true;
        while (running) {
            System.out.println("\n===== Savr Menu =====");
            System.out.println("1. Deposit to Account");
            System.out.println("2. Withdraw from account");
            System.out.println("3. Add a new pocket");
            System.out.println("4. Transfer to pocket");
            System.out.println("5. Show balances");
            System.out.println("6. View Transaction History");
            System.out.println("7. Create Auto-debit");
            System.out.println("8. Run All Auto-Debits");
            System.out.println("9. Run One Auto-Debit");
            System.out.println("10. Exit");
            System.out.println("Enter your choice");
            int choice = reader.nextInt();
            reader.nextLine();

            if (choice == 1) {
                System.out.println("Enter deposit amount: ");
                double amount = reader.nextDouble();
                reader.nextLine();
                account1.deposit(amount);
                System.out.println("Deposited: " + amount);
            }
            else if (choice == 2) {
                System.out.println("Enter withdrawal amount: ");
                double amount = reader.nextDouble();
                reader.nextLine();
                account1.withdraw(amount);
                System.out.println("withdrawn: " + amount);
            }
            else if (choice == 3) {
                System.out.println("Enter pocket name: ");
                String pocketName = reader.nextLine().trim();
                System.out.println("Enter target amount: ");
                double target = reader.nextDouble();
                reader.nextLine();
                Pocket pocket1 = new Pocket(pocketName, target);
                account1.addPocket(pocket1);
                System.out.println("Pocket " + pocket1 + "created with target " + target);
            }
            else if (choice == 4) {
                System.out.println("Enter pocket name to transfer to: ");
                String pocketName = reader.nextLine().trim();
                System.out.println("Enter amount to transfer: ");
                double amount = reader.nextDouble();
                reader.nextLine();
                String result = account1.transferToPocket(pocketName, amount);
                System.out.println(result);
            }
            else if (choice == 5) {
                System.out.println("Account balance: " + account1.getAccountBalance());
                System.out.println("Pockets:");
                for (Pocket p : account1.pocketListName()) {
                    System.out.println(" - " + p.getPocketName() + ": " + p.getPocketBalance() + " / " + p.getTargetAmount());
                }
            }
            else if (choice == 6) {
                for (Transaction temp : account1.getTransactions()) {
                    System.out.println(temp);
                }

            }
            else if (choice == 7) {
                System.out.print("Enter pocket name: ");
                String pocketName = reader.nextLine().trim();

                System.out.print("Enter amount: ");
                double amount = reader.nextDouble();
                reader.nextLine();

                System.out.print("Frequency(DAILY / WEEKLY / MONTHLY): ");
                String input = reader.nextLine().trim();
                Frequency freq = Frequency.valueOf(input.toUpperCase());

                AutoDebit rule = new AutoDebit(pocketName, amount, freq);
                account1.addAutoDebit(rule);

                System.out.println("Auto-debit created successfully.");
            }
            else if (choice == 8) {
                account1.runAutoDebits();
            }
            else if (choice == 9) {
                System.out.print("Enter pocket name for auto-debit: ");
                String pocketName = reader.nextLine().trim();

                String result = account1.runSingleAutoDebit(pocketName);
                System.out.println(result);
            }
            else if (choice == 10) {
                System.out.println("Exiting...");
                running = false;
            }
            else {
                System.out.println("Invalid choice. Try again!");
            }
        }


        System.out.println("======== SECOND TEST =======");
        Pocket rent = new Pocket("Rent", 500);
        Pocket laptop = new Pocket("Laptop", 1200);
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