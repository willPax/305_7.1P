package com.example.a71p_lostandfound.model;

public class AdvertisedItem {

    private int add_ID;
    private String userName;
    private String userPhone;
    private String itemName;
    private String founddate;
    private String foundLocation;

    public AdvertisedItem(String userName, String userPhone, String itemName, String founddate, String foundLocation) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.itemName = itemName;
        this.founddate = founddate;
        this.foundLocation = foundLocation;
    }

    public AdvertisedItem() {
    }


    public int getAdd_ID() {
        return add_ID;
    }

    public void setAdd_ID(int add_ID) {
        this.add_ID = add_ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String  getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String  userPhone) {
        this.userPhone = userPhone;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getFounddate() {
        return founddate;
    }

    public void setFounddate(String founddate) {
        this.founddate = founddate;
    }

    public String getFoundLocation() {
        return foundLocation;
    }

    public void setFoundLocation(String foundLocation) {
        this.foundLocation = foundLocation;
    }
}
