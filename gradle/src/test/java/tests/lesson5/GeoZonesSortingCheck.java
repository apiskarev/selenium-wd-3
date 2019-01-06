package tests.lesson5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import tests.AdminPage;

import java.util.ArrayList;
import java.util.List;

public class GeoZonesSortingCheck extends AdminPage {

    @Test
    public void second(){
        loginAsAdminAndOpen("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        for (int i = 0; i < elements(By.xpath("//tr[@class='row']")).size(); i++){
            element(By.xpath("//tr[@class='row']["+ (i+1) +"]/td[3]/a")).click();
            List<String> zoneList = new ArrayList<>();
            for (int j = 0; j < elements(By.xpath("//select[contains(@name, 'zone_code')]")).size(); j++){
                Select countryZone = new Select(element(By.xpath("//select[contains(@name, 'zone_code')][" + j + "]")));
                zoneList.add(countryZone.getFirstSelectedOption().getText());
                System.out.println(zoneList.get(j));
            }

            driver.navigate().back();
        }
    }
}
