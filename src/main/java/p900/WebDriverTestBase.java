package p900;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class WebDriverTestBase {
    protected RemoteWebDriver driver;

    @Parameters({"browserName", "browserVersion"})
    @BeforeClass
    public void setUp(@Optional String browserName, @Optional String browserVersion) throws Exception{
        DesiredCapabilities browser = new DesiredCapabilities();
            browser.setBrowserName(browserName);
            browser.setVersion(browserVersion);
            browser.setCapability("enableVNC", true);
        if (browserName.equals("opera")){
            Map<String, Object> hashmap = new HashMap<String, Object>();
            hashmap.put("binary", "/usr/bin/opera");
            browser.setCapability("operaOptions", hashmap);
        }
            driver = new RemoteWebDriver(URI.create("http://18.197.43.132:4444/wd/hub").toURL(), browser);
            driver.manage().window().setSize(new Dimension(1920, 1080));

    }

    @AfterClass
    public void tearDown(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
