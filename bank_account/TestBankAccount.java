public class TestBankAccount{
    public static void main(String[] args){
        BankAccount testAcc = new BankAccount();
        testAcc.deposit("checking",500);
        testAcc.deposit("savings",500);
        testAcc.withdraw("checking", 200);
        testAcc.withdraw("savings", 250);
        System.out.println(testAcc.getSavingsAccount());
        System.out.println(testAcc.getCheckingAccount());
        System.out.println(testAcc.getTotalMoney());
        System.out.println(testAcc.getNumOfAccounts());
    }
}