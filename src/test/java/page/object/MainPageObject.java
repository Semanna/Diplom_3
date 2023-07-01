package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObject {

    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    private static final int SCROLL_TOP_Y = 245;
    private final WebDriver driver;
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By createOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By constructorHeader = By.xpath("//h1[text()='Соберите бургер']");
    private final By fillingLabel = By.xpath("//span[text()='Начинки']");
    private final By fillingHeader = By.xpath("//h2[text()='Начинки']");
    private final By bunLabel = By.xpath("//span[text()='Булки']");
    private final By bunHeader = By.xpath("//h2[text()='Булки']");
    private final By souseLabel = By.xpath("//span[text()='Соусы']");
    private final By souseHeader = By.xpath("//h2[text()='Соусы']");


    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public void waitCreateOrderButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    }

    public boolean isConstructorHeaderDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(constructorHeader)).isDisplayed();
    }

    public void clickFillingLabel() {
        driver.findElement(fillingLabel).click();
    }

    public void clickBunLabel() {
        driver.findElement(bunLabel).click();
    }

    public void clickSouseLabel() {
        driver.findElement(souseLabel).click();
    }

    public void waitFillingHeaderScrolled() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = driver.findElement(fillingHeader);

        wait.until(driver -> element.getLocation().getY() <= SCROLL_TOP_Y);
    }

    public void waitBunHeaderScrolled() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = driver.findElement(souseHeader);

        wait.until(driver -> element.getLocation().getY() <= SCROLL_TOP_Y);
    }

    public void waitSouseHeaderScrolled() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = driver.findElement(souseHeader);

        wait.until(driver -> element.getLocation().getY() <= SCROLL_TOP_Y);
    }
}
