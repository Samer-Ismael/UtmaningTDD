package test;
import Bank.Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BankTestExtra {

    private Bank bank;
    @BeforeEach // To make this method run before each test method.
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
            "150, 250",
            "1000, 1100",
            "-500, 100",
            "0.5, 100.5",
            "0.0, 100.0",
            "-25, 100",
            "75, 175",
            "200, 300",
            "50.5, 150.5",
            "0.1, 100.1",
            "0.9, 100.9",
            "-100, 100",
            "99.99, 199.99"
    })
    // The name of the tests... to show it in consul
    @DisplayName("depositTesting")
    public void testDeposit(double amount, double expected) {
        // Arrange is expected
        // Akt
        bank.deposit(amount);
        // Assert
        Assertions.assertEquals(expected, bank.getBalance(), 0.0);
    }

    @ParameterizedTest
    @CsvSource({
            "50, 50",
            "0, 100",
            "150, 100",
            "400, 100",
            "75, 25",
            "25, 75",
            "100, 0",
            "99, 1",
            "101, 100",
            "50.5, 49.5",
            "49.5, 50.5",
            "0.5, 99.5",
            "0.1, 99.9",
            "0.9, 99.1",
            "100.5, 100",
            "0.0, 100.0"
    })
    @DisplayName("withdrawTesting")
    public void testWithdraw(double amount, double expected) {
        bank.withdraw(amount);
        Assertions.assertEquals(expected, bank.getBalance(), 0.0);
    }
}