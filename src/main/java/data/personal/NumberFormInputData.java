package data.personal;

public enum NumberFormInputData {

    FORM1("0"),
    FORM2("1"),
    FORM3("2"),
    FORM4("3");

    public String name;

    NumberFormInputData(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }


}
