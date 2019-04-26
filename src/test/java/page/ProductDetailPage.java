package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'buy-block__options')]/a")
    private WebElement addToBasketButton;

    @FindBy(partialLinkText = "Verder naar bestellen")
    private WebElement continueToOrderButton;

    @FindBy(id = "quantityDropdown")
    private WebElement quantityDropdown;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddProductToBasket() {
        addToBasketButton.click();
    }

    public boolean isContinueToOrderButtonDisplayed() {
        return continueToOrderButton.isDisplayed();
    }

    public BasketPage clickContinueToOrder() {
        continueToOrderButton.click();
        return new BasketPage(driver);
    }

    public void selectQuantity(String value) {
        selectOptionByValue(quantityDropdown, value);
    }
}
