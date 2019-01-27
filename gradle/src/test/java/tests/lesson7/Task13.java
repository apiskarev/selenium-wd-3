package tests.lesson7;

import org.junit.Before;
import org.junit.Test;
import tests.BaseTest;
import tests.pages.admin.product.ProductPage;
import tests.pages.shopPages.MainPage;

public class Task13 extends BaseTest {

    private MainPage mainPage;
    private ProductPage productPage;

    @Before
    public void setUp(){
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void task13(){
        openLiteCart();
        mainPage.clickProductNumber(1);
        productPage.addProductToCart().clickMainButton();
        mainPage.clickProductNumber(2);
        productPage.addProductToCart().clickMainButton();
        mainPage.clickProductNumber(3);
        productPage.addProductToCart().clickMainButton();

    }


}
