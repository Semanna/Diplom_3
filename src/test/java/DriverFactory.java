import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Optional;

public class DriverFactory {
    public static WebDriver getDriver() {

        String browser = Optional.ofNullable(System.getenv("browser"))
                .orElse("chrome");

        switch (browser) {
            case "yandex": return getYandex();
            case "chrome": return getChrome();
            default: throw new RuntimeException("Необходимо указать название браузера через переменную окружения BROWSER");
        }
    }

    private static WebDriver getYandex() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\ASemenova\\yandex\\Webdriver\\bin\\yandexdriver-23.5.0.2204-win\\yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\ASemenova\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("--remote-allow-origins=*");

        return new ChromeDriver(options);
    }

    private static WebDriver getChrome() {
        return new ChromeDriver();
    }
}
