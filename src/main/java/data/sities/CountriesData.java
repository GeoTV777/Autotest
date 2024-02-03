package data.sities;

public enum CountriesData {
    RUSSIA("Россия"),
    BELARUSIA("Республика Беларусь");
    private String name;

    CountriesData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

