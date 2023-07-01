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
    RegisterPageObject registerPageObject;
    LoginPageObject loginPageObject;
    private WebDriver driver;

    @Test
    @DisplayName("Успешная регистрация")
    public void shouldRegisterNewUser() {
        User user = User.random();

        driver.get(RegisterPageObject.URL);
        RegisterSteps.register(user, registerPageObject);

        loginPageObject.waitPageLoads();
    }

    @Test
    @DisplayName("Ошибка регистрации, если  пароль меньше шести символов")
    public void shouldNotRegisterNewUserWhenPasswordIsLessThan6() {
        User user = User.random();
        user.setPassword(user.getPassword().substring(0, 5));

        driver.get(RegisterPageObject.URL);
        RegisterSteps.register(user, registerPageObject);

        assertTrue(registerPageObject.isInvalidPasswordDisplayed());
    }

    @Before
    public void before() {
        driver = Drivers.getDriver();

        registerPageObject = new RegisterPageObject(driver);
        loginPageObject = new LoginPageObject(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
