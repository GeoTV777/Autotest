package components.lk_biogpaphy;

import common.AbsCommon;
import data.personal.CommunicationMethodData;
import data.personal.NumberFormInputData;
import data.personal.PersonalData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactInfo extends AbsCommon {
    private String inputFormLocator ="//input[contains(@id,'id_contact-%s-value')]";

    public ContactInfo(WebDriver driver) {
        super(driver);
    }


    public void addContactInfoForm(NumberFormInputData numberFormInputData, CommunicationMethodData communicationMethodData, String data) {

        WebElement inputForm = driver.findElement(By.xpath(String.format(inputFormLocator, numberFormInputData.getName())));

        WebElement selectMethod = inputForm.findElement(By.xpath(".//..//div[contains(@class,'input_no-border-right')]/span"));
        selectMethod.click();


        WebElement listContainerMethod = driver.findElement(By.xpath("//div[contains(@class,'k-cv-block__select-options_left js-custom-select-options-container')]"));

        WebElement selectElement = inputForm.findElement(By.xpath(String.format(".//..//button[contains(@data-value,'%s')]", communicationMethodData.getName())));
//        waitTools.waitElementToBeClickable(By.xpath(String.format(String.valueOf(selectElement))));
        selectElement.click();


        inputForm.click();
        inputForm.sendKeys(data);
        logger.info("Phone number provided ");
    }
    public void addingAnInputField() {
        WebElement buttonAdd =driver.findElement(By.cssSelector("[class~='lk-cv-block__action_md-no-spacing'][class~='js-formset-add']"));
      buttonAdd.click();
      logger.info("Form added");

    }

    public void controlSaveContactInformation(NumberFormInputData...formInputData) {
        for (NumberFormInputData formInputData1 : formInputData) {
        Assertions.assertTrue(driver.findElement(By.cssSelector(String.format(inputFormLocator, formInputData1.getName()))).isDisplayed(), "Element is not displayed");
        Assertions.assertTrue(!driver.findElement(By.cssSelector(String.format(inputFormLocator, formInputData1.getName()))).getText().isEmpty(), "Element is empty");
        }
    }
}
