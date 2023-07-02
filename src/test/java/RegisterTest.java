import io.qameta.allure.junit4.DisplayName;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.object.LoginPageObject;
import page.object.RegisterPageObject;
import step.RegisterSteps;

import static org.junit.Assert.assertTrue;

public class RegisterTest {
    private RegisterPageObject registerPageObject;
    private LoginPageObject loginPageObject;
    private WebDriver driver;
    private User user;

    @Before
    public void before() {
        driver = DriverFactory.getDriver();

        registerPageObject = new RegisterPageObject(driver);
        loginPageObject = new LoginPageObject(driver);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void shouldRegisterNewUser() {
        user = User.random();

        driver.get(RegisterPageObject.REGISTER_PAGE_URL);
        RegisterSteps.registerUser(user, registerPageObject);

        assertTrue(loginPageObject.isPageDisplayed());
    }

    @Test
    @DisplayName("Ошибка регистрации, если пароль меньше шести символов")
    public void shouldNotRegisterNewUserWhenPasswordIsLessThan6() {
        User user = User.random();
        user.setPassword(user.getPassword().substring(0, 5));

        driver.get(RegisterPageObject.REGISTER_PAGE_URL);
        RegisterSteps.registerUser(user, registerPageObject);

        assertTrue(registerPageObject.isInvalidPasswordDisplayed());
    }

    @After
    public void teardown() {
        driver.quit();
        if (user != null) {
            RegisterSteps.deleteUser(user);
        }
    }
}
