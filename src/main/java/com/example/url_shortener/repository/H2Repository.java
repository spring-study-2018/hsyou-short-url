package com.example.url_shortener.repository;

import com.example.url_shortener.model.UrlVO;
import org.springframework.data.repository.CrudRepository;

public interface H2Repository extends CrudRepository<UrlVO, Long> {
    UrlVO findByLongURL(String longURL);
    UrlVO findByShortURL(String shortURL);
    int countByLongURL(String longURL);

}
