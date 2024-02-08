package pages;

import data.personal.*;
import data.sities.ICityData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LkBiographyPage extends AbsBasePage {

    public LkBiographyPage(WebDriver driver) {
        super(driver);
    }

    private Logger logger = (Logger) LogManager.getLogger("Autotest");

    public void clearPersData(PersonalData... personalData) {
        for(PersonalData persData : personalData ){
            driver.findElement(By.cssSelector(String.format("input[name='%s']", persData.getName()))).clear();
            logger.info("Cleared");
        }
    }

    public void inputFio(PersonalData personalData, String data) {
                driver.findElement(By.cssSelector(String.format("input[name='%s']", personalData.getName()))).sendKeys(data);
                logger.info("Data is filled in");
        }


    public void selectCity(ICityData cityData) {
        WebElement russiaSelectElement = driver.findElement
                (By.cssSelector("[data-slave-selector='.js-lk-cv-dependent-slave-city']"));
        russiaSelectElement.click();

        WebElement countriesListContainer = russiaSelectElement.findElement
                (By.xpath("//button[contains(@title,'Россия')]//..//.."));
        waitTools.waitForCondition(ExpectedConditions.not
                (ExpectedConditions.attributeContains(countriesListContainer, "class", "hide")));
        driver.findElement(By.cssSelector(String.format("[title='%s']", cityData.getCountriesData().getName()))).click();
        waitTools.waitForCondition(ExpectedConditions.attributeContains(countriesListContainer, "class", "hide"));
        logger.info("Country selected");


        WebElement citySelectElement = driver.findElement
                (By.xpath("//input[contains(@name,'city')]/following-sibling::div"));
        citySelectElement.click();
        WebElement citListContainer = citySelectElement.findElement

                //не видит этот локатор
                (By.xpath("//button[@data-empty='Город']//..//.."));
        waitTools.waitForCondition(ExpectedConditions.not
                (ExpectedConditions.attributeContains(citListContainer, "class", "hide")));

         waitTools.waitForCondition(ExpectedConditions.not
        (ExpectedConditions.attributeToBe(citListContainer, "disabled", "disabled")));

        driver.findElement(By.cssSelector(String.format("[title='%s']", cityData.getCountriesData().getName()))).click();

        waitTools.waitForCondition(ExpectedConditions.attributeContains(citListContainer, "class", "hide"));
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
        driver.findElement(By.xpath(String.format("//span[@class='radio__label' and text()='%s']",relocate))).click();
    }

    public void selectWorkGraph(boolean isSelected, WorkGraphData... workGraphDatas) {

        for(WorkGraphData workGraphData : workGraphDatas) {

        WebElement checkBox = driver.findElement(By.cssSelector(String.format("input[title='%s']", workGraphData.getName())));

        if(checkBox.isSelected() != isSelected) {
            checkBox.click();
        }
        }

    }

//    public void selectGender() {
//        String fieldGenderId = "id_gender";
//
//        driver.findElement(By.id(fieldGenderId)).click();
//        Select genderSelect = new Select(driver.findElement(By.id(fieldGenderId)));
//        genderSelect.selectByVisibleText("Женский");
////
//    }  option[value='m']
    public void selectGender(GenderData genderData) {

        WebElement selectGengerElement = driver.findElement(By.id("id_gender"));
        selectGengerElement.click();

        WebElement genderElement = driver.findElement(By.cssSelector(String.format("option[value='%s']")));
        waitTools.waitElementToBeClickable(By.cssSelector(String.valueOf(genderData.getName())));
        genderElement.click();
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

