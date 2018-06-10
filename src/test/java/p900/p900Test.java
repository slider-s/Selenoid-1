package p900;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class p900Test extends WebDriverTestBase{
    @Test
    public void openPage(){
        open("http://p900.com.ua");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
