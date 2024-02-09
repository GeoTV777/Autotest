package data.personal;

public enum AnyData {
    COMPANY("ООО ГАЗ"),
    POSITION("менеджер");

    private String name;
    AnyData(String name) {
        this.name= name;
    }
    public String getName() {
        return name;
    }
}
