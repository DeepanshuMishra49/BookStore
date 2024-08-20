package com.example.BookStore.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "BooksDetails")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDetails {

    @Id
    private ObjectId id;
    private String author;
    private String title;
    @NonNull
    private int price;
    private String genre;
    private String publisher;

@DBRef
private List<BookBuyDetails> bookBuyDetails = new ArrayList<>();;


}

