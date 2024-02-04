package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LkHomePage extends AbsBasePage {
    private Logger logger = (Logger) LogManager.getLogger("Autotest");
    public LkHomePage(WebDriver driver) {
        super(driver);
    }
    public void setSelectTabAboutMe(){
        String selectTabAboutMeSelector = "[title='О себе']";

        driver.findElement(By.cssSelector(selectTabAboutMeSelector)).click();
        logger.info("Tab About_Me selected ");
    }
}
