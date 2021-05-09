//Withdraw or deposit
public abstract class Account  {
    protected int accNo;
    protected float amount;

    abstract protected void withdraw(float amnt);

    protected void deposit(float amnt){
        this.amount+=amnt;
    }

    public void printAmount(){
        System.out.println("Current balance: "+this.amount);
    }

}

