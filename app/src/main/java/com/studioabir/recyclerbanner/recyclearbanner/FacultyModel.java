package com.studioabir.recyclerbanner.recyclearbanner;

public class FacultyModel {

    private String name;
    private String position;
    private String department;
    private String email;
    private String phone;

    public FacultyModel(String name, String position, String department, String email, String phone) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
