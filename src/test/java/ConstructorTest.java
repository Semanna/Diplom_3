import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.object.MainPageObject;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    MainPageObject mainPageObject;
    private WebDriver driver;

    @Before
    public void before() {
        driver = DriverFactory.getDriver();
        mainPageObject = new MainPageObject(driver);
    }

    @Test
    @DisplayName("Переход в раздел Начинки")
    public void shouldScrollToFilling() {
        driver.get(MainPageObject.MAIN_PAGE_URL);

        mainPageObject.clickFillingLabel();

        assertTrue(mainPageObject.waitFillingHeaderScrolled());
    }

    @Test
    @DisplayName("Переход в раздел Булки")
    public void shouldScrollToBun() {
        driver.get(MainPageObject.MAIN_PAGE_URL);

        mainPageObject.clickSouseLabel();
        mainPageObject.clickBunLabel();

        assertTrue(mainPageObject.waitBunHeaderScrolled());
    }

    @Test
    @DisplayName("Переход в раздел Соусы")
    public void shouldScrollToSouse() {
        driver.get(MainPageObject.MAIN_PAGE_URL);

        mainPageObject.clickSouseLabel();

        assertTrue(mainPageObject.waitSouseHeaderScrolled());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
