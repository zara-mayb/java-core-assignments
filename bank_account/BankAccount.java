public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int numOfAccounts = 0;
    private static double totalMoney = 0;

    //increment account count
    public BankAccount(){
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        numOfAccounts++;
    }
    //getter for checking account
    public double getCheckingAccount(){
        return checkingBalance;
    }
    //getter for savings account
    public double getSavingsAccount(){
        return savingsBalance;
    }
    //method to deposit
    public void deposit(String accountType, double amount ){
        if(accountType == "checking"){
            checkingBalance += amount;
        }
        else if(accountType == "savings"){
            savingsBalance += amount;
        }
        totalMoney = checkingBalance + savingsBalance;
    }
    //method to withdraw
    public void withdraw(String accountType, double amount){
        if(amount > totalMoney){
            System.out.println("insufficient funds");
        }
        else if(accountType == "checking"){
            checkingBalance -= amount;
        }
        else if(accountType == "savings"){
            savingsBalance -= amount;
        }
        totalMoney -= amount;
    }
    //method to check amount in checkings
    public double getTotalMoney(){
        return checkingBalance + savingsBalance;
    }
    public int getNumOfAccounts(){
        return numOfAccounts;
    }
}