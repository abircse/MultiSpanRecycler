package com.studioabir.recyclerbanner.recyclearbanner;

public class AdminModel {

    private String name;
    private String position;


    public AdminModel(String name, String position) {

        this.name = name;
        this.position = position;

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


}
