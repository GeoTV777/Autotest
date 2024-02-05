import components.SingInPopup;
import data.personal.PersonalData;
import data.sities.ICityData;
import data.sities.RussianCitiesData;
import factory.DriverFactory;
import factory.settings.ChromeDriverSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;
import pages.LkBiographyPage;
import pages.LkHomePage;
import tools.WaitTools;

public class OtusTest {

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

    @Test
    public void enterLkPersonalInfo() {
        LkBiographyPage biographyPage = new LkBiographyPage(driver);

        biographyPage.inputFioAndData(PersonalData.NAMELAT);
        biographyPage.inputFioAndData(PersonalData.SURNAMELAT);
        biographyPage.inputFioAndData(PersonalData.DATE);

        ICityData cityData= RussianCitiesData.SAINTPETERBURG;
        biographyPage.selectCity(cityData);
    }

}


