import java.util.Scanner;
public  class Savings extends Account {

    private float limit;

    public Savings(int accNo, float amount, float limit) {
        this.accNo = accNo;
        this.amount = amount;
        this.limit = limit;
    }


    protected void withdraw(float amount) {
        if(amount > this.limit)
            return;
        this.amount-=amount;
    }

}
