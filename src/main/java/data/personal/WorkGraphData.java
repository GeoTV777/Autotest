package data.personal;

public enum WorkGraphData {

    FULL("Полный день"),
    FLEXIBLE("Гибкий график"),
    REMOTE("Удаленно");

    public String name;
    WorkGraphData(String name){
        this.name= name();
    }
    public String getName() {
        return name;
    }






}
