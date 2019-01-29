package tests.pages.shopPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        element(By.cssSelector("button[name*=add_cart]")).click();
    }

    private int orderedItemsQuantity = 0;
    private By quantityFieldLocator = By.cssSelector("span.quantity");

    public ProductPage addProductToCart(){
        waitForPageToLoad();
        WebElement quantityField = element(quantityFieldLocator);
        Assert.assertEquals(orderedItemsQuantity, Integer.parseInt(quantityField.getText()));
        if (isSizeSelectionPresent()){
            Select size = new Select(element(sizeSelectorLocator));
            size.selectByIndex(data.getRandomNumber(1, size.getOptions().size()));
        }
        String selectedQuantity = String.valueOf(data.getRandomNumber(1, 10));
        WebElement productQuantityField = element(By.cssSelector("input[type=number]"));
        productQuantityField.clear();
        productQuantityField.sendKeys(selectedQuantity);
        clickSubmitButton();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(quantityFieldLocator,
                String.valueOf(orderedItemsQuantity += Integer.parseInt(selectedQuantity))));
        return this;
    }

    public ProductPage checkProductAdded(){
        WebElement quantityField = element(quantityFieldLocator);
        Assert.assertEquals(orderedItemsQuantity, Integer.parseInt(quantityField.getText()));
        return this;
    }

    public void clickMainButton(){
        element(By.cssSelector("a > img[src*=logo]")).click();
    }

}
