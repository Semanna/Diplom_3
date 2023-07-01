package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject {
    public static final String URL = "https://stellarburgers.nomoreparties.site/register";
    private final WebDriver driver;
    private final By nameInput = By.xpath(
            "//label[@class='input__placeholder text noselect text_type_main-default' and text()='Имя']/parent::div/input");
    private final By emailInput = By.xpath(
            "//label[@class='input__placeholder text noselect text_type_main-default' and text()='Email']/parent::div/input");

    private final By passwordInput = By.xpath(
            "//input[@type='password']");

    private final By invalidPasswordLabel = By.xpath(
            "//p[text()='Некорректный пароль']");

    private final By registerButton = By.xpath(
            "//button[text()='Зарегистрироваться']");

    private final By loginButton = By.xpath(
            "//a[text()='Войти']");

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String pass) {
        driver.findElement(passwordInput).sendKeys(pass);
    }

    public boolean isInvalidPasswordDisplayed() {
        return driver.findElement(invalidPasswordLabel).isDisplayed();
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
