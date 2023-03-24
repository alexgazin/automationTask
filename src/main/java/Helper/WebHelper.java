package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageObject;

import java.time.Duration;


public class WebHelper extends PageObject {

    public WebHelper(WebDriver driver) {
        super(driver);
    }

    public static WebElement checkElementWithTextIsPresent(String text) {
        By locatorElementContainsText;
        By locatorElementExactMatchText;
        WebElement elementContainsText;
        WebElement elementExactMatchText;

        locatorElementContainsText = By.xpath(String.format("//*[contains(text(), '%s')]", text));
        locatorElementExactMatchText = By.xpath(String.format("//*[text()='%s']", text));


        elementContainsText = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(locatorElementContainsText));
        try {
            elementExactMatchText = driver.findElement(locatorElementExactMatchText);
            return elementExactMatchText;
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            return elementContainsText;
        }
    }
}