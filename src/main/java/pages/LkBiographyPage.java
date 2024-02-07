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

public class LkBiographyPage extends AbsBasePage {


    //  поле имя id_fname
    //  поле фамилия id_lname
    // поле имя лат id_fname_latin
    // поле фамилия лат id_lname_latin
     //  поле имя в блоге id_blog_name
    // поле дата  селектор [title='День рождения']
    //   [title='О себе']

    //  поле страна [class='lk-cv-block__select-options js-custom-select-options-container']
    // поле город
    // поле уровень английского




    //        WebElement inputName = driver.findElement(By.cssSelector(String.format("[data-title='%s']", personalData.getName())));
//        inputName.click();
//        inputName.sendKeys(PersonalData.NAME.getName());
//        WebElement inputSurname = driver.findElement(By.cssSelector(String.format("[data-title='%s']", personalData.getName())));
//        inputSurname.click();
//        inputSurname.sendKeys(PersonalData.SURNAME.getName());
//
//       WebElement inputNameLat = driver.findElement(By.id("id_fname_latin"));
//       inputNameLat.click();
//       inputNameLat.sendKeys(PersonalData.NAMELAT.getName());
//
//       WebElement inputSurnameLat = driver.findElement(By.id("id_lname_latin"));
//       inputSurnameLat.click();
//       inputSurnameLat.sendKeys(PersonalData.SURNAMELAT.getName());
//
//       WebElement inputDate = driver.findElement(By.cssSelector("[title='%s']"));
//       inputDate.click();
//       inputDate.sendKeys(PersonalData.DATE.getName());
//    }

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
                (By.xpath("//button[contains(@title,'Россия')]//..//.."));
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
        driver.findElement(By.xpath(String.format("//span[@class='radio__label' and text()='%ы']",relocate))).click();

    }

    public void selectWorkGraph(boolean isSelected, WorkGraphData... workGraphDatas) {

    for(WorkGraphData workGraphData : workGraphDatas) {

        WebElement checkBox = driver.findElement(By.cssSelector(String.format("input[title='%s']", workGraphData.getName())));

        if(checkBox.isSelected() != isSelected) {
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

