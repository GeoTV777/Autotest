package data.personal;

public enum PersonalData {
    NAME("fname"),
    SURNAME("lname"),
    NAMELAT("fname_latin"),
    SURNAMELAT("lname_latin"),
    NAMECHAT("blog_name"),
    DATE("date_of_birth");

    private String name;
    PersonalData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
