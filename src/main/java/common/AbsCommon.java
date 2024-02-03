package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import tools.WaitTools;

public class AbsCommon {
    protected WebDriver driver;
    protected WaitTools waitTools;
    protected Actions actions;
 private Logger logger = (Logger) LogManager.getLogger("Autotest");

    public AbsCommon(WebDriver driver) {
        this.driver = driver;
        waitTools = new WaitTools(driver);
        this.actions = new Actions(driver);
    }

}
