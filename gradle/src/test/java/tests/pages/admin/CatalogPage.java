package tests.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.pages.AbstractPage;
import tests.pages.data.Product;

public class CatalogPage extends AbstractPage {

    private Product product;

    public CatalogPage(WebDriver driver, Product product){
        super(driver);
        this.product = product;
    }

    public void clickAddNewProductLink(){
        element(By.xpath("//a[@class='button'][contains(text(), 'Product')]")).click();
    }

    private void waitForPageToLoad(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("tr.footer"), 0));
    }

    public void assertProductAdded(){
        waitForPageToLoad();
        if (product.isEnabled()){
            assert areElementsPresent(By.xpath("//tr[@class='row']/td/a[contains(text(), '" + product.getName() + "')]"));
        } else {
            assert areElementsPresent(By.xpath("//tr[@class='row semi-transparent']/td/a[contains(text(), '" + product.getName() + "')]"));
        }
    }

}
