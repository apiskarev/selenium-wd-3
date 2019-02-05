package tests.lesson2;

import org.junit.Before;
import org.junit.Test;
import tests.BaseTest;
import tests.pages.admin.AdminPage;

public class LoginAsAdmin extends BaseTest {

    private AdminPage adminPage;

    @Before
    public void setUp(){
        adminPage = new AdminPage(driver);
    }

    @Test
    public void loginTest(){
        adminPage.loginAsAdmin();
    }

}
