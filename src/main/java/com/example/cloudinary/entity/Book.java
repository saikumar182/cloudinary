package com.example.cloudinary.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "authorname")
    private String authorname ;

    @Column(name = "bookname")
    private String bookname;

    @Column(name = "image")
    private String image;
}
