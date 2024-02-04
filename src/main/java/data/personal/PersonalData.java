package data.personal;

public enum PersonalData {

    NAME("Татьяна"),
    NAMELAT("Tatyana"),

    SURNAME("Гео"),
    NAMECHAT("Tatyana"),

    DATE("07.08.2007");

    private String name;
    PersonalData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
