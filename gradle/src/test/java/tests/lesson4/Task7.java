package tests.lesson4;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.AdminPage;

public class Task7 extends AdminPage {

        @Test
        public void adminMenuTest(){
            loginAsAdmin();

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
