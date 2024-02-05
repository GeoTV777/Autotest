package data.personal;

public enum CompanyData {
    COMPANY("ООО ГАЗ"),
    POSITION("менеджер");

    private String name;
    CompanyData(String name) {
        this.name= name;
    }
    public String getName() {
        return name;
    }
}
