package p900;

import org.testng.annotations.Test;

public class promenuTest extends WebDriverTestBase {
    @Test
    public void openPage(){
        driver.get("http://promenu.ua");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
