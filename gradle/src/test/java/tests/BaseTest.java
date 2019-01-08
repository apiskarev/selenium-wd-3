package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.remote.BrowserType.*;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private WebDriver getDriver(String browser){
        switch (browser){
            case CHROME: default:
                return new ChromeDriver();
            case FIREFOX:
                FirefoxOptions options = new FirefoxOptions().setLegacy(false);
                options.setCapability("marionette", true);
                return new FirefoxDriver(options);
            case IE:
                return new InternetExplorerDriver();
        }
    }

    @Before
    public void start(){
        driver = getDriver(CHROME);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    protected void openLiteCart(){
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.product")));
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
