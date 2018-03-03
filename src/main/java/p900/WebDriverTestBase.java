package p900;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URI;
import java.net.URL;

public class WebDriverTestBase {
    protected RemoteWebDriver driver;

    @BeforeClass
    public void setUp() throws Exception{
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("chrome");
        browser.setVersion("63.0");
        browser.setCapability("enableVNC", true);
        driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(),browser);
        driver.manage().window().setSize(new Dimension(1920,1080));
    }

    @AfterClass
    public void tearDown(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
