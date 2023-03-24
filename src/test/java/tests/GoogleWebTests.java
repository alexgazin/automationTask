package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GooglePage;

import java.util.concurrent.TimeUnit;

import static Helper.WebHelper.checkElementWithTextIsPresent;

public class GoogleWebTests extends BaseTest {

    private GooglePage googlePage;

    @Test
    public void checkGoogleSearchUI() {
        googlePage = new GooglePage(driver);
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(SEARCH_NAME);
        element.submit();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        checkElementWithTextIsPresent("Mark Twain");
        checkElementWithTextIsPresent("American writer");
        checkElementWithTextIsPresent("Wikipedia");
        googlePage.clickToGooglePic();
        checkElementWithTextIsPresent("Google offered in");
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
    }
}