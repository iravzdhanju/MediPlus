package model;

public class apointment {
    private String name;
    private String desease;
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesease() {
        return desease;
    }

    public void setDesease(String desease) {
        this.desease = desease;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public apointment(String name, String desease, String date) {
        this.name = name;
        this.desease = desease;
        this.date = date;
    }
}
