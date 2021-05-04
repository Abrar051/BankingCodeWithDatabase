import  java.util.*;

public class UserInterface {
    private static int option;
    public static String name;
    public static float amount;
    public static String password;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Registration user = new Registration();
        DatabaseCreateDelete data = new DatabaseCreateDelete();
        DatabaseManagement customer = new DatabaseManagement();
        data.CreateDatabase();
        customer.createTable();
        customer.insertRecords(1,"user","password", 23.45);
        customer.insertRecords(2,"user2","password",24.5);
        customer.showRecords();
        data.DropDatabase();
    }
}
