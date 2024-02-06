package data.personal;

public enum ContactsData {
    EMAIL("777@mail.ru"),
    TELEPHONE("+79818077777"),
    TELEGRAMM("+79818077777"),
    WHATSUPP("+79818077777");

    public String name;
    ContactsData(String name){
        this.name= name();
    }
    public String getName() {
        return name;
    }
}
