package model;

public class hospital {
    private String address;
    private String name;
    private String dean;
    private  String phoneNumber;

    public hospital(String address, String name, String dean, String phoneNumber) {
        this.address = address;
        this.name = name;
        this.dean = dean;
        this.phoneNumber = phoneNumber;
    }
    public hospital()
    {

    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
