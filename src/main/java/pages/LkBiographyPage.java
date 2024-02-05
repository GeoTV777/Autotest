package pages;

import data.personal.CompanyData;
import data.personal.ContactsData;
import data.personal.PersonalData;
import data.sities.ICityData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LkBiographyPage extends AbsBasePage {

    public LkBiographyPage(WebDriver driver) {
        super(driver);
    }

    private Logger logger = (Logger) LogManager.getLogger("Autotest");


    public void inputFioAndData(PersonalData personalData) {
       WebElement inputNameLat = driver.findElement(By.id("id_fname_latin"));
       inputNameLat.click();
       inputNameLat.sendKeys(PersonalData.NAMELAT.getName());

       WebElement inputSurnameLat = driver.findElement(By.id("id_lname_latin"));
       inputSurnameLat.click();
       inputSurnameLat.sendKeys(PersonalData.SURNAMELAT.getName());

       WebElement inputDate = driver.findElement(By.cssSelector("[title='День рождения']"));
       inputDate.click();
       inputDate.sendKeys(PersonalData.DATE.getName());
    }


    public void selectCity(ICityData cityData) {
        WebElement russiaSelectElement = driver.findElement
                (By.cssSelector("[data-slave-selector='.js-lk-cv-dependent-slave-city']"));
        russiaSelectElement.click();

        WebElement citiesListContainer = russiaSelectElement.findElement
                (By.xpath("//*[contains@class.'js-custom-select-options-container']"));
        waitTools.waitForCondition(ExpectedConditions.not
                (ExpectedConditions.attributeContains(citiesListContainer, "class", "hide")));

        driver.findElement(By.cssSelector(String.format("[title='%s']", cityData.getCountriesData().getName())));
        waitTools.waitForCondition(ExpectedConditions.attributeContains(citiesListContainer, "class", "hide"));
        logger.info("City selected");
    }

    public void selectEnglishLevel() {


    }

    public void inputContactInfo(ContactsData contactsData) {

    }

    public void selectGender() {
        String fieldGenderId = "id_gender";

        driver.findElement(By.id(fieldGenderId)).click();
        Select genderSelect = new Select(driver.findElement(By.id(fieldGenderId)));
        genderSelect.selectByVisibleText("Женский");

    }

    public void inputPlaceOfWorkAndPosition(CompanyData companyData) {


        String fieldCompany = "";
        String inputCompany = "";

        String fieldPosition = "";
        String inputPosition = "";


    }

//    public void save() {
//        String btnSaveAndContinueSelector = "[name='continue']";
//
//        driver.findElement(By.cssSelector(btnSaveAndContinueSelector));
//        waitTools.waitNotElementPresent(By.cssSelector(btnSaveAndContinueSelector));
//        logger.info("Data saved");
//
//    }



}

