package com.example.url_shortener.service;

import com.example.url_shortener.model.URLRequest;
import com.example.url_shortener.repository.URLRepository;
import com.example.url_shortener.util.Base62;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLService {

    @Autowired
    URLRepository urlRepository;


    public String shortenURL(URLRequest vo){


        long n = 0;
        String longURL = vo.getLongURL();
        char[] chars = longURL.toCharArray();

        for(int i= chars.length-1; i>= 0; i--) {
            n+=Base62.ALPHABET.indexOf(chars[i]) * (int) Math.pow(62, i);
        }

        vo.setShortUrl(Base62.fromBase10(n));

        urlRepository.save(vo);

        return Base62.fromBase10(n);
    }

}
