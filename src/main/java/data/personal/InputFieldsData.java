package data.personal;

import org.openqa.selenium.By;

public enum InputFieldsData {
    INPUT_NAME(By.cssSelector("input[name='fname']")),
    INPUT_SURNAME(By.cssSelector("input[name='lname']")),
    INPUT_NAMELAT(By.cssSelector("input[name='fname_latin']")),
    INPUT_SURNAMELAT(By.cssSelector("input[name='lname_latin']")),
    INPUT_NAMECHAT(By.cssSelector("input[name='blog_name']")),
    INPUT_DATE(By.cssSelector("input[name='date_of_birth']")),
    INPUT_COUNTRY(By.cssSelector("[title='Россия']")),// нужен селектор где отображается информация
    INPUT_CITY(By.cssSelector("[title='Санкт-Петербург']")),// нужен селектор где отображается информация
    INPUT_LEVEL_ENGLISH(By.xpath("[title='Средний (Intermediate)']")),// нужен селектор где отображается информация
    INPUT_CIONTACT_INFO0(By.xpath("//input[contains(@id,'id_contact-0-value')]")),// нужен селектор где отображается информация
    INPUT_CIONTACT_INFO1(By.xpath("//input[contains(@id,'id_contact-1-value')]")),// нужен селектор где отображается информация
    INPUT_CIONTACT_INFO2(By.xpath("//input[contains(@id,'id_contact-2-value')]")),// нужен селектор где отображается информация
    INPUT_GENDER(By.xpath("")),// нужен селектор где отображается информация
    INPUT_COMPANY(By.xpath("")),// нужен селектор где отображается информация
    INPUT_POSITION(By.xpath(""));// нужен селектор где отображается информация

    public By locator;

    InputFieldsData(By locator) {
        this.locator = locator;
    }
    public String getLocator(){
        return String.valueOf(locator);
    }

}
