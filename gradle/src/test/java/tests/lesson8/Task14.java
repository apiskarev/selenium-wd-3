package tests.lesson8;

import org.junit.Before;
import org.junit.Test;
import tests.BaseTest;
import tests.pages.admin.AdminPage;
import tests.pages.admin.countries.CountriesList;
import tests.pages.admin.countries.CountryEdit;

import static tests.pages.data.enums.AdminMenu.COUNTRIES;

public class Task14 extends BaseTest{

    private AdminPage adminPage;
    private CountriesList countriesListPage;
    private CountryEdit countryEditPage;

    @Before
    public void setUp(){
        adminPage = new AdminPage(driver);
        countriesListPage = new CountriesList(driver);
        countryEditPage = new CountryEdit(driver);
    }

    @Test
    public void task14(){
        adminPage.loginAsAdmin();
        adminPage.openMenuSection(COUNTRIES);
        countriesListPage.clickEditCountry(1);
        openWindowsInCycle();
    }

    private void openWindowsInCycle(){
        for (int i = 0; i < countryEditPage.getExternalLinksSize(); i++){
            countryEditPage.clickExternalLinkIcon(i).waitForNewPage().closeAndReturn();
        }
    }
}
