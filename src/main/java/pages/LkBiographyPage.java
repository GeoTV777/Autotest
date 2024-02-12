package pages;

import data.personal.*;
import data.sities.ICityData;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LkBiographyPage extends AbsBasePage {

    public LkBiographyPage(WebDriver driver) {
        super(driver);
    }

    public void clearPersData(PersonalData... personalData) {
        for(PersonalData persData : personalData){
            driver.findElement(By.cssSelector(String.format("input[name='%s']", persData.getName()))).clear();
            logger.info("Cleared");
        }
    }

    public void inputFio(PersonalData personalData, String data) {
                driver.findElement(By.cssSelector(String.format("input[name='%s']", personalData.getName()))).sendKeys(data);
                logger.info("Data is filled in");
        }


    public void selectCountryAbdCity(ICityData cityData) {
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
        waitTools.waitForCondition(ExpectedConditions.attributeContains(
                By.cssSelector("[data-title='Город']"), "disabled", "disabled"));


        WebElement citySelectElement = driver.findElement(By.cssSelector("[name='city']+*"));
        citySelectElement.click();

        WebElement citiListContainer = driver.findElement(By.xpath("//button[@data-empty='Город']//..//.."));
        waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(citiListContainer, "class", "hide")));

        driver.findElement(By.cssSelector(String.format("[title='%s']",cityData.getName()))).click();
        waitTools.waitForCondition(ExpectedConditions.attributeContains(citiListContainer, "class", "hide"));
        logger.info("City selected");

    }


    public void selectEnglishLevel(EnglishLevelData englishLevelData) {
        WebElement selectEnglishLevel = driver. findElement
                (By.xpath("//input[@name ='english_level']/following::*"));
        selectEnglishLevel.click();

        WebElement levelListContainer = selectEnglishLevel.findElement
                (By.xpath("//div[contains(@class,'lk-cv-block__select-options js-custom-select-options-container')]"));
        waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(levelListContainer,"class", "hide")));
        driver.findElement(By.cssSelector(String.format("[title='%s']",englishLevelData.getName()))).click();
        logger.info("Level English selected");
    }


    public void selectToRelocate(boolean isSelected) {
        String relocate = isSelected ? "Да" : "Нет";
        driver.findElement(By.xpath(String.format("//span[@class='radio__label' and text()='%s']",relocate))).click();
        logger.info("Check relocate");
    }

    public void selectWorkGraph(boolean isSelected, WorkGraphData... workGraphDatas) {

        for(WorkGraphData workGraphData : workGraphDatas) {

        WebElement checkBox = driver.findElement(By.cssSelector(String.format("input[title='%s']+*", workGraphData.getName())));

        if(checkBox.isSelected() != isSelected) {
            checkBox.click();
        }
        }
        logger.info("Check work mode");
    }

    public void selectGender() {
        String fieldGenderId = "id_gender";

        driver.findElement(By.id(fieldGenderId)).click();
        Select genderSelect = new Select(driver.findElement(By.id(fieldGenderId)));
        genderSelect.selectByVisibleText("Женский");
        waitTools.waitNotElementPresent(By.cssSelector(fieldGenderId));

        logger.info("Gender selected");
    }

    public void inputPlaceOfWorkAndPosition(WorkData workData, String data) {
        driver.findElement(By.id(String.format("%s",workData.getName()))).sendKeys(data);
        logger.info("Other data is filled in");


    }

    public void save() {

        WebElement buttonSaveAndContinueSelector = driver.findElement(By.cssSelector("[name='continue']"));
        buttonSaveAndContinueSelector.click();
        logger.info("Data saved");

    }
    public void controlSave() {


    }



}

