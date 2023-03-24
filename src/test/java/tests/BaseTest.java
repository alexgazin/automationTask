package tests;

import config.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.Browser;

public class BaseTest {

    protected final String SEARCH_NAME = "mark twain";
    protected static final Configuration CONFIGURATION = ConfigFactory.create(Configuration.class, System.getProperties());

    protected static WebDriver driver;

    @Before
    public void init() {
        driver = Browser.launchBrowser();
        driver.manage().window().maximize();
        driver.get(CONFIGURATION.web_host());
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }
}