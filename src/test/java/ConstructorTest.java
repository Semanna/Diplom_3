import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.object.MainPageObject;

public class ConstructorTest {
    MainPageObject mainPageObject;
    private WebDriver driver;

    @Test
    @DisplayName("Переход в раздел Начинки")
    public void shouldScrollToFilling() {
        driver.get(MainPageObject.URL);

        mainPageObject.clickFillingLabel();
        mainPageObject.waitFillingHeaderScrolled();

        mainPageObject.clickBunLabel();
        mainPageObject.waitBunHeaderScrolled();

        mainPageObject.clickSouseLabel();
        mainPageObject.waitSouseHeaderScrolled();
    }

    @Before
    public void before() {
        driver = Drivers.getDriver();
        mainPageObject = new MainPageObject(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
