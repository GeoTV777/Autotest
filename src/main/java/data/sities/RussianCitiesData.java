package data.sities;

public enum RussianCitiesData implements ICityData {
    SAINTPETERBURG("Санкт-Петербург", CountriesData.RUSSIA);

    private String name;
    private CountriesData countriesData;

    RussianCitiesData(String mame, CountriesData countriesData){
        this.name = name();
        this.countriesData= countriesData;
    }

    public String getName() {
        return name;
    }

    @Override
    public CountriesData getCountriesData() {
        return countriesData;
    }

}
