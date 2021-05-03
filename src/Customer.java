import java.util.Scanner;
public class Customer  {
    private String name;
    private String pass;
    private int accNo;

    public Customer(String name, String pass, int accNo) {
        this.name = name;
        this.pass = pass;
        this.accNo = accNo;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

