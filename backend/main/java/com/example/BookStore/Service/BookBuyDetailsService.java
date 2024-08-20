package com.example.BookStore.Service;

import com.example.BookStore.Entity.BookBuyDetails;
import com.example.BookStore.Entity.BookDetails;
import com.example.BookStore.Repositary.BookBuyDetailsRepositary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookBuyDetailsService {

    @Autowired
    private BookBuyDetailsRepositary bookBuyDetailsRepositary;

    public BookBuyDetails createBookBuyDetails(BookBuyDetails Book){
        return bookBuyDetailsRepositary.save(Book);
    }

    public List<BookBuyDetails> getAll(){
        return bookBuyDetailsRepositary.findAll();
    }
    public Optional<BookBuyDetails> findById(ObjectId id) {
        return bookBuyDetailsRepositary.findById(id);
    }

    public void deleteById(ObjectId id) {
        bookBuyDetailsRepositary.deleteById(id);
    }
    public List<BookBuyDetails> findByAvailability(){
        return bookBuyDetailsRepositary.findByAvailability();
    }

    public List<BookBuyDetails> findByRating(int RatingReview){
        return bookBuyDetailsRepositary.findAllByRatingReview(RatingReview);
    }

    public BookBuyDetails updateById(BookBuyDetails book){
        return bookBuyDetailsRepositary.save(book);
    }
}




