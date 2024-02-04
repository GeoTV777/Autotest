package data.personal;

public enum CompanyData {

    COMPANY(""),
    POSITION("");

    private String name;
    CompanyData(String name) {
        this.name= name;
    }
    public String getName() {
        return name;
    }
}
