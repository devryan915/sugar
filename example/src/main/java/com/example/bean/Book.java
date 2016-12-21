package com.example.bean;

import com.orm.SugarRecord;

//@Table
public class Book extends SugarRecord {
    public String title;
    public String edition;

    public Book() {
    }

    public Book(String title, String edition) {
        this.title = title;
        this.edition = edition;
    }
}