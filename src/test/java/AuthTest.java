import common.AbsCommon;
import components.SingInPopup;
import factory.DriverFactory;
import factory.settings.ChromeDriverSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;
import pages.LkHomePage;
import tools.WaitTools;

public class AuthTest {

    private WebDriver driver;
    private WaitTools waitTools;
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
//            driver.close();
//            driver.quit();
        }
    }

    @Test
    public void authHomepage() {
        AbsBasePage basePage = new AbsBasePage(driver);
        SingInPopup singInPopup = new SingInPopup(driver);
        LkHomePage homePage = new LkHomePage(driver);

        basePage.open();
        singInPopup.authorization();
        singInPopup.enterHeaderIconOwl();
        singInPopup.selectLkInMenu();
        homePage.setSelectTabAboutMe();


    }

}
