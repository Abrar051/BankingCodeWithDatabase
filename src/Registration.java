import java.util.Scanner;

public class Registration {
    public String name;
    public String pass;
    public int accNo;
    public float amount;
    public String type;


    DatabaseCreateDelete data = new DatabaseCreateDelete();
    DatabaseManagement customer = new DatabaseManagement();
    Scanner input = new Scanner(System.in);

    public void register(int accountNumber) {
        System.out.println("Enter User name : ");
        name = input.next();
        System.out.println("Enter password : ");
        pass = input.next();
        System.out.println("Enter amount : ");
        amount = input.nextFloat();
        System.out.println("Enter account type : input debit/credit/savings ");
        type = input.next();
        switch (type) {
            case "debit":
                System.out.println("Debit account made successfully");
                customer.insertRecords(accountNumber, name, type, pass, amount);
                break;
            case "credit":
                System.out.println("Credit account made successfully");
                customer.insertRecords(accountNumber, name, type, pass, amount);
                break;
            case "savings":
                System.out.println("Input your limit : ");
                int limit = input.nextInt();
                customer.insertRecords(accountNumber, name, type, pass, amount);
                customer.insertSavingRecord(accountNumber, name, pass, limit);
                break;
            default:
                System.out.println("Please enter valid account type");
                System.out.println("Can't add in database");
                break;
        }

    }

    public void signUp() {
        System.out.println("Enter user name : ");
        String user = input.next();
        System.out.println("Enter password : ");
        String pass = input.next();
        customer.showRecords(user, pass);
        System.out.println("For deposit money enter d and for withdraw enter w for no operation enter n : ");
        String op = input.next();
        if (op.equals("d")) {
            System.out.println("Enter deposit money : ");
            int amount = input.nextInt();
            int id = customer.extractId(user, pass);
            customer.updateRecords(id, amount + customer.extractBalance(user, pass));
            customer.showRecords(user, pass);
        } else if (op.equals("w")) {
            System.out.println("Enter withdraw amount : ");
            float amount = input.nextFloat();
            String type = customer.extractType(user, pass);
            switch (type) {
                case "debit":
                    debitWithdraw(amount, user, pass);
                    customer.showRecords(user, pass);
                    break;
                case "credit":
                    creditWithdraw(amount, user, pass);
                    customer.showRecords(user, pass);
                    break;
                case "savings":
                    System.out.println("Your limit is : " + customer.extractSavingLimit(user, pass));
                    customer.updateSavingsRecords(user, pass, amount);
                default:
                    System.out.println("Please enter valid database type");
            }

        }
    }

    public void debitWithdraw(float amount, String user, String password) {
        float balance = (float) customer.extractBalance(user, password);
        if (amount > balance) {
            System.out.println("Can't pick more than balance");
        } else {
            balance = (balance - amount);
            customer.updateRecords(customer.extractId(user, password), balance);
            return;
        }
    }

    public void creditWithdraw(float amount, String user, String password) {
        float balance = (float) customer.extractBalance(user, password);
        if (amount > balance + balance / 2) {
            System.out.println("Can't pick more than balance");
        } else {
            balance = (balance - amount);
            customer.updateRecords(customer.extractId(user, password), balance);
            return;
        }
    }

    public void savingsWithdraw(float amount, String user, String password) {

    }


}
