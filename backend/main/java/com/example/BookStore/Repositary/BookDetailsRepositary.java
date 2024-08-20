package com.example.BookStore.Repositary;

import com.example.BookStore.Entity.BookDetails;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookDetailsRepositary extends MongoRepository<BookDetails, ObjectId> {

    public List<BookDetails> findByAuthor(String author);

    public List<BookDetails> findByGenre(String genre);

    public List<BookDetails> findByPublisher(String publisher);

   public  List<BookDetails> findAllByOrderByPriceAsc();
}


