package pages;

import org.openqa.selenium.WebDriver;

public class LkBiographyPage extends AbsBasePage {

    private String inputDataTemplate = "input[data-title ='%s']";

//    private String inputNameSelector = "[id='id_fname']";
//    private String inputNameLatinSelector ="[id='id_fname_latin']";
    //cоздать енам!
    public LkBiographyPage(WebDriver driver) {
        super(driver);
    }

    // здесь должен быть метод, который вызывает из енамов города и страны

}
