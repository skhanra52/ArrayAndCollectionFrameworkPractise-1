package com.skhanra52.practiceArrayList;

public record GroceryItems(String name, String type, int count) {

    public GroceryItems(String name){
        this(name,"DIARY", 1);
    }
}
