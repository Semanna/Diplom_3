package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
    private final WebDriver driver;

    private static final By LOGIN_HEADER = By.xpath("//h2[text()='Вход']");
    private static final By EMAIL_INPUT = By.xpath(
            "//label[@class='input__placeholder text noselect text_type_main-default' and text()='Email']/parent::div/input");
    private static final By PASSWORD_INPUT = By.xpath("//input[@type='password']");

    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти']");

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void setPassword(String pass) {
        driver.findElement(PASSWORD_INPUT).sendKeys(pass);
    }

    public boolean isPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_HEADER)).isDisplayed();
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}
