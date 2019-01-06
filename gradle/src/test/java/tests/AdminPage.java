package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends BaseTest {

    protected void loginAsAdmin(){
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name='loginAsAdminAndOpen']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.notice.success")));
    }

    protected void loginAsAdminAndOpen(String url){
        loginAsAdmin();
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".footer")));
    }
}
