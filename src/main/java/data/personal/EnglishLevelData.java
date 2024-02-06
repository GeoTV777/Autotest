package data.personal;

public enum EnglishLevelData {

    BEGINNER("Начальный уровень"),
    ELEMENTARY("Элементарный уровень"),
    PREINTERMEDIATE("Ниже среднего"),
    INTERMEDIATE("Средний");
    private String name;

    EnglishLevelData(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

