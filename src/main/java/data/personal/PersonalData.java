package data.personal;

public enum PersonalData {
    NAME("Элеонора"),
    SURNAME("Руль"),
    NAMELAT("Eleonora"),
    SURNAMELAT("Rul"),
    DATE("07.08.2007");

    private String name;
    PersonalData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
