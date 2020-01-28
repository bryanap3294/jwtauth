package com.bryan.promopack.jwtToken.service;

import com.bryan.promopack.jwtToken.model.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book findById(Integer id);

}
