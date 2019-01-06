package tests.lesson2;

import org.junit.Test;
import tests.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class BasicNavigation extends BaseTest {

    @Test
    public void driverTest(){
        driver.get("https://www.google.com/");
        wait.until(titleIs("Google"));
    }

}
