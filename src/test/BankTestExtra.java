package test;
import Bank.Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

class BankTestExtra {

    private Bank bank;
    @BeforeEach // this is to make it run before each test method.
    public void setup() throws Exception {
        double initialCash = 100.0;
        int accountNumber = 1;

        bank = new Bank(initialCash, accountNumber);
    }

    @ParameterizedTest// To tell that the method will run more than one time with different values.
    @CsvSource({
            // First number to run the deposit method
            // and second number is the Expected value
            "50, 150",
            "0, 100",
            "-50, 100",
            "150, 250"
    })
    // The name of the tests... to show it in consul
    @DisplayName("depositTesting")
    public void testDeposit(double amount, double expected) {
        bank.deposit(amount);
        Assertions.assertEquals(expected, bank.getBalance(), 0.0);
    }

    @ParameterizedTest
    @CsvSource({
            "50, 50",
            "0, 100",
            "150, 100",
            "400, 100"
    })
    @DisplayName("withdrawTesting")
    public void testWithdraw(double amount, double expected) {
        bank.withdraw(amount);
        Assertions.assertEquals(expected, bank.getBalance(), 0.0);
    }
}