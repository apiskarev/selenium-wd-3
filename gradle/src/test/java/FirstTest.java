import org.junit.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest extends BaseTest{

    @Test
    public void first(){
        driver.get("https://www.google.com/");
        wait.until(titleIs("Google"));
    }

}
