package com.example.cloudinary.repo;

import com.example.cloudinary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
