package tests.lesson2;

import org.junit.Test;
import tests.pages.AdminPage;

public class LoginAsAdmin extends AdminPage {

    @Test
    public void loginTest(){
        loginAsAdmin();
    }

}
