package data.personal;

public enum PersonalData {
    NAME("name"),
    SURNAME("surName"),
    NAMELAT("nameLat"),
    SURNAMELAT("surnameLat"),
    NAMECHAT("nameChat"),
    DATE("date");

    private String name;
    PersonalData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
