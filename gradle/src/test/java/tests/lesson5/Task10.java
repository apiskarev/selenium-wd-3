package tests.lesson5;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

public class Task10 extends BaseTest {

    @Test
    public void task10(){
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.product")));

        By nameAtMainPage = By.cssSelector("div#box-campaigns div.name");
        By regularPriceAtMainPage = By.cssSelector("div#box-campaigns s");
        By campaignPriceAtMainPage = By.cssSelector("div#box-campaigns strong");

        String name = element(nameAtMainPage).getText();
        String regularPrice = element(regularPriceAtMainPage).getText();
        String campaignPrice = element(campaignPriceAtMainPage).getText();

        assertTextStrikedthrough(regularPriceAtMainPage);
        assertColorIs(getColorFrom(regularPriceAtMainPage), Color.GREY);

        assertTextIsBold(campaignPriceAtMainPage);
        assertColorIs(getColorFrom(campaignPriceAtMainPage), Color.RED);
        assert getFontSize(regularPriceAtMainPage) < getFontSize(campaignPriceAtMainPage);

        By productLinkAtMainPage = By.cssSelector("div#box-campaigns a.link");

        wait.until(ExpectedConditions.visibilityOfElementLocated(productLinkAtMainPage));

        element(productLinkAtMainPage).click();

        By nameAtProductPage = By.cssSelector("h1.title");
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameAtProductPage));

        By regularPriceAtProductPage = By.cssSelector("s");
        By campaignPriceAtProductPage = By.cssSelector("div.price-wrapper strong");

        Assert.assertEquals(name, element(nameAtProductPage).getText());
        Assert.assertEquals(regularPrice, element(regularPriceAtProductPage).getText());
        Assert.assertEquals(campaignPrice, element(campaignPriceAtProductPage).getText());

        assertTextStrikedthrough(regularPriceAtProductPage);
        assertColorIs(getColorFrom(regularPriceAtProductPage), Color.GREY);

        assertTextIsBold(campaignPriceAtProductPage);
        assertColorIs(getColorFrom(campaignPriceAtProductPage), Color.RED);
        assert getFontSize(regularPriceAtProductPage) < getFontSize(campaignPriceAtProductPage);
    }

    private String getColorFrom(By locator){
        String coloredText = element(locator).getCssValue("color").replace(")", "");
         return coloredText.contains("rgba") ? coloredText.replace("rgba(", ""):
                 coloredText.replace("rgb(", "");
    }

    private void assertColorIs(String rgbaContainer, Color color){
        String [] colors = rgbaContainer.split(", ");
        switch (color){
            case GREY:
                for (int i = 1; i < 3; i++)
                    Assert.assertEquals(colors[0],colors[i]);
            case RED:
                assert Integer.parseInt(colors[0]) > 0;
                assert Integer.parseInt(colors[1]) == Integer.parseInt(colors[2]);
        }
    }

    private void assertTextStrikedthrough(By by){
        assert element(by).getCssValue("text-decoration").contains("line-through");
    }

    private void assertTextIsBold(By by){
        assert element(by).getTagName().equals("strong");
    }

    private float getFontSize(By by){
        return Float.parseFloat(element(by).getCssValue("font-size").replace("px", ""));
    }




}
