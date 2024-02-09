package components.lk_biogpaphy;

import common.AbsCommon;
import data.personal.EnglishLevelData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactInfo extends AbsCommon {

    public ContactInfo(WebDriver driver) {
        super(driver);
    }

    public void addField() {
        WebElement buttonAdd = driver.findElement(By.cssSelector(""));
        buttonAdd.click();
    }




//  ЭТО ПРИМЕР ИЗ ДРУГОГО КЛАССА
//    public void selectEnglishLevel(EnglishLevelData englishLevelData) {
//        WebElement selectEnglishLevel = driver. findElement
//                (By.xpath("//input[@name ='english_level']/following::*"));
//        selectEnglishLevel.click();
//
//        WebElement levelListContainer = selectEnglishLevel.findElement
//                (By.xpath("//div[contains(@class,'lk-cv-block__select-options js-custom-select-options-container')]"));
//        waitTools.waitForCondition(ExpectedConditions.not(ExpectedConditions.attributeContains(levelListContainer,"class", "hide")));
//        driver.findElement(By.cssSelector(String.format("[title='%s']",englishLevelData.getName()))).click();
//        logger.info("Level English selected");
//    }
}
