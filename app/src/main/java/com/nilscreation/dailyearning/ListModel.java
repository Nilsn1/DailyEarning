package com.nilscreation.dailyearning;

public class ListModel {

    String title;
    String description;
    String imgUrl;
    String appUrl;
    int bonus;

    public ListModel() {

    }

    public ListModel(String title, String description, String imgUrl, String appUrl, int bonus) {
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.appUrl = appUrl;
        this.bonus = bonus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
