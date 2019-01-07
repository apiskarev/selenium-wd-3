package tests.lesson5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.AdminPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task9_2 extends AdminPage {

    @Test
    public void task9_2(){
        loginAsAdminAndOpen("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        for (int i = 0; i < elements(By.xpath("//tr[@class='row']")).size(); i++){
            element(By.xpath("//tr[@class='row'][" + (i + 1) + "]/td[3]/a")).click();
            List<String> zoneList = new ArrayList<>();
            for (int j = 0; j < elements(By.xpath("//select[contains(@name, 'zone_code')]")).size(); j++){
                Select countryZone = new Select(
                        element(By.xpath("(//select[contains(@name, 'zone_code')])[" + (j + 1) + "]")));
                zoneList.add(countryZone.getFirstSelectedOption().getText());
            }

            Collections.sort(zoneList);

            for (int j = 0; j < elements(By.xpath("//select[contains(@name, 'zone_code')]")).size(); j++){
                Select countryZone = new Select(
                        element(By.xpath("(//select[contains(@name, 'zone_code')])[" + (j + 1) + "]")));
                Assert.assertEquals(zoneList.get(j), countryZone.getFirstSelectedOption().getText());
            }

            driver.navigate().back();
        }
    }
}
