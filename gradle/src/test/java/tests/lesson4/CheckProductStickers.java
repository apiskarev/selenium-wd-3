package tests.lesson4;

import org.junit.Test;
import org.openqa.selenium.By;
import tests.BaseTest;

public class CheckProductStickers extends BaseTest {

    @Test
    public void mainpageProductsTest(){
        driver.get("http://localhost/litecart/en/");

        By products = By.cssSelector("li.product");

        for (int i = 0; i < driver.findElements(products).size(); i++){
           assert driver.findElements(products).get(i).findElements(By.cssSelector("div.sticker")).size() == 1;
        }
    }

}
