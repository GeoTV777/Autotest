package data.personal;

public enum WorkData {
    COMPANY("id_company"),
    POSITION("id_work");

    private String name;
    WorkData(String name) {
        this.name= name;
    }
    public String getName() {
        return name;
    }
}
