package pages;

import data.personal.*;
import data.sities.ICityData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.Arrays;

public class LkBiographyPage extends AbsBasePage {

    public LkBiographyPage(WebDriver driver) {
        super(driver);
    }

    private Logger logger = (Logger) LogManager.getLogger("Autotest");


    public void inputFioAndData(PersonalData personalData) {
        WebElement inputName = driver.findElement(By.cssSelector(String.format("[data-title='%s']")));
        inputName.click();
        inputName.sendKeys(PersonalData.NAME.getName());
        WebElement inputSurname = driver.findElement(By.cssSelector(String.format("[data-title='%s']")));
        inputSurname.click();
        inputSurname.sendKeys(PersonalData.SURNAME.getName());

       WebElement inputNameLat = driver.findElement(By.id("id_fname_latin"));
       inputNameLat.click();
       inputNameLat.sendKeys(PersonalData.NAMELAT.getName());

       WebElement inputSurnameLat = driver.findElement(By.id("id_lname_latin"));
       inputSurnameLat.click();
       inputSurnameLat.sendKeys(PersonalData.SURNAMELAT.getName());

       WebElement inputDate = driver.findElement(By.cssSelector("[title='%s']"));
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
        //disabled
        waitTools.waitForCondition(ExpectedConditions.not
                (ExpectedConditions.attributeToBe(citiesListContainer, "disabled", "disabled")));

        driver.findElement(By.cssSelector(String.format("[data-title='%s']", cityData.getCountriesData().getName())));
        waitTools.waitForCondition(ExpectedConditions.attributeContains(citiesListContainer, "class", "hide"));
        logger.info("City selected");

    }

    public void selectEnglishLevel(EnglishLevelData englishLevelData) {
        WebElement selectEnglishLevel = driver. findElement
                (By.xpath("//input[@name ='english_level']/following::*"));
        selectEnglishLevel.click();

        WebElement levelListContainer = selectEnglishLevel.findElement
                (By.xpath("//div[contains(@class,'lk-cv-block__select-options js-custom-select-options-container')]"));
        waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(levelListContainer,"class", "hide")));
        driver.findElement(By.cssSelector(String.format("data-title='%s']",englishLevelData.getName()))).click();

    }

    public void selectToRelocate(boolean isSelected) {
        String relocate = isSelected ? "Да" : "Нет";
        driver.findElement(By.xpath(String.format("//span[@class='radio__label' and text()='Нет']"))).click();

    }

    public void selectWorkGraph(boolean isSelekted, WorkGraphData... workGraphDatas) {

    for(WorkGraphData workGraphData : workGraphDatas) {

        WebElement checkBox = driver.findElement(By.cssSelector(String.format("input[title='%s']", workGraphData.getName())));

        if(checkBox.isSelected() != isSelekted) {
            checkBox.click();
        }
    }

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

