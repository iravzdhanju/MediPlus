package model;

public class client {
    private String healthCardNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private String status;
    private String bloodType;
    private String age;
    private String password;

    public client(String healthCardNumber, String firstName, String lastName, String address, String phoneNumber, String email, String status, String bloodType, String age, String password) {
        this.healthCardNumber = healthCardNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.status = status;
        this.bloodType = bloodType;
        this.age = age;
        this.password = password;
    }

    public client(String healthCardNumber, String firstName, String lastName, String phoneNumber, String email, String status, String bloodGroup, String age, String password)
    {

    }

    public String getHealthCardNumber() {
        return healthCardNumber;
    }

    public void setHealthCardNumber(String healthCardNumber) {
        this.healthCardNumber = healthCardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
