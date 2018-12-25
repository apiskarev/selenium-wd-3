import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecondTest extends BaseTest{

    @Test
    public void second(){
        driver.get("http://localhost/litecart/admin/login.php");

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name='login']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.notice.success")));
    }

}
