package p900;

import org.testng.annotations.Test;

public class p900Test extends WebDriverTestBase{
    @Test
    public void openPage(){
        driver.get("http://p900.com.ua");
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
