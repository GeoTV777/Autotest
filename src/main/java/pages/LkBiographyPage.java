package pages;

import data.sities.CountriesData;
import data.sities.RussianCitiesData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LkBiographyPage extends AbsBasePage {
    private Logger logger = (Logger) LogManager.getLogger("Autotest");

    private String inputDataTemplate = "input[data-title ='%s']";

//    private String inputNameSelector = "[id='id_fname']";
//    private String inputNameLatinSelector ="[id='id_fname_latin']";
    public LkBiographyPage(WebDriver driver) {
        super(driver);
    }

    public void selectCountryAndCity(CountriesData countriesData, RussianCitiesData russianCitiesData) {
        String russiaSelector="button[title='Россия']";
        String spbLSelector = "button[title='Санкт-Петербург']";

        String country = countriesData.getName();
        String city = russianCitiesData.getName();

        WebElement countryElement = driver.findElement(By.cssSelector(russiaSelector));
        driver.findElement(By.cssSelector(russiaSelector)).click();
        Select countrySelect = new Select(countryElement);
        countrySelect.selectByVisibleText(country);
        logger.info("Country select");

        WebElement cityElement = driver.findElement(By.cssSelector(spbLSelector));
        driver.findElement(By.cssSelector(spbLSelector)).click();
        Select citySelect = new Select(cityElement);
        citySelect.selectByVisibleText(city);
        logger.info("City select");
    }
}
