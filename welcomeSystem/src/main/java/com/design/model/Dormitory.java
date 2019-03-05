package com.design.model;

public class Dormitory {
    private Integer id;

    private String site;

    private int floor;

    private int dormitoryNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getDormitoryNum() {
        return dormitoryNum;
    }

    public void setDormitoryNum(int dormitoryNum) {
        this.dormitoryNum = dormitoryNum;
    }
}
