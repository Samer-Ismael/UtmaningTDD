import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank sut = new Bank(100,1);

    BankTest() throws Exception {

    }

    @Test
    void testConstructorMinus (){

        //assertThrows can test Exception, and it will pass if it happens.
        //I had try catch in the method, so it will be not Exceptions, that's y I have it in comment.
        //It takes the Exception class and a lambda that will run the method you want to test.
        assertThrows(Exception.class,
                () -> {
            Bank test = new Bank(-1,1);
                });
    }

    @Test
    void depositAddPlus() {
        // Arrange
        double expected = 150;
        // Akt
        double actual = sut.deposit(50);
        // Assert
        assertEquals(expected,actual);
    }

    @Test
    void depositAddMinus(){
        // Arrange
        double expected = 0;
        // Akt
        double actual = sut.deposit(-50);
        // Assert
        assertEquals(expected,actual);
    }
    @Test
    void depositAddZero() {
        assertEquals(100,sut.deposit(0));
    }
    @Test
    void withdrawPlus() {
        // Arrange
        double expected = 50;
        // Akt
        double actual = sut.withdraw(50);
        // Assert
        assertEquals(expected,actual);
    }
    @Test
    void withdrawMinus(){
        assertEquals(0,sut.withdraw(-50));
    }
    @Test
    void withdrawZero() {
        assertEquals(100, sut.withdraw(0));
    }
}