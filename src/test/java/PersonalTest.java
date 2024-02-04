import com.github.javafaker.Faker;
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
import pages.LkBiographyPage;
import tools.WaitTools;

public class PersonalTest {
    private WebDriver driver;
    private WaitTools waitTools;
    private Faker faker = new Faker();

    private Logger logger = (Logger) LogManager.getLogger("Autotest");

    @BeforeEach
    public void init() {
        AuthTest authTest= new AuthTest();
        ChromeDriverSettings driverSettings = new ChromeDriverSettings();
        this.driver = new DriverFactory(driverSettings).create();
        authTest.authHomepage();
        logger.info("Open browser  in otus.ru/lk/biography/personal/ ");
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
    public void selectCity() {
        LkBiographyPage biographyPage = new LkBiographyPage(driver);

        biographyPage.inputFioAndData(PersonalData.NAME);

        ICityData cityData= RussianCitiesData.SAINTPETERBURG;
        biographyPage.selectCity(cityData);
    }

}

