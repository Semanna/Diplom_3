package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject {
    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    private final WebDriver driver;
    private static final By NAME_INPUT = By.xpath(
            "//label[@class='input__placeholder text noselect text_type_main-default' and text()='Имя']/parent::div/input");
    private static final By EMAIL_INPUT = By.xpath(
            "//label[@class='input__placeholder text noselect text_type_main-default' and text()='Email']/parent::div/input");

    private static final By PASSWORD_INPUT = By.xpath("//input[@type='password']");
    private static final By INVALID_PASSWORD_LABEL = By.xpath("//p[text()='Некорректный пароль']");
    private static final By REGISTER_BUTTON = By.xpath("//button[text()='Зарегистрироваться']");
    private static final By LOGIN_BUTTON = By.xpath("//a[text()='Войти']");

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(NAME_INPUT).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void setPassword(String pass) {
        driver.findElement(PASSWORD_INPUT).sendKeys(pass);
    }

    public boolean isInvalidPasswordDisplayed() {
        return driver.findElement(INVALID_PASSWORD_LABEL).isDisplayed();
    }

    public void clickRegisterButton() {
        driver.findElement(REGISTER_BUTTON).click();
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
