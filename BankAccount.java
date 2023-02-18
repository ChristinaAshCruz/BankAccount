import java.util.Random;

public class BankAccount{
    Random randGenerator = new Random();

    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;

    // static methods
    private static int numOfAccounts = 0;
    private static double accountTotal = 0;

    // class methods
    public BankAccount(double checkingBalance, double savingsBalance){
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.accountNumber = generateRandomAccountNumber();
        numOfAccounts++;
        accountTotal = accountTotal + checkingBalance + savingsBalance;
    }

    // private char getRandomAccountNumber(){
    //     return randResult;
    // }
    
    private String generateRandomAccountNumber(){
        String randLetterAndNumberString = "123456789";
        char randResult = randLetterAndNumberString.charAt(randGenerator.nextInt(10));
        String accountNumberResult = "";
        for(int id = 0; id <= 10; id++){
            accountNumberResult = accountNumberResult + randResult;
        }
        return accountNumberResult;
    }
    
    public String getAccountNumber(){
        return accountNumber;
    }
    // public String setAccountNumber(){
    //     accountNumber = generateRandomAccountNumber();
    //     return accountNumber;

    // }
    // getters and setters
    public int getNumOfAccounts(){
        return numOfAccounts;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public void setCheckingBalance(double newCheckingBalance){
        checkingBalance = newCheckingBalance;
    }
    
    public double getSavingsBalance(){
        return savingsBalance;
    }

    public void setSavingsBalance(double newSavingsBalance){
        savingsBalance = newSavingsBalance;
    }

    // other methods
    public void deposit(double depositAmount, String accountName){
        accountTotal = accountTotal + depositAmount;
        if (accountName == "checking"){
            checkingBalance = checkingBalance + depositAmount;
        }
        else {
            savingsBalance = savingsBalance + depositAmount;
        }
        
    }
    
    public void withdrawal(double withdrawalAmount, String accountName){
        accountTotal = accountTotal - withdrawalAmount;
        if (accountName == "checking"){
            if (checkingBalance - withdrawalAmount <= 0){
                String withdrawError = String.format("You cannot withdraw more money than you have in your %s account!", accountName);
                System.out.println(withdrawError);
            }
            checkingBalance = checkingBalance - withdrawalAmount;
        }
        else {
            if (savingsBalance - withdrawalAmount <= 0){
                String withdrawError = String.format("You cannot withdraw more money than you have in your %s account!", accountName);
                System.out.println(withdrawError);
            }
            savingsBalance = savingsBalance - withdrawalAmount;
        }
        
    }

    public String getTotalFromAccounts(){
        String totalMessage = String.format("Checking and Saving Total: $%.2f", accountTotal);
        return totalMessage;
    }
    
    public void display(){
        String checkingMessage = String.format("Checking: $%.2f", getCheckingBalance());
        String savingsMessage = String.format("Savings: $%.2f", getSavingsBalance());
        String accountNumberMessage = String.format("Account Number: %s", getAccountNumber());

        System.out.println("----------USER INFO TEST----------");
        System.out.println(checkingMessage);
        System.out.println(savingsMessage);
        System.out.println(accountNumberMessage);
    }
}