package tests.pages.admin.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.pages.data.Product;
import tests.pages.AbstractPage;

public class NewProductPage extends AbstractPage {

    private Product product;

    public NewProductPage(WebDriver driver, Product product) {
        super(driver);
        this.product = product;
    }

    public NewProductPage fillGeneralSection(){
        By nameField = By.cssSelector("input[name*='name']");
        element(nameField).sendKeys(product.getName());
        By codeField = By.cssSelector("input[name='code']");
        element(codeField).sendKeys(product.getCode());
        By genderBox = By.xpath("//tr/td[contains(text(), '" + product.getGender() + "')]");
        element(genderBox).click();
        return this;
    }

    public NewProductPage openTab(ProductTab tab){
        By tabLocator = By.xpath("//ul[@class='index']/li[a[contains(text(), '" + tab.getName() + "')]]");
        element(tabLocator).click();
        return this;
    }

    public NewProductPage fillInformationSection(){

        return this;
    }

    public void clickSaveButton(){
        By saveButton = By.cssSelector("button[name='save']");
        element(saveButton).click();
    }


}
