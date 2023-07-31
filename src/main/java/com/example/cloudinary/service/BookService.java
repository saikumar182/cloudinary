package com.example.cloudinary.service;
import com.example.cloudinary.entity.Book;
import com.example.cloudinary.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    Cloudinary cloudinary;

    public String addNewUser(MultipartFile file, String  authorname , String bookname) throws IOException {

        String imageUrl = null;
        if (file != null && !file.isEmpty()) {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            imageUrl = (String) uploadResult.get("secure_url");
        }

        Book book = new Book();
        book.setAuthorname(authorname);
        book.setBookname(bookname);
        book.setImage(imageUrl);
        bookRepo.save(book);
        return "book save successfully";
    }

    }

