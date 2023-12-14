package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#login" )
    private WebElement loginButton;

    public void clickOnLoginButton(){
        waitForVisibility(loginButton);
        clickOnElement(loginButton);
    }
}