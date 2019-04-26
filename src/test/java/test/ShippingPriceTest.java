package test;

import org.junit.jupiter.api.Test;
import page.BasketPage;
import page.ProductDetailPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShippingPriceTest extends BaseTest{

    public ShippingPriceTest() {
        super("/nl/p/stabilo-boss-original-pastel-etui-6-kleuren/9200000065663253/");
    }

    @Test
    public void shippingCostShouldNotBeFreeWhenProductPriceLowerThanTwenty() {
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.clickAddProductToBasket();

        assertTrue(productDetailPage.isContinueToOrderButtonDisplayed(), "Continue to order button wasn't displayed");

        BasketPage basketPage = productDetailPage.clickContinueToOrder();

        assertNotEquals(basketPage.getShippingCostValue(), "Gratis", "Shipping cost shouldn't be Gratis");
    }

    @Test
    public void shippingCostMustBeFreeWhenProductPriceMoreThanTwenty() {
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.selectQuantity("3");
        productDetailPage.clickAddProductToBasket();

        assertTrue(productDetailPage.isContinueToOrderButtonDisplayed(), "Continue to order button wasn't displayed");

        BasketPage basketPage = productDetailPage.clickContinueToOrder();

        assertEquals(basketPage.getShippingCostValue(), "Gratis", "Shipping cost should be Gratis");
    }

    @Test
    public void shippingCostMustBeFreeAfterProductCountChangedToCostMoreThanTwentyAtBasket(){
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.clickAddProductToBasket();

        assertTrue(productDetailPage.isContinueToOrderButtonDisplayed(), "Continue to order button wasn't displayed");

        BasketPage basketPage = productDetailPage.clickContinueToOrder();

        assertNotEquals(basketPage.getShippingCostValue(), "Shipping cost shouldn't be Gratis");

        basketPage.selectQuantity("4");

        assertEquals(basketPage.getShippingCostValue(), "Gratis",
                "Shipping cost wasn't updated after increasing product count to cost more than 20 Euros");
    }

    @Test
    public void shippingCostMustBeFreeAfterAddingSelectToBasket() {
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.clickAddProductToBasket();


        assertTrue(productDetailPage.isContinueToOrderButtonDisplayed(), "Continue to order button wasn't displayed");

        BasketPage basketPage = productDetailPage.clickContinueToOrder();

        assertNotEquals(basketPage.getShippingCostValue(), "Gratis", "Shipping cost shouldn't be Gratis");

        basketPage.addSelectToBasket();

        assertEquals(basketPage.getShippingCostValue(), "Gratis",
                "Shipping cost wasn't updated after adding Select to basket");
    }

    @Test
    public void shippingCostShouldNotBeFreeAfterDeletingSelectFromBasket() {
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.clickAddProductToBasket();

        assertTrue(productDetailPage.isContinueToOrderButtonDisplayed(), "Continue to order button wasn't displayed");

        BasketPage basketPage = productDetailPage.clickContinueToOrder();

        assertNotEquals(basketPage.getShippingCostValue(), "Gratis", "Shipping cost shouldn't be Gratis");

        basketPage.addSelectToBasket();

        assertEquals(basketPage.getShippingCostValue(), "Gratis",
                "Shipping cost wasn't updated after adding Select to basket");

        basketPage.deleteProductByTitle("Je profiteert meteen van Select-voordeel");

        assertNotEquals(basketPage.getShippingCostValue(), "Gratis",
                "Shipping cost wasn't updated after deleting Select from basket");
    }


}
