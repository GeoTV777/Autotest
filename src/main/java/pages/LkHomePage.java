package pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LkHomePage extends AbsBasePage {
    public LkHomePage(WebDriver driver) {
        super(driver);
    }
    public void setSelectTabAboutMe(){
        String selectTabAboutMeSelector = "[title='О себе']";
        driver.findElement(By.xpath(selectTabAboutMeSelector)).click();
    }
}
