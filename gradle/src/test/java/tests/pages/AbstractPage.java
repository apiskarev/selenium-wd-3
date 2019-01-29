package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AbstractPage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    protected boolean areElementsPresent(By by){
        return driver.findElements(by).size() > 0;
    }

    protected boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    protected WebElement element(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    protected List<WebElement> elements(By by){
        return driver.findElements(by);
    }

    protected void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception ignored){}
    }
}
