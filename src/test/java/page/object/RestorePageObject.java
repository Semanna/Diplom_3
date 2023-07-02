package page.object;

import org.openqa.selenium.WebDriver;

public class RestorePageObject {
    private final WebDriver driver;

    public static final String RESTORE_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    public RestorePageObject(WebDriver driver) {
        this.driver = driver;
    }
}
