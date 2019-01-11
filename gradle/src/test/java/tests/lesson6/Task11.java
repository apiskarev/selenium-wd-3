package tests.lesson6;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import tests.BaseTest;
import tests.pages.MainPage;
import tests.pages.NewUserPage;

import java.util.concurrent.ThreadLocalRandom;

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
