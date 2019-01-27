package tests.lesson6;

import org.junit.Before;
import org.junit.Test;
import tests.BaseTest;
import tests.pages.admin.product.ProductTab;
import tests.pages.data.Product;
import tests.pages.data.enums.AdminMenu;
import tests.pages.AdminPage;
import tests.pages.admin.CatalogPage;
import tests.pages.admin.product.NewProductPage;

public class Task12 extends BaseTest {

    private AdminPage adminPage;
    private CatalogPage catalogPage;
    private NewProductPage newProductPage;

    @Before
    public void setUp(){
        adminPage = new AdminPage(driver);
        catalogPage = new CatalogPage(driver);
        Product product = new Product();
        newProductPage = new NewProductPage(driver, product);
    }

    @Test
    public void task12(){
        adminPage.loginAsAdmin();
        adminPage.openMenuSection(AdminMenu.CATALOG);
        catalogPage.clickAddNewProductLink();
        newProductPage
                .fillGeneralSection()
                .openTab(ProductTab.INFORMATION)
                .fillInformationSection()
                .clickSaveButton();
    }

}
