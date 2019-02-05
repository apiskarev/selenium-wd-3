package tests.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.pages.AbstractPage;
import tests.pages.data.enums.AdminMenu;

import java.util.List;

public class AdminPage extends AbstractPage {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void loginAsAdmin(){
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name='login']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.notice.success")));
    }

    public void loginAsAdminAndOpen(String url){
        loginAsAdmin();
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".footer")));
    }

    public void openMenuSection(AdminMenu menu){
        By menuSectionsLocator = By.cssSelector("li#app-");
        wait.until(ExpectedConditions.numberOfElementsToBe(menuSectionsLocator, 17));
        for (int i = 0; i < 17; i++){
            List<WebElement> menuSections = driver.findElements(menuSectionsLocator);
            if (menuSections.get(i).getText().toLowerCase().equals(menu.name().toLowerCase())){
                menuSections.get(i).findElement(By.cssSelector("a")).click();
            }
        }
    }


}
