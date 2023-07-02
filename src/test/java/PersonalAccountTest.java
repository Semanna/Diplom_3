import io.qameta.allure.junit4.DisplayName;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.object.LoginPageObject;
import page.object.MainPageObject;
import page.object.PersonalAccountPageObject;
import step.LoginSteps;
import step.RegisterSteps;

import static org.junit.Assert.assertTrue;

public class PersonalAccountTest {
    private WebDriver driver;
    private LoginPageObject loginPageObject;
    private MainPageObject mainPageObject;
    private PersonalAccountPageObject personalAccountPageObject;
    private User user;
    private String tokenToDelete;

    @Before
    public void before() {
        driver = DriverFactory.getDriver();

        loginPageObject = new LoginPageObject(driver);
        mainPageObject = new MainPageObject(driver);
        personalAccountPageObject = new PersonalAccountPageObject(driver);

        // Создаем нового пользователя, которого будем использовать в тестах входа в аккаунт
        user = User.random();
        tokenToDelete = RegisterSteps.registerUser(user);
    }

    @Test
    @DisplayName("Переход в личный кабинет и выход из аккаунта")
    public void shouldGoToPersonalAccountPageAndLogout() {
        driver.get(MainPageObject.MAIN_PAGE_URL);

        mainPageObject.clickLoginButton();

        LoginSteps.login(user, loginPageObject);

        mainPageObject.clickPersonalAccountButton();
        assertTrue(personalAccountPageObject.isNameDisplayed(user.getName()));
        assertTrue(personalAccountPageObject.isLoginDisplayed(user.getEmail()));

        personalAccountPageObject.clickLogoutButton();
        assertTrue(loginPageObject.isPageDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на Конструктор")
    public void shouldGoToConstructor() {
        driver.get(MainPageObject.MAIN_PAGE_URL);

        mainPageObject.clickLoginButton();
        LoginSteps.login(user, loginPageObject);

        mainPageObject.clickPersonalAccountButton();

        personalAccountPageObject.clickConstructorLabel();

        assertTrue(mainPageObject.isConstructorHeaderDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    public void shouldGoToConstructorByClickToLogo() {
        driver.get(MainPageObject.MAIN_PAGE_URL);

        mainPageObject.clickLoginButton();
        LoginSteps.login(user, loginPageObject);

        mainPageObject.clickPersonalAccountButton();

        personalAccountPageObject.clickLogo();

        assertTrue(mainPageObject.isConstructorHeaderDisplayed());
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
