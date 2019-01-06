package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    protected boolean areElementsPresent(By by){
        return driver.findElements(by).size() > 0;
    }

    protected WebElement element(By by){
        return driver.findElement(by);
    }

    protected List<WebElement> elements(By by){
        return driver.findElements(by);
    }

    @After
    public void stop(){
        if (driver != null) {driver.quit(); driver = null;}
    }

}
