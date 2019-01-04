import org.junit.Test;
import org.openqa.selenium.By;

public class FourthTest extends ShopPage {

    @Test
    public void fourth(){
        driver.get("http://localhost/litecart/en/");

        for (int i = 0; i < driver.findElements(products).size(); i++){
           assert driver.findElements(products).get(i).findElements(By.cssSelector("div.sticker")).size() == 1;
        }
    }

}
