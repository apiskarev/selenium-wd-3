package tests.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.pages.AbstractPage;

public class CatalogPage extends AbstractPage {

    public CatalogPage(WebDriver driver){
        super(driver);
    }

    public void clickAddNewProductLink(){
        element(By.xpath("//a[@class='button'][contains(text(), 'Product')]")).click();
    }
}
