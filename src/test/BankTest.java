package test;
import Bank.Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank sut = new Bank(100,1);

    BankTest() throws Exception {

    }

    @Test
    void constructorShouldThrowExceptionForNegativeInitialCash (){

        //assertThrows can test Exception, and it will pass if it happens.
        //I had try catch in the method, so it will be not Exceptions, that's y I have it in comment.
        //It takes the Exception class and a lambda that will run the method you want to test.
        assertThrows(Exception.class,
                () -> {
            Bank test = new Bank(-1,1);
                });
    }

    @Test
    void depositShouldAddPositiveAmountToBalance() {
        // Arrange
        double expected = 150;
        // Akt
        sut.deposit(50.0);
        // Assert
        Assertions.assertEquals(expected, sut.getBalance());
    }
    @Test
    void depositNullInputShouldNotCrash() {
        // Arrange
        Double cash = null;
        // Act
        double result = 0;
        try {
            sut.deposit(cash);
        } catch (Exception e) {
            // Exception occurred, set result to -1 as an indicator
            result = -1;
        }
        // Assert
        Assertions.assertEquals(100, sut.getBalance());
        assertEquals(-1, result);
    }
    @Test
    void depositShouldNotAddNegativeAmountToBalance(){
        sut.deposit(-50);
        Assertions.assertEquals(100, sut.getBalance());
    }
    @Test
    void depositShouldNotAddZeroAmountToBalance() {
        sut.deposit(0);
        Assertions.assertEquals(100, sut.getBalance());
    }
    @Test
    void withdrawNullShouldNotCrash (){
        Double cash = null;
        double result = 0;
        try {
            sut.withdraw(cash);
        } catch (Exception e) {
            result = -1;
        }
        Assertions.assertEquals(100, sut.getBalance());
        assertEquals(-1, result);
    }
    @Test
    void withdrawShouldSubtractPositiveAmountFromBalance() {
        sut.withdraw(50);
        Assertions.assertEquals(50, sut.getBalance());
    }
    @Test
    void withdrawShouldNotSubtractNegativeAmountFromBalance(){
        sut.withdraw(-50);
        Assertions.assertEquals(100,sut.getBalance());
    }
    @Test
    void withdrawShouldNotSubtractZeroAmountFromBalance() {
        sut.withdraw(0);
        Assertions.assertEquals(100,sut.getBalance());
    }
}