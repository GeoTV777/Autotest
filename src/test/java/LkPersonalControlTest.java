import components.lk_biogpaphy.ContactInfo;
import components.sign_in.SingInPopup;
import factory.DriverFactory;
import factory.settings.ChromeDriverSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;
import pages.LkHomePage;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LkPersonalControlTest {
    private WebDriver driver;
    private Logger logger = (Logger) LogManager.getLogger("Autotest");


    @BeforeEach
    public void init() {
        ChromeDriverSettings driverSettings = new ChromeDriverSettings();
        this.driver = new DriverFactory(driverSettings).create();
        logger.info("Open browser");
    }

    @AfterEach
    public void driverStop() {
        if (driver != null) {
            logger.info("Close browser");
            driver.close();
            driver.quit();
        }
    }
    @Test
    public void saveControl() {
        AbsBasePage basePage = new AbsBasePage(driver);
        SingInPopup singInPopup = new SingInPopup(driver);
        LkHomePage homePage = new LkHomePage(driver);
        ContactInfo contactInfo = new ContactInfo(driver);

        basePage.open();
        singInPopup.authorization();

        basePage.open("/lk/biography/personal/");


    }
}
