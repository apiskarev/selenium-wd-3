package tests.pages.admin.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import tests.pages.AbstractPage;
import tests.pages.data.MainData;

public class ProductPage extends AbstractPage {

    private MainData data;

    public ProductPage(WebDriver driver) {
        super(driver);
        data = new MainData();
    }

    private void waitForPageToLoad(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("h1"), 0));
    }

    private By sizeSelectorLocator = By.cssSelector("select[name*=Size]");

    private boolean isSizeSelectionPresent(){
        return isElementPresent(sizeSelectorLocator);
    }

    private void clickSubmitButton(){
        element(By.cssSelector("button[name=*add_cart]"));
    }

    public ProductPage addProductToCart(){
        waitForPageToLoad();
        if (isSizeSelectionPresent()){
            Select size = new Select(element(sizeSelectorLocator));
            size.selectByIndex(data.getRandomNumber(1, size.getOptions().size()));
        }
        element(By.cssSelector("input[type=number]")).sendKeys(String.valueOf(data.getRandomNumber(1, 10)));
        clickSubmitButton();
        return this;
    }

    public void clickMainButton(){
        element(By.cssSelector("a > img[src*=logo]")).click();
    }

}
