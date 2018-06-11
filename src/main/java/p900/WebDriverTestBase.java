package p900;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URI;

public class WebDriverTestBase {
    protected RemoteWebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        String runType = "selenoid";
        switch (runType) {
            case ("local"):
                Configuration.browser = "chrome";
                break;
            case ("selenoid"):
                DesiredCapabilities browser = new DesiredCapabilities();
                browser.setBrowserName("chrome");
                browser.setVersion("66");
                browser.setCapability("enableVNC", true);
                driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), browser);
                driver.manage().window().setSize(new Dimension(1920, 1080));
                WebDriverRunner.setWebDriver(driver);
                break;
        }

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}