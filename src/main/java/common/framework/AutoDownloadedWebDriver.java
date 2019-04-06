package common.framework;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoDownloadedWebDriver implements DriverSource {
    public enum WebBrowsers {
        CHROME
    }

    private BaseConfiguration baseConfiguration = new BaseConfiguration();

    @Override
    public WebDriver newDriver() {
        WebBrowsers browserType = WebBrowsers.valueOf(baseConfiguration.getProperty("browser"));

        switch (browserType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\KG\\Desktop\\N11\\chromedriver.exe");
                ChromeDriver driver = new ChromeDriver();
                driver.manage().window().maximize();

                return driver;

            default:
                return null;
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
