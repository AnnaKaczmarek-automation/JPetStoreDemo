package pages;

import helpers.DataCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ReptilesCategoryPage extends BasePage{
    public ReptilesCategoryPage(WebDriver driver) {
        super(driver);
    }

    DataCreator dataCreator = new DataCreator();
    @FindBy(xpath = "//tbody/tr/td[1]")
    private List<WebElement> mainProductList;
    @FindBy(xpath = "//tr/td/a[contains(@href,'itemId')]")
    private List<WebElement> subProductViewList;

    @FindBy(xpath = "//a[text()='Add to Cart']")
    private WebElement addToCartButton;

    public void chooseRandomReptile() {
        chooseRandomMainCategoryReptile();
        log.info("Random dog was chosen from main category");
        chooseRandomSubCategoryReptile();
        log.info("Random dog was chosen from sub category");
    }
    private void chooseRandomMainCategoryReptile() {
        int index = dataCreator.createRandomNumber(1, mainProductList.size() - 1);
        waitUntilElementIsClickable(mainProductList.get(index));
        clickOnElement(mainProductList.get(index));
        wait.until(ExpectedConditions.urlContains("viewProduct=&productId="));
    }

    private void chooseRandomSubCategoryReptile() {
        int index = dataCreator.createRandomNumber(0, subProductViewList.size() - 1);
        waitForVisibility(subProductViewList.get(index));
        clickOnElement(subProductViewList.get(index));
        wait.until(ExpectedConditions.urlContains("viewItem"));
        waitForVisibility(addToCartButton);
        clickOnElement(addToCartButton);
        wait.until(ExpectedConditions.urlContains("addItemToCart=&workingItemId"));
    }
}
