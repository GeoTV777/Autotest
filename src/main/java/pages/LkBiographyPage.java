package pages;

import data.personal.*;
import data.sities.ICityData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class LkBiographyPage extends AbsBasePage {
    private String personalDataInputSelector = "input[name='%s']";
    private String countryInputSelector = "[data-slave-selector='.js-lk-cv-dependent-slave-city']";
    private String cityInputSelector = "[name='city']+*";
    private String englishLevelInputLocator = "//input[@name ='english_level']/following::*";
    private String fieldGenderId = "id_gender";

    public LkBiographyPage(WebDriver driver) {
        super(driver);
    }


    public void clearPersData(PersonalData... personalData) {
        for (PersonalData persData : personalData) {
            driver.findElement(By.cssSelector(String.format(personalDataInputSelector, persData.getName()))).clear();
            logger.info("Cleared");
        }
    }

    public void inputFio(PersonalData personalData, String data) {
        driver.findElement(By.cssSelector(String.format(personalDataInputSelector, personalData.getName()))).sendKeys(data);
        logger.info("Data is filled in");
    }


    public void selectCountryAbdCity(ICityData cityData) {
        WebElement russiaSelectElement = driver.findElement(By.cssSelector(countryInputSelector));
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

        WebElement citySelectElement = driver.findElement(By.cssSelector(cityInputSelector));
        citySelectElement.click();

        WebElement citiListContainer = driver.findElement(By.xpath("//button[@data-empty='Город']//..//.."));
        waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(citiListContainer, "class", "hide")));

        driver.findElement(By.cssSelector(String.format("[title='%s']", cityData.getName()))).click();
        waitTools.waitForCondition(ExpectedConditions.attributeContains(citiListContainer, "class", "hide"));
        logger.info("City selected");
    }

    public void selectEnglishLevel(EnglishLevelData englishLevelData) {
        WebElement selectEnglishLevel = driver.findElement(By.xpath(englishLevelInputLocator));
        selectEnglishLevel.click();

        WebElement levelListContainer = driver.findElement
                (By.xpath("//div[contains(@class,'lk-cv-block__select-options js-custom-select-options-container')]"));
        waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(levelListContainer, "class", "hide")));
        driver.findElement(By.cssSelector(String.format("[title='%s']", englishLevelData.getName()))).click();
        logger.info("Level English selected");
    }


    public void selectToRelocate(boolean isSelected) {
        String relocate = isSelected ? "Да" : "Нет";
        driver.findElement(By.xpath(String.format("//span[@class='radio__label' and text()='%s']", relocate))).click();
        logger.info("Check relocate");
    }

    public void selectWorkGraph(boolean isSelected, WorkGraphData... workGraphDatas) {

        for (WorkGraphData workGraphData : workGraphDatas) {
            WebElement checkBox = driver.findElement(By.cssSelector(String.format("input[title='%s']+*", workGraphData.getName())));

            if (checkBox.isSelected() != isSelected) {
                checkBox.click();
            }
        }
        logger.info("Check work mode");
    }

    public void selectGender() {
        driver.findElement(By.id(fieldGenderId)).click();
        Select genderSelect = new Select(driver.findElement(By.id(fieldGenderId)));
        genderSelect.selectByVisibleText("Женский");
        waitTools.waitNotElementPresent(By.cssSelector(fieldGenderId));

        logger.info("Gender selected");
    }

    public void inputPlaceOfWorkAndPosition(WorkData workData, String data) {
        driver.findElement(By.id(String.format("%s", workData.getName()))).sendKeys(data);
        logger.info("Other data is filled in");
    }

    public void save() {
        WebElement buttonSaveAndContinueSelector = driver.findElement(By.cssSelector("[name='continue']"));
        buttonSaveAndContinueSelector.click();
        logger.info("Data saved");
    }

    public void controlSavePersonal(PersonalData... personalData) {
        for (PersonalData personalData1 : personalData) {
            WebElement personalElement = driver.findElement(By.cssSelector(String.format(personalDataInputSelector, personalData1.getName())));
            Assertions.assertTrue(personalElement.isDisplayed(), "Element is not displayed");
            String value = personalElement.getAttribute("value");
            Assertions.assertTrue(value != null && !value.isEmpty(), "Element is empty");
        }
    }

    public void controlSaveBasicInformation() {
        WebElement countryInput = driver.findElement(By.cssSelector(String.format(countryInputSelector)));
        Assertions.assertTrue(countryInput.isDisplayed(), "Country input element is not displayed");
        Assertions.assertFalse(countryInput.getText().isEmpty(), "Country in put element is empty");

        WebElement cityInput = driver.findElement(By.cssSelector(String.format(cityInputSelector)));
        Assertions.assertTrue(cityInput.isDisplayed(), "City input element is not displayed");
        Assertions.assertFalse(cityInput.getText().isEmpty(), "City input element is empty");

        WebElement englishLevelInput = driver.findElement(By.xpath(String.format(englishLevelInputLocator)));
        Assertions.assertTrue(englishLevelInput.isDisplayed(), "English level input element is not displayed");
        Assertions.assertFalse(englishLevelInput.getText().isEmpty(), "English level input element is empty");

        WebElement genderInput = driver.findElement(By.id(String.format(fieldGenderId)));
        Assertions.assertTrue(genderInput.isDisplayed(), "Gender input element is not displayed");
        Assertions.assertFalse(genderInput.getText().isEmpty(), "Gender input element is empty");
    }


    public boolean controlRelocateIsSelected() {
        WebElement relocateElement = driver.findElement(By.xpath("//span[@class='radio__label' and text()='Да']"));
        return relocateElement.isSelected();
    }

    public void controlSelectWorkGraph(boolean isSelected, WorkGraphData... workGraphDatas) {
        for (WorkGraphData workGraphData : workGraphDatas) {
            WebElement checkBox = driver.findElement(By.cssSelector(String.format("input[title='%s']", workGraphData.getName())));
            boolean checkBoxSelected = checkBox.isSelected();
            Assertions.assertTrue(isSelected == checkBoxSelected,"Checkbox is not selected");
        }
    }
}


