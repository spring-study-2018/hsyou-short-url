package com.example.url_shortener.repository;

import com.example.url_shortener.model.URLRequest;
import org.springframework.data.repository.CrudRepository;

public interface URLRepository extends CrudRepository<URLRequest, String> {
}