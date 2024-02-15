package components.sign_in;

import common.AbsCommon;
import components.IPopup;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SingInPopup extends AbsCommon implements IPopup {
    private String login= System.getProperty("login");
    private String password= System.getProperty("password");
    private String signInPopupSelector = "#__PORTAL__ > div";
    private String headerIconOwlSelector = "img[src*='blue-owl']";

    private String btnEntrySelector = "#__PORTAL__ button";

    public SingInPopup(WebDriver driver) {
        super(driver);
    }

    public void pressHeaderSignInButton() {
        String headerSignInButton = "//button[text()='Войти']";
        waitTools.waitElementPresent(By.xpath(headerSignInButton));
        driver.findElement(By.xpath(headerSignInButton)).click();
        logger.info("Login button pressed");

    }

    public void authorization(){

        String inputNameClickLocator = "//input[@name]/..";
        String inputNameLocator = "//input[@name]";
        String inputPassClickLocator = "//input[@type='password']/..";
        String inputPassLocator = "//input[@type='password']";
        String btnEntrySelector ="#__PORTAL__ button";

        popupShouldBeVisible();

        waitTools.waitElementPresent(By.cssSelector(signInPopupSelector));
        waitTools.waitElementToBeClickable(By.xpath(inputNameClickLocator));

        driver.findElement(By.xpath(inputNameClickLocator)).click();

        driver.findElement(By.xpath(inputNameLocator)).sendKeys(login);

        waitTools.waitElementToBeClickable(By.xpath(inputPassClickLocator));
        driver.findElement(By.xpath(inputPassClickLocator)).click();
        driver.findElement(By.xpath(inputPassLocator)).sendKeys(password);

        waitTools.waitElementToBeClickable(By.cssSelector(btnEntrySelector));
        driver.findElement(By.cssSelector(btnEntrySelector)).click();
        logger.info("Button Ok");
    }

    public void enterHeaderIconOwl() {
        waitTools.waitElementToBeClickable(By.cssSelector(headerIconOwlSelector));
        logger.info("Authorization completed");
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
    public void auth(){
        pressHeaderSignInButton();
        authorization();
    }

    public void transitionToPersonalData() {
        String headerIconPinkOwlSelector ="[class='sc-1ceoo74-1 cQzahz']";

        pressHeaderSignInButton();
        authorization();

        waitTools.waitElementToBeClickable(By.cssSelector(headerIconPinkOwlSelector));
        logger.info("Authorization completed");
        WebElement element = driver.findElement(By.cssSelector(headerIconPinkOwlSelector));
        actions.moveToElement(element).perform();
        logger.info("Owl button hovered");

        selectLkInMenu();
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
