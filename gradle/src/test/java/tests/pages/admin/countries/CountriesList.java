package tests.pages.admin.countries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.pages.AbstractPage;

public class CountriesList extends AbstractPage {

    public CountriesList(WebDriver driver){
        super(driver);
    }

    public void clickEditCountry(int number){
        By countryEditIcons = By.cssSelector("i.fa.fa-pencil");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(countryEditIcons, 1));
        elements(countryEditIcons).get(number).click();
    }

}
