package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
    private final WebDriver driver;

    private final By loginHeader = By.xpath("//h2[text()='Вход']");
    private final By emailInput = By.xpath(
            "//label[@class='input__placeholder text noselect text_type_main-default' and text()='Email']/parent::div/input");
    private final By passwordInput = By.xpath(
            "//input[@type='password']");

    private final By loginButton = By.xpath(
            "//button[text()='Войти']");

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword(String pass) {
        driver.findElement(passwordInput).sendKeys(pass);
    }

    public void waitPageLoads() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader));
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
