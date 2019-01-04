import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    boolean areElementsPresent(By by){
        return driver.findElements(by).size() > 0;
    }

    @After
    public void stop(){
        if (driver != null) {driver.quit(); driver = null;}
    }

}
