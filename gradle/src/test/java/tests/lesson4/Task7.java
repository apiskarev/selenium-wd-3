package tests.lesson4;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;
import tests.pages.admin.AdminPage;

public class Task7 extends BaseTest {

        private AdminPage adminPage;

        @Before
        public void setUp(){
            adminPage = new AdminPage(driver);
        }

        @Test
        public void adminMenuTest(){
            adminPage.loginAsAdmin();

            By mainElements = By.cssSelector("ul#box-apps-menu > li");
            By subElements = By.cssSelector("ul#box-apps-menu ul.docs a");

            for (int i = 0; i < driver.findElements(mainElements).size(); i++){
                driver.findElements(mainElements).get(i).click();
                assertHeaderPresent();
                if (areElementsPresent(subElements)){
                    for (int k = 0; k < driver.findElements(subElements).size(); k++){
                        driver.findElements(subElements).get(k).click();
                        assertHeaderPresent();
                    }
                }
            }
        }

        private void assertHeaderPresent(){
            By header = By.cssSelector("#content > h1");
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(header)));
            assert driver.findElement(header).getText().length() > 0;
        }

}
