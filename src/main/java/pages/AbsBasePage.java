package pages;

import common.AbsCommon;
import factory.logger.LoggerManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;

public class AbsBasePage extends AbsCommon {

    private String BASE_URL = System.getProperty("base.url");


    public AbsBasePage(WebDriver driver){
        super(driver);
    }
    public void open() {
        driver.get(BASE_URL);
    }

    public void open(String path) {
        driver.get(BASE_URL + path);
    }



}
