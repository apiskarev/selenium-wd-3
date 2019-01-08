package tests.lesson5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import tests.AdminPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task9_2 extends AdminPage {

    @Test
    public void task9_2(){
        loginAsAdminAndOpen("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        By zoneSelectors = By.cssSelector("select[name*='zone_code']");

        int amount = elements(By.cssSelector("tr.row")).size();

        for (int i = 0; i < amount; i++){
            element(By.xpath("//tr[@class='row'][" + (i + 1) + "]/td[3]/a")).click();
            List<String> zoneList = new ArrayList<>();
            for (int k = 0; k < elements(zoneSelectors).size(); k++){
                zoneList.add(element(By.xpath("(//select[contains(@name, 'zone_')]/option[@selected='selected'])[" + (k + 1) + "]")).getText());
            }

            Collections.sort(zoneList);

            for (int j = 0; j < elements(zoneSelectors).size(); j++){
                Assert.assertEquals(zoneList.get(j),
                        element(By.xpath("(//select[contains(@name, 'zone_')]/option[@selected='selected'])[" + (j + 1) + "]")).getText());
            }

            if (i < amount - 1) driver.navigate().back();
        }
    }
}
