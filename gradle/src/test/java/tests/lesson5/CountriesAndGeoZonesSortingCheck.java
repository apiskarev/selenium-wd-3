package tests.lesson5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import tests.AdminPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountriesAndGeoZonesSortingCheck extends AdminPage {

    @Test
    public void fifth(){
        loginAsAdminAndOpen("http://localhost/litecart/admin/?app=countries&doc=countries");

        List<String> countries = new ArrayList<>();
        List<Integer> rowsOfCountriesWithZones = new ArrayList<>();

        By rows = By.xpath("(//tr[@class='row'])");
        By zoneRows = By.xpath("//input[contains(@name, 'zones')]/..//../td/..");

        for (int i = 0; i < elements(rows).size(); i++){
               countries.add(element(By.xpath("(//tr[@class='row'][" + (i + 1) + "])/td[5]")).getText());
            if (Integer.parseInt(element(By.xpath("(//tr[@class='row']["+ (i+1) +"])/td[6]")).getText()) > 0) {
                rowsOfCountriesWithZones.add(i + 1);
            }
        }

        Collections.sort(countries);

        for (int i = 0; i < elements(By.cssSelector(".row")).size(); i++){
            Assert.assertEquals(countries.get(i), element(By.xpath("(//tr[@class='row']["+ (i+1) +"])/td[5]")).getText());
        }

        for (int i = 0; i < rowsOfCountriesWithZones.size(); i++){
            element(By.xpath("(//tr[@class='row'][" + rowsOfCountriesWithZones.get(i) + "])/td[5]/a")).click();
            List<String> zonesList = new ArrayList<>();
            for (int j = 0; j < elements(zoneRows).size(); j++){
                zonesList.add(element(By.xpath("(//table[@id='table-zones']//tr[not(contains(@class, 'header'))]["+ (j+1) +"])/td[3]")).getText());
            }

            Collections.sort(zonesList);

            for (int j = 0; j < zonesList.size(); j++){
                Assert.assertEquals(zonesList.get(j),
                        element(By.xpath("(//table[@id='table-zones']//tr[not(contains(@class, 'header'))]["+ (j+1) +"])/td[3]")).getText());
            }
            driver.navigate().back();
        }
    }

}
