package tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.lesson6.Account;

public class MainPage extends AbstractPage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickNewUserLink(){
        By createNewUserLink = By.xpath("//td/a");
        element(createNewUserLink).click();
    }

    public void logout(){
        By logoutLink = By.xpath("(//a[text()='Logout'])[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink));
        element(logoutLink).click();
        assertSuccess();
    }

    public void login(Account account){
        element(By.cssSelector("input[name='email']")).sendKeys(account.getEmail());
        element(By.cssSelector("input[name='password']")).sendKeys(account.getPassword());
        element(By.cssSelector("button[name='login']")).click();
        assertSuccess();
    }

    public void assertSuccess(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".notice.success")));
    }
}
