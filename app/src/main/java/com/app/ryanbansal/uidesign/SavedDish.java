package com.app.ryanbansal.uidesign;

/**
 * Created by RyanBansal on 12/8/17.
 */


public class SavedDish {

    public String DishName;
    public String Description;
    public String PhotoUrl;

    public SavedDish(String dishName, String description, String photoUrl) {
        DishName = dishName;
        Description = description;
        PhotoUrl = photoUrl;

    }

    public SavedDish() { }

//    public void setdishName(String dishName) {
//        DishName = dishName;
//    }
//
//    public void setdescription(String description) {
//        Description = description;
//    }
//
//    public void setdishid(String dishid){
//        Dishid = dishid;
//    }

}