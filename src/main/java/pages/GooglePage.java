package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends PageObject {

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@alt='Google']")
    private WebElement googlePic;

    public void clickToGooglePic(){
        googlePic.click();
    }
}