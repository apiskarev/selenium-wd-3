package tests.lesson6;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import tests.BaseTest;

public class Task11 extends BaseTest {

    private Account account;

    @Before
    public void setData(){
        account = new Account();
    }

    @Test
    public void task11(){
        openLiteCart();

        By createNewUserLink = By.xpath("//td/a");
        element(createNewUserLink).click();


    }
}
