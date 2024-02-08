package data.personal;

public enum GenderData {

    NOTSELECTED("Не указано"),
    FEMALE("Женский"),
    MALE("Мужской");

    public String name;
    GenderData(String name) {
        this.name=name();
    }
    public String getName() {
        return name;
    }
}

