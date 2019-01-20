package tests.pages.admin.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import tests.pages.AbstractPage;
import tests.pages.data.Product;

import java.util.List;

public class NewProductPage extends AbstractPage {

    private Product product;

    public NewProductPage(WebDriver driver, Product product) {
        super(driver);
        this.product = product;
    }

    public NewProductPage fillGeneralSection(){
        By enabledSelectors = By.cssSelector("input[type=radio]");
        List<WebElement> enabled = elements(enabledSelectors);
        if (product.isEnabled()) {
            if (!enabled.get(0).isSelected()) enabled.get(0).click();
        }
         else {
             if (!enabled.get(1).isSelected()) enabled.get(1).click();
        }

        By nameField = By.cssSelector("input[name*='name']");
        element(nameField).sendKeys(product.getName());

        By codeField = By.cssSelector("input[name='code']");
        element(codeField).sendKeys(product.getCode());

        By genderBox = By.xpath("//tr/td[contains(text(), '" + product.getGender() + "')]/..//./input");
        element(genderBox).click();

        By quantityField = By.cssSelector("input[name=quantity]");
        element(quantityField).clear();
        element(quantityField).sendKeys(String.valueOf(product.getQuantity()));

        By addImage = By.cssSelector("input[name*=new_images]");
        element(addImage).sendKeys(product.getProductImagePath());

        By validFrom = By.cssSelector("input[name*=valid_from]");
        element(validFrom).sendKeys(product.getDateFrom());

        By validTo = By.cssSelector("input[name*=valid_to]");
        element(validTo).sendKeys(product.getDateTo());
        return this;
    }

    public NewProductPage openTab(ProductTab tab){
        By tabLocator = By.xpath("//ul[@class='index']/li[a[contains(text(), '" + tab.getName() + "')]]");
        element(tabLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[name=save]")));
        return this;
    }

    public NewProductPage fillInformationSection(){
        Select manufacturer = new Select(element(By.cssSelector("select[name*=man]")));
        manufacturer.selectByIndex(1);

        By keywordsField = By.cssSelector("input[name*=key]");
        element(keywordsField).sendKeys(product.getKeywords());

        By shortDescriptionField = By.cssSelector("input[name*=short]");
        element(shortDescriptionField).sendKeys(product.getShortDescription());

        By descriptionField = By.cssSelector("div[dir=ltr]");
        element(descriptionField).sendKeys(product.getDescription());

        By headTitleField = By.cssSelector("input[name*=head]");
        element(headTitleField).sendKeys(product.getName());

        By metaDescription = By.cssSelector("input[name*=meta]");
        element(metaDescription).sendKeys(product.getShortDescription());
        return this;
    }

    public NewProductPage fillPricesSection(){
        By purchasePriceField = By.cssSelector("input[name*=purchase]");
        element(purchasePriceField).clear();
        if (product.getCurrency().contains("Euro"))
            element(purchasePriceField).sendKeys(product.getPurchasePriceInEuros());
        else element(purchasePriceField).sendKeys(product.getPurchasePriceInDollars());

        Select currencySelector = new Select(element(By.cssSelector("select[name*=purchase]")));
        currencySelector.selectByValue(product.getCurrency());

        By usdPriceField = By.cssSelector("input[name='prices[USD]'");
        element(usdPriceField).sendKeys(product.getPurchasePriceInDollars());

        By eurPriceField = By.cssSelector("input[name='prices[EUR]'");
        element(eurPriceField).sendKeys(product.getPurchasePriceInEuros());
        return this;
    }

    public void clickSaveButton(){
        By saveButton = By.cssSelector("button[name='save']");
        element(saveButton).click();
    }

}
