package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObject {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private static final int SCROLL_TOP_Y = 245;
    private final WebDriver driver;
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");
    private static final By PERSONAL_ACCOUNT_BUTTON = By.xpath("//p[text()='Личный Кабинет']");
    private static final By CREATE_ORDER_BUTTON = By.xpath("//button[text()='Оформить заказ']");
    private static final By CONSTRUCTOR_HEADER = By.xpath("//h1[text()='Соберите бургер']");
    private static final By FILLING_LABEL = By.xpath("//span[text()='Начинки']");
    private static final By FILLING_HEADER = By.xpath("//h2[text()='Начинки']");
    private static final By BUN_LABEL = By.xpath("//span[text()='Булки']");
    private static final By BUN_HEADER = By.xpath("//h2[text()='Булки']");
    private static final By SOUSE_LABEL = By.xpath("//span[text()='Соусы']");
    private static final By SOUSE_HEADER = By.xpath("//h2[text()='Соусы']");

    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }

    public boolean isCreateOrderButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 3);

        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_ORDER_BUTTON)).isDisplayed();
        }
        catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isConstructorHeaderDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CONSTRUCTOR_HEADER)).isDisplayed();
    }

    public void clickFillingLabel() {
        driver.findElement(FILLING_LABEL).click();
    }

    public void clickBunLabel() {
        driver.findElement(BUN_LABEL).click();
    }

    public void clickSouseLabel() {
        driver.findElement(SOUSE_LABEL).click();
    }

    public boolean waitFillingHeaderScrolled() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = driver.findElement(FILLING_HEADER);

        return wait.until(driver -> element.getLocation().getY() <= SCROLL_TOP_Y);
    }

    public boolean waitBunHeaderScrolled() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = driver.findElement(BUN_HEADER);

        return wait.until(driver -> element.getLocation().getY() <= SCROLL_TOP_Y);
    }

    public boolean waitSouseHeaderScrolled() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement element = driver.findElement(SOUSE_HEADER);

        return wait.until(driver -> element.getLocation().getY() <= SCROLL_TOP_Y);
    }
}
