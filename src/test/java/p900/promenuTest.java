package p900;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class promenuTest extends WebDriverTestBase {
    @Test
    public void openPage(){
        open("http://promenu.ua");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
