import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ThirdTest extends AdminPage {

        @Test
        public void third(){
            login();

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
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(header)));
            assert driver.findElement(header).getText().length() > 0;
        }

}
