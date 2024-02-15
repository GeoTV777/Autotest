import com.github.javafaker.Faker;
import components.lk_biogpaphy.ContactInfo;
import components.sign_in.SingInPopup;
import data.personal.*;
import data.sities.ICityData;
import data.sities.RussianCitiesData;
import factory.DriverFactory;
import factory.settings.ChromeDriverSettings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import pages.AbsBasePage;
import pages.LkBiographyPage;
import pages.LkHomePage;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LkBiographyTest {
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
            driver.close();
            driver.quit();
            logger.info("Close browser");
        }
    }

    @Test
    @Order(1)
    public void authHomepage() {
        AbsBasePage basePage = new AbsBasePage(driver);
        SingInPopup singInPopup = new SingInPopup(driver);
        LkHomePage homePage = new LkHomePage(driver);
        LkBiographyPage biographyPage = new LkBiographyPage(driver);
        Faker faker = new Faker();
        ContactInfo contactInfo = new ContactInfo(driver);
        ICityData[] cityData= RussianCitiesData.values();
        ICityData city = faker.options().nextElement(cityData);

        basePage.open();

        singInPopup.auth();

        singInPopup.enterHeaderIconOwl();

        singInPopup.selectLkInMenu();

        homePage.setSelectTabAboutMe();


        biographyPage.clearPersData(PersonalData.NAME, PersonalData.SURNAME);


        biographyPage.inputFio(PersonalData.NAME, faker.name().firstName());

        biographyPage.inputFio(PersonalData.SURNAME, faker.name().lastName());
        biographyPage.inputFio(PersonalData.NAMELAT, faker.name().firstName());
        biographyPage.inputFio(PersonalData.SURNAMELAT, faker.name().lastName());
        biographyPage.inputFio(PersonalData.NAMECHAT, faker.artist().name());
        biographyPage.inputFio(PersonalData.DATE, faker.date().birthday().toInstant().atZone
                (ZoneId.systemDefault()).toLocalDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));


        biographyPage.selectCountryAbdCity(city);

        biographyPage.selectEnglishLevel(EnglishLevelData.INTERMEDIATE);

        biographyPage.selectToRelocate(Boolean.parseBoolean(String.valueOf(true)));

        biographyPage.selectWorkGraph(true, WorkGraphData.FULL);
        biographyPage.selectGender();

        biographyPage.inputPlaceOfWorkAndPosition(WorkData.COMPANY,faker.commerce().department());
        biographyPage.inputPlaceOfWorkAndPosition(WorkData.POSITION,faker.job().position());

        contactInfo.addContactInfoForm(NumberFormInputData.FORM1,CommunicationMethodData.TELEGRAM, faker.phoneNumber().cellPhone());
        contactInfo.addingAnInputField();
        contactInfo.addContactInfoForm(NumberFormInputData.FORM2,CommunicationMethodData.SKYPE, faker.phoneNumber().cellPhone());
        contactInfo.addingAnInputField();
        contactInfo.addContactInfoForm(NumberFormInputData.FORM3,CommunicationMethodData.HABR,faker.idNumber().valid());

        biographyPage.save();
    }
    @Test
    @Order(1)
    public void saveControl() {
        AbsBasePage basePage = new AbsBasePage(driver);
        SingInPopup singInPopup = new SingInPopup(driver);
        ContactInfo contactInfo = new ContactInfo(driver);
        LkBiographyPage biographyPage = new LkBiographyPage(driver);
        LkHomePage homePage = new LkHomePage(driver);

        basePage.open("/lk/biography/personal/");
        singInPopup.transitionToPersonalData();
        homePage.setSelectTabAboutMe();

        biographyPage.controlSavePersonal(PersonalData.NAME,PersonalData.SURNAME, PersonalData.NAMELAT,
                PersonalData.SURNAMELAT, PersonalData.NAMECHAT, PersonalData.DATE);

        biographyPage.controlSaveBasicInformation();

        biographyPage.controlRelocateIsSelected();
        biographyPage.controlSelectWorkGraph(true, WorkGraphData.FULL);

        contactInfo.controlSaveContactInformation(NumberFormInputData.FORM1,
                NumberFormInputData.FORM2, NumberFormInputData.FORM3);

    }

}
