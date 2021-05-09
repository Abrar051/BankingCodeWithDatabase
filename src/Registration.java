import java.util.Scanner;

public class Registration {
    public String name;
    public String pass;
    public int accNo;
    public float amount;
    public String type;

    Customer c;
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
        System.out.println("Enter account type : ");
        type = input.next();
        customer.insertRecords(accountNumber, name, type, pass, amount);
    }

    public void signUp() {
        System.out.println("Enter user name : ");
        String user = input.next();
        System.out.println("Enter password : ");
        String pass = input.next();
        customer.showRecords(user, pass);
        System.out.println("For deposit money enter d and for withdraw enter w for no operation enter n : ");
        String op = input.next();
        if (op.equals("d"))
        {
            System.out.println("Enter deposit money : ");
            int amount = input.nextInt();
            int id=customer.extractId(user,pass);
            customer.updateRecords(id,amount+ customer.extractBalance(user,pass));
            customer.showRecords(user,pass);
        }
        else if (op.equals("w"))
        {

        }
    }
}
