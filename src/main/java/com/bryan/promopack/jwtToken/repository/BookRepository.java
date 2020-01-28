package com.bryan.promopack.jwtToken.repository;

import com.bryan.promopack.jwtToken.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
