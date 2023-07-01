import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Drivers {
    public static WebDriver getDriver() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\ASemenova\\yandex\\Webdriver\\bin\\yandexdriver-23.5.0.2204-win\\yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\ASemenova\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options);
    }
}
