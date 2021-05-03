import java.util.Scanner;

public class Registration {
    public String name;
    public String pass;
    public float amount;
    public String type;

    Customer c;

    Scanner input = new Scanner(System.in);

    public void register (int accountNumber)
    {
        System.out.println("Enter name : ");
        name=input.next();
        System.out.println("Enter password : ");
        pass=input.next();
        System.out.println("Enter amount : ");
        amount=input.nextFloat();
        c=new Customer(name,pass,accountNumber);
    }
}
