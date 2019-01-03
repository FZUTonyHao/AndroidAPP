package com.example.feng.uiwidgettest;

public class Book {
    private String name;
    private int imageId;
    public Book(String name, int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public Book() {
    }

    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
