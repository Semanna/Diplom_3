package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPageObject {
    private final WebDriver driver;

    private final By logoutButton = By.xpath("//button[text()='Выход']");
    private final By constructorLabel = By.xpath("//p[text()='Конструктор']");
    private final By logo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

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
        driver.findElement(logoutButton).click();
    }

    public void clickConstructorLabel() {
        driver.findElement(constructorLabel).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }
}
