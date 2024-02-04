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

import javax.lang.model.element.Name;

public class LkBiographyPage extends AbsBasePage {

    public LkBiographyPage(WebDriver driver) {
        super(driver);
    }

    private Logger logger = (Logger) LogManager.getLogger("Autotest");


    public void inputFioAndData(PersonalData personalData) {
        String inputDataTemplate = "input[data-title ='%s']";
        String inputNameClickSelector = String.format(inputDataTemplate,"Имя");
        String inputSurnameSelector = String.format(inputDataTemplate,"Фамилия");
    //  у остальных элементов нет такого датат тайтла, соответственно в обычном порядке писать селекторы

        WebElement inputName = driver.findElement(By.cssSelector(inputNameClickSelector));
        inputName.click();
        waitTools.waitElementToBeClickable(By.cssSelector(inputNameClickSelector));
        inputName.sendKeys(personalData.toString());
        logger.info("Name entered");

        WebElement inputSurname = driver.findElement(By.cssSelector(inputSurnameSelector));
        inputName.click();
        waitTools.waitElementToBeClickable(By.cssSelector(inputSurnameSelector));
        inputSurname.sendKeys(personalData.toString());
        logger.info("Surname entered");

    }

    public void inputDateOfBirth(PersonalData personalData) {

    }


    public void selectCity(ICityData cityData) {
        WebElement russiaSelectElement = driver.findElement
                (By.cssSelector("[data-slave-selector='.js-lk-cv-dependent-slave-city']"));
        russiaSelectElement.click();

        WebElement citiesListContainer = russiaSelectElement.findElement(By.xpath("//*[contains@class.'js-custom-select-options-container']"));
        waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(citiesListContainer, "class", "hide")));

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

    public void save() {
        String btnSaveAndContinueSelector = "[name='continue']";

        driver.findElement(By.cssSelector(btnSaveAndContinueSelector));
        waitTools.waitNotElementPresent(By.cssSelector(btnSaveAndContinueSelector));
        logger.info("Data saved");

    }



}

