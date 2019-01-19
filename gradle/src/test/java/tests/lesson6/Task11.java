package tests.lesson6;

import org.junit.Before;
import org.junit.Test;
import tests.BaseTest;
import tests.pages.data.Account;
import tests.pages.shopPages.MainPage;
import tests.pages.shopPages.NewUserPage;

public class Task11 extends BaseTest {

    private Account account;
    private MainPage mainPage;
    private NewUserPage userPage;

    @Before
    public void setData(){
        account = new Account();
        mainPage = new MainPage(driver);
        userPage = new NewUserPage(driver);
    }

    @Test
    public void task11(){
        openLiteCart();
        mainPage.clickNewUserLink();
        userPage.fillNewUser(account);
        mainPage.assertSuccess();
        mainPage.logout();
        mainPage.login(account);
        mainPage.logout();
    }

}
