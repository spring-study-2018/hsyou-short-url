package com.example.url_shortener.controller;

import com.example.url_shortener.model.URLRequest;
import com.example.url_shortener.repository.URLRepository;
import com.example.url_shortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class URLController {

    @Autowired
    URLService urlService;
    @Autowired
    URLRepository urlRepository;

    @RequestMapping("/")
    public Iterable<URLRequest> getAll() {
        return urlRepository.findAll();

    }
    @PostMapping("/")
    public String requestShortenURL(URLRequest vo) {

        return urlService.shortenURL(vo);
    }

    @RequestMapping("/{shortURL}")
    public String getLongURL(@PathVariable String shortURL) {
        Optional<URLRequest> o = urlRepository.findById(shortURL);
        if(o.isPresent()) return o.get().getLongURL();
        else return "";
    }


}
