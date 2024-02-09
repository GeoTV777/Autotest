package components.lk_biogpaphy;

import common.AbsCommon;
import components.IPopup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TelephoneNumberPopup extends AbsCommon implements IPopup {

    public TelephoneNumberPopup(WebDriver driver) {
        super(driver);
    }

    public void InputNumber(String data) {

        String telephoneModalWindow = ".login-modal__container";
        String numberInputClick = "input[placeholder='Номер телефона']";
        String buttonBlueSend =".js-send.button.button_blue.button_md";
        String codeInputPlace = ".input input_full js-code";

        waitTools.waitNotElementPresent(By.cssSelector(telephoneModalWindow));
        driver.findElement(By.cssSelector(numberInputClick)).click();
        waitTools.waitElementToBeClickable(By.cssSelector(numberInputClick));
        driver.findElement(By.cssSelector(numberInputClick)).sendKeys(data);
        driver.findElement(By.cssSelector(buttonBlueSend)).click();
        waitTools.waitElementPresent(By.cssSelector(codeInputPlace));
        driver.findElement(By.cssSelector(codeInputPlace)).click();
        driver.findElement(By.cssSelector(codeInputPlace)).sendKeys(data);
        driver.findElement(By.cssSelector(buttonBlueSend));
        // Код подтверждения  можно получить на телефон и после сохранения это окно уже не будет активно, не очищается

    }


    @Override
    public void popupShouldNotBeVisible() {

    }

    @Override
    public void popupShouldBeVisible() {

    }
}
