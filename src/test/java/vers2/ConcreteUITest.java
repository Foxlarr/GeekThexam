package vers2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConcreteUITest extends UITest {

    @Test
    void testGBNotEmailLogin() {
        loginPage.open();
        loginPage.login("login", "password");
        Assertions.assertFalse(loginPage.isErrorVisible());
    }

    @Test
    void testGBWithoutPassword() {
        loginPage.open();
        loginPage.login("login@login.ru", "");
        Assertions.assertFalse(loginPage.isErrorVisible());
    }
}
