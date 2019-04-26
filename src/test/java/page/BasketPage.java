package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class BasketPage extends BasePage {

    @FindBy(id = "tst_shipping_costs")
    private WebElement shippingCostValue;

    @FindBy(id = "tst_quantity_dropdown")
    private WebElement quantityDropdown;

    @FindBy(linkText = "Voeg toe")
    private WebElement addSelectButton;

    @FindAll(@FindBy(className = "product-details__title"))
    private List<WebElement> productTitles;

    @FindAll(@FindBy(id = "tst_remove_from_basket"))
    private List<WebElement> deleteButtons;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String getShippingCostValue() {
        return shippingCostValue.getText();
    }

    public void selectQuantity(String value) {
        selectOptionByValue(quantityDropdown, value);
    }

    public void addSelectToBasket() {
        addSelectButton.click();
    }

    public void deleteProductByTitle(String title) {
        for(int i = 0; i < productTitles.size(); i++) {
            if (productTitles.get(i).getText().equals(title)) {
                deleteButtons.get(i).click();
                break;
            }
        }
    }

}
