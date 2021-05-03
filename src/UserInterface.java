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
        customer.insertRecords();
        customer.showRecords();
        data.DropDatabase();
    }
}
