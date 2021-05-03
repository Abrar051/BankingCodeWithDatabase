import java.util.Scanner;

public class Debit extends Account {

    public Debit(int accNo, float amount) {
        this.accNo = accNo;
        this.amount = amount;
    }


    protected void withdraw(float amount) {
        if(this.amount < amount)
            return;
        this.amount-=amount;

    }

}
