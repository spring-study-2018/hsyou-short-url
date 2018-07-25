package com.example.url_shortener.controller;

import com.example.url_shortener.model.URLRequest;
import com.example.url_shortener.repository.URLRedisRepository;
import com.example.url_shortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class URLController {

    @Autowired
    URLService urlService;

//    @RequestMapping("/")
//    public Iterable<URLRequest> getAll() {
//
//    }
    @PostMapping("/")
    public String requestShortenURL(URLRequest vo) {
        return urlService.postURL(vo);
    }

    @RequestMapping("/{shortURL}")
    public String getLongURL(@PathVariable String shortURL) {
        return urlService.getURL(shortURL);
    }


}
