import java.util.*;

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
        customer.createSavingTable();
        int primaryAccountNum = 1;
        while (true) {
            System.out.println(" Enter r for registration , s for signup and b for break : ");
            String s = input.next();
            if (s.equals("r")) {
                user.register(primaryAccountNum);
            } else if (s.equals("s")) {
                user.signUp();
            } else if (s.equals("b")) {
                break;
            }
            primaryAccountNum++;
        }

        data.DropDatabase();
    }
}
