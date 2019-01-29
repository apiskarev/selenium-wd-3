package tests.lesson7;

import org.junit.Before;
import org.junit.Test;
import tests.BaseTest;
import tests.pages.shopPages.ProductPage;
import tests.pages.shopPages.Checkout;
import tests.pages.shopPages.MainPage;

public class Task13 extends BaseTest {

    private MainPage mainPage;
    private ProductPage productPage;
    private Checkout checkoutPage;

    @Before
    public void setUp(){
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new Checkout(driver);
    }

    @Test
    public void task13(){
        openLiteCart();

        mainPage.clickProductNumber(1);
        productPage.addProductToCart()
                .checkProductAdded()
                .clickMainButton();

        mainPage.clickProductNumber(2);
        productPage.addProductToCart()
                .checkProductAdded()
                .clickMainButton();

        mainPage.clickProductNumber(3);
        productPage.addProductToCart()
                .checkProductAdded()
                .clickMainButton();

        mainPage.openProductCart();
        checkoutPage.removeProduct(3);
    }


}
