package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPageObject {
    private final WebDriver driver;

    private static final By LOGOUT_BUTTON = By.xpath("//button[text()='Выход']");
    private static final By CONSTRUCTOR_LABEL = By.xpath("//p[text()='Конструктор']");
    private static final By LOGO = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    public PersonalAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNameDisplayed(String name) {
        By nameInput = By.xpath(
                "//input[@value='" + name + "']");

        WebDriverWait wait = new WebDriverWait(driver, 3);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput)).isDisplayed();
    }

    public boolean isLoginDisplayed(String login) {
        By loginInput = By.xpath(
                "//input[@value='" + login + "']");

        WebDriverWait wait = new WebDriverWait(driver, 3);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginInput)).isDisplayed();
    }

    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

    public void clickConstructorLabel() {
        driver.findElement(CONSTRUCTOR_LABEL).click();
    }

    public void clickLogo() {
        driver.findElement(LOGO).click();
    }
}
