import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    private WebDriver driver;

    @Before
    public void setDriver(){
        //ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle(){
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @After
    public void tearDown(){
        if (driver != null) driver.quit();
    }
}
