package components;

import common.AbsCommon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingInPopup extends AbsCommon implements IPopup {
    private Logger logger = (Logger) LogManager.getLogger("Autotest");
    private String login= System.getProperty("login");
    private String password= System.getProperty("password");


    private String signInPopupSelector = "#__PORTAL__ > div";
    private String headerIconOwlSelector = "img[src*='blue-owl']";
   private String btnEntrySelector = "#__PORTAL__ button";

    public SingInPopup(WebDriver driver) {
        super(driver);
    }

    public void authorization(){
        String headerSignInButton = "//button[text()='Войти']";
        String inputNameClickLocator = "//input[@name]/..";
        String inputNameLocator = "//input[@name]";
        String warningNameSelector = "[fill-rule='nonzero']";
        String inputPassClickLocator = "//input[@type='password']/..";
        String inputPassLocator = "//input[@type='password']";
//        String btnEntrySelector = "#__PORTAL__ button";

        waitTools.waitElementPresent(By.xpath(headerSignInButton));
        driver.findElement(By.xpath(headerSignInButton)).click();
        logger.info("Login button pressed");

        popupShouldBeVisible();

        waitTools.waitElementPresent(By.cssSelector(signInPopupSelector));
        driver.findElement(By.xpath(inputNameClickLocator)).click();
        driver.findElement(By.xpath(inputNameLocator)).sendKeys(login);
        waitTools.waitElementPresent(By.cssSelector(warningNameSelector));

        waitTools.waitElementToBeClickable(By.xpath(inputPassClickLocator));
        driver.findElement(By.xpath(inputPassClickLocator)).click();
        driver.findElement(By.xpath(inputPassLocator)).sendKeys(password);

        waitTools.waitElementToBeClickable(By.cssSelector(btnEntrySelector));
        driver.findElement(By.cssSelector(btnEntrySelector)).click();
        logger.info("Button Ok");
        logger.info("Authorization completed");

    }
    public void enterHeaderIconOwl() {
        waitTools.waitElementToBeClickable(By.cssSelector(headerIconOwlSelector));
        WebElement element = driver.findElement(By.cssSelector(headerIconOwlSelector));
        actions.moveToElement(element).perform();
        logger.info("Owl button hovered");

    }
    public void selectLkInMenu() {
        String buttonLkLocator = "//div/a[@href='https://otus.ru/learning']";
        waitTools.waitElementToBeClickable(By.xpath(buttonLkLocator));
        driver.findElement(By.xpath(buttonLkLocator)).click();
        logger.info("LK is open");
        
    }


    @Override
    public void popupShouldNotBeVisible() {
        Assertions.assertFalse(waitTools.waitForCondition(ExpectedConditions.not
                        (ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(btnEntrySelector)))),
                "Error: the element is present");
    }

    @Override
    public void popupShouldBeVisible() {
        Assertions.assertTrue(waitTools.waitElementPresent(By.cssSelector(signInPopupSelector)),
                "The popup message window is invisible");
    }
}
