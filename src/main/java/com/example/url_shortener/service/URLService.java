package com.example.url_shortener.service;

import com.example.url_shortener.model.URLRequest;
import com.example.url_shortener.model.UrlVO;
import com.example.url_shortener.repository.H2Repository;
import com.example.url_shortener.repository.URLRedisRepository;
import com.example.url_shortener.util.Base62;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class URLService {

    @Autowired
    URLRedisRepository urlRedisRepository;
    @Autowired
    H2Repository r2Repository;

    private static final Logger logger = LoggerFactory.getLogger(URLService.class);


    public String postURL(URLRequest vo){

        String longURL = vo.getLongURL();

        if(r2Repository.countByLongURL(longURL) > 0) {

            logger.info("No Data in R2");
            return "";
        } else {
            vo.setShortUrl(Base62.toBase62(vo.getLongURL()));
            r2Repository.save(new UrlVO(longURL,vo.getShortUrl()));
            urlRedisRepository.save(vo);
            logger.info("Insert new Data in redis, R2");
        }

        return vo.getShortUrl();
    }

    public String getURL(String shortURL){
        Optional<URLRequest> o = urlRedisRepository.findById(shortURL);
        if(o.isPresent()) return o.get().getLongURL();
        else {
            UrlVO vo = r2Repository.findByShortURL(shortURL);
            if (vo == null) {
                return "";
            } else {
                return "no";
            }

            //rdb에서 조회
            //if rdb에 없을 경우 return "";
            //if 있을 경우
            //redis expiretime 부여 및 리턴
        }

    }


}
