package com.example.url_shortener.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UrlVO {
    @Id
    @GeneratedValue
    long id;
    String longURL;
    String shortURL;

    public UrlVO() {
    }

    public UrlVO(String longURL, String shortURL) {
        this.longURL = longURL;
        this.shortURL = shortURL;
    }
}
