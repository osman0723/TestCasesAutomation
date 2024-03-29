package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if(webDriver.get() == null){
            try {
                webDriver.set(createDriver());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return webDriver.get();
    }
    private static String getBrowseType() throws IOException {
        String browserType = null;
        String browserTypeRemoteValue = System.getProperty("browserType");

        try {
            if(browserTypeRemoteValue==null || browserTypeRemoteValue.isEmpty()) {
                Properties properties = new Properties();
                FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
                properties.load(file);
                browserType = properties.getProperty("browser").toLowerCase().trim();
            }else {
                browserType = browserTypeRemoteValue;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return browserType;
    }
    private static WebDriver createDriver() throws IOException {
        WebDriver driver = null;

        switch (getBrowseType()){
            case "chrome" : {
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/java/driver/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);

                break;
            }
            case "firefox" : {
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/main/java/driver/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);

                break;
            }

        }
        driver.manage().window().maximize();
        return driver;
    }
    public static void cleanupDriver(){
    webDriver.get().quit();
    webDriver.remove();
    }

}
