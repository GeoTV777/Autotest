import com.github.javafaker.Faker;
import components.SingInPopup;
import data.personal.EnglishLevelData;
import data.personal.PersonalData;
import data.personal.WorkGraphData;
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

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class OtusTest {

    private WebDriver driver;
//    private WaitTools waitTools;
    private Faker faker;
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
        LkBiographyPage biographyPage = new LkBiographyPage(driver);

        basePage.open();
        singInPopup.authorization();
        singInPopup.enterHeaderIconOwl();
        singInPopup.selectLkInMenu();
        homePage.setSelectTabAboutMe();

        biographyPage.clearPersData(PersonalData.NAME, PersonalData.SURNAME, PersonalData.NAMECHAT);

        biographyPage.inputFioAndData(PersonalData.NAME, faker.name().firstName());
        biographyPage.inputFioAndData(PersonalData.SURNAME, faker.name().lastName());
        biographyPage.inputFioAndData(PersonalData.NAMELAT, faker.funnyName().name());
        biographyPage.inputFioAndData(PersonalData.SURNAMELAT, faker.artist().name());
        biographyPage.inputFioAndData(PersonalData.NAMECHAT, faker.artist().name());
        biographyPage.inputFioAndData(PersonalData.DATE, faker.date().birthday().toInstant().atZone
                (ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("DD.MM.yyyy")));

        ICityData cityData= RussianCitiesData.SAINTPETERBURG;
        biographyPage.selectCity(cityData);
        biographyPage.selectEnglishLevel(EnglishLevelData.BEGINNER);

        biographyPage.selectToRelocate(Boolean.parseBoolean(String.valueOf(true)));

        biographyPage.selectWorkGraph(true, WorkGraphData.FLEXIBLE);


    }

}


