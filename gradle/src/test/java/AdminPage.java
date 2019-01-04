import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

class AdminPage extends BaseTest {

    void login(){
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name='login']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.notice.success")));
    }

    By mainElements = By.cssSelector("ul#box-apps-menu > li");
    By subElements = By.cssSelector("ul#box-apps-menu ul.docs a");
    By header = By.cssSelector("#content > h1");
}
