package com.pankaj.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    private int bookId;
    private String bookName;
    private String writer;
    private int bookPrice;
    private String bookDesc;
    private String status;
}
