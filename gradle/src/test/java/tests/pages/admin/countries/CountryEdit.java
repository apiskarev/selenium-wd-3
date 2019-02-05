package tests.pages.admin.countries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.pages.AbstractPage;

import java.util.List;
import java.util.Set;

public class CountryEdit extends AbstractPage {

    public CountryEdit(WebDriver driver) {
        super(driver);
    }

    public int getExternalLinksSize(){
        return elements(By.cssSelector("i.fa.fa-external-link")).size();
    }

    private String currentWindow;
    private Set<String> currentWindows;
    private String newWindow;

    public CountryEdit clickExternalLinkIcon(int number){
        List<WebElement> links = elements(By.cssSelector("i.fa.fa-external-link"));
        currentWindow = driver.getWindowHandle();
        currentWindows = driver.getWindowHandles();
        links.get(number).click();
        return this;
    }

    public CountryEdit waitForNewPage(){
        wait.until(anyWindowOtherThan(currentWindows));
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows){
            if (!window.equals(currentWindow)) newWindow = window;
        }
        return this;
    }

    public void closeAndReturn(){
        driver.switchTo().window(newWindow);
        driver.close();
        driver.switchTo().window(currentWindow);
    }

}
