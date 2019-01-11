package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import tests.lesson6.Account;

import java.util.concurrent.ThreadLocalRandom;

public class NewUserPage extends AbstractPage {

    public NewUserPage(WebDriver driver){
        super(driver);
    }

    public void fillNewUser(Account account){
        element(By.cssSelector("input[name='tax_id']")).sendKeys(account.getTaxId());
        element(By.cssSelector("input[name='company']")).sendKeys(account.getCompanyName());
        element(By.cssSelector("input[name='firstname']")).sendKeys(account.getFirstName());
        element(By.cssSelector("input[name='lastname']")).sendKeys(account.getLastName());
        element(By.cssSelector("input[name='address1']")).sendKeys(account.getFirstAddress());
        element(By.cssSelector("input[name='address2']")).sendKeys(account.getSecondAddress());
        element(By.cssSelector("input[name='postcode']")).sendKeys(account.getPostCode());
        element(By.cssSelector("input[name='city']")).sendKeys(account.getCity());
        element(By.cssSelector("input[name='email']")).sendKeys(account.getEmail());
        element(By.cssSelector("input[name='phone']")).sendKeys(account.getPhoneNumber());
        element(By.cssSelector("input[name='password']")).sendKeys(account.getPassword());
        element(By.cssSelector("input[name='confirmed_password']")).sendKeys(account.getPassword());
        selectCountry(account.getCountry());
        clickSave();
        selectCountryZone();
        element(By.cssSelector("input[name='password']")).sendKeys(account.getPassword());
        element(By.cssSelector("input[name='confirmed_password']")).sendKeys(account.getPassword());
        clickSave();
    }

    private void selectCountry(String country){
        element(By.cssSelector(".select2-selection__arrow")).click();
        element(By.cssSelector(".select2-search__field")).sendKeys(country);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.select2-results__option--highlighted")));
        element(By.cssSelector("li.select2-results__option--highlighted")).click();
    }

    private void clickSave(){
        element(By.cssSelector("button[name='create_account']")).click();
    }

    private void selectCountryZone(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("select[name=zone_code] option"), 0));
        Select zone = new Select(element(By.cssSelector("select[name='zone_code']")));
        int highBound = zone.getOptions().size();
        zone.selectByIndex(ThreadLocalRandom.current().nextInt(highBound - 1));
    }




}
