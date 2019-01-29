package tests.pages.shopPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.pages.AbstractPage;

public class Checkout extends AbstractPage {

    public Checkout(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait waitForNoItems = new WebDriverWait(super.driver, 2);

    public Checkout removeProduct(int actions){
        for (int i = 0; i < actions; i++){
            By removeButton = By.xpath("(//button[@name='remove_cart_item'])[1]");
            WebElement summaryTable = element(By.id("box-checkout-summary"));
            wait.until(ExpectedConditions.visibilityOf(element(removeButton)));
            element(removeButton).click();
            try {
                waitForNoItems.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("em"), "There are no items in your cart."));
                return this;
            } catch (Exception ignored){
                wait.until(ExpectedConditions.stalenessOf(summaryTable));
            }
        }
        return this;
    }
}
