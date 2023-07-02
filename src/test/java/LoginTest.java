import io.qameta.allure.junit4.DisplayName;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.object.LoginPageObject;
import page.object.MainPageObject;
import page.object.RegisterPageObject;
import page.object.RestorePageObject;
import step.LoginSteps;
import step.RegisterSteps;

import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private RegisterPageObject registerPageObject;
    private LoginPageObject loginPageObject;
    private MainPageObject mainPageObject;
    private User user;
    private String tokenToDelete;

    @Before
    public void before() {
        driver = DriverFactory.getDriver();

        loginPageObject = new LoginPageObject(driver);
        mainPageObject = new MainPageObject(driver);
        registerPageObject = new RegisterPageObject(driver);

        // Создаем нового пользователя, которого будем использовать в тестах входа в аккаунт
        user = User.random();
        tokenToDelete = RegisterSteps.registerUser(user);
    }

    @Test
    @DisplayName("Вход по кнопке Войти в аккаунт на главной")
    public void shouldLoginFromMainMage() {
        driver.get(MainPageObject.MAIN_PAGE_URL);

        mainPageObject.clickLoginButton();

        LoginSteps.login(user, loginPageObject);

        assertTrue(mainPageObject.isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку Личный кабинет")
    public void shouldLoginFromPersonalAccountButton() {
        driver.get(MainPageObject.MAIN_PAGE_URL);

        mainPageObject.clickPersonalAccountButton();

        LoginSteps.login(user, loginPageObject);

        assertTrue(mainPageObject.isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void shouldLoginFromRegisterPage() {
        driver.get(RegisterPageObject.REGISTER_PAGE_URL);

        registerPageObject.clickLoginButton();

        LoginSteps.login(user, loginPageObject);

        assertTrue(mainPageObject.isCreateOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void shouldLoginFromRestorePasswordPage() {
        driver.get(RestorePageObject.RESTORE_PAGE_URL);

        registerPageObject.clickLoginButton();

        LoginSteps.login(user, loginPageObject);

        assertTrue(mainPageObject.isCreateOrderButtonDisplayed());
    }

    @After
    public void teardown() {
        driver.quit();

        if (tokenToDelete != null) {
            RegisterSteps.deleteUser(tokenToDelete);
            tokenToDelete = null;
        }
    }
}
