package com.example.BookStore.Repositary;

import com.example.BookStore.Entity.BookBuyDetails;
import com.example.BookStore.Entity.BookDetails;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookBuyDetailsRepositary extends MongoRepository<BookBuyDetails, ObjectId> {

    public List<BookBuyDetails> findByAvailability();

    public List<BookBuyDetails> findAllByRatingReview(int RatingReview);

}


