public class Bank {

    private int accountNumber;
    private double initialCash;
    private double balance;


    public Bank (double initialCash, int accountNumber) throws Exception {
        if (initialCash < 0) {
            throw new Exception();
            //I can handle this with try catch but ill leave it for testing.
        }
        this.accountNumber = accountNumber;
        balance += initialCash;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit (double cash) {
        try {
            // In case the input was a String or other than double.
            if (cash >= 0) {
                return balance += cash;
                // if its right so we add  it to balance.
            } else {
                // If thar number is less than 0 it will be Exception that will be handled later
                throw new IllegalAccessException();
            }
        } catch (IllegalAccessException e) {
            return 0;
        }
    }
    public double withdraw (double cash){
        try {
            // In case the input was a String or other than double.
            if (cash >= 0) {
                return balance -= cash;
                // if its right so we add  it to balance.
            } else {
                // If thar number is less than 0 it will be Exception that will be handled later
                throw new IllegalAccessException();
            }
        } catch (IllegalAccessException e) {
            return 0;
        }
    }
}
