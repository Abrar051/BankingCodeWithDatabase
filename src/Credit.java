import java.util.Scanner;

public class Credit extends Account {

    public Credit(int accNo, float amount) {
        this.accNo = accNo;
        this.amount = amount;
    }

    protected void withdraw(float amount) {
        if(amount > (this.amount+(this.amount/2)))
            return;
        this.amount-=amount;
    }
}
