package com.aka.campus_lancer;


import com.google.gson.annotations.SerializedName;

public class Persons {

//    @SerializedName("first_name")
    String name;
    int age;
    int photoId;

      public Persons(String name, int age, int photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public int getPhotoId() {return photoId;}





}