public class BankAccount {


    private String name;
    private Double accountBalance;
    private Integer accountId;



    public BankAccount( String name, double accountBalance, Integer accountId){
        this.name = name;
        this.accountBalance= accountBalance;
        this.accountId = accountId;
    }

    public BankAccount(){
    }

    public String getAccountName(){
        return this.name;
    }

    public void setAccountName(String name){
        this.name = name;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Integer getAccountId() {
        return accountId;
    }
    public void deposit(double depositAmount){
        this.accountBalance += depositAmount;
        System.out.println("Your account deposit " + depositAmount + " balance: $"+ this.accountBalance);
    }

    public void withdrawal(double withdrawalAmount){
        this.accountBalance -= withdrawalAmount;
        System.out.println("Your account after " + withdrawalAmount + " withdrawal balance: $"+ this.accountBalance);
    }

    public void accountInfo(String accountName, double deposit){
        this.name = name;
        this.accountBalance = accountBalance;
        System.out.println(this.name + "'s" + " account balance: " + this.accountBalance);
    }
    @Override
    public String toString (){
        return this.name +" " + this.accountBalance + " " +  this.accountId;
    }

    public BankAccount get(int i) {
        return null;
    }

    public void transfer(BankAccount bankAccount, double transferAmount) {
    }

    public int size() {
        return 0;
    }
}
