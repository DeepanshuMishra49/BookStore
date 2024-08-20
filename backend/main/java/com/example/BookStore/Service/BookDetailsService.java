package com.example.BookStore.Service;


import com.example.BookStore.Entity.BookBuyDetails;
import com.example.BookStore.Entity.BookDetails;
import com.example.BookStore.Repositary.BookBuyDetailsRepositary;
import com.example.BookStore.Repositary.BookDetailsRepositary;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookDetailsService {

    @Autowired
    private BookDetailsRepositary bookDetailsRepositary;

    @Autowired
    private BookBuyDetailsRepositary bookBuyDetailsRepositary;

    public BookDetails createNewBook(BookDetails Book){
        return bookDetailsRepositary.save(Book);
    }
    public List<BookDetails> getAll(){
        return bookDetailsRepositary.findAll();
    }
    public Optional<BookDetails> findById(ObjectId id) {
        return bookDetailsRepositary.findById(id);
    }

    public void deleteById(ObjectId id) {
        bookDetailsRepositary.deleteById(id);
    }

    public List<BookDetails> getBooksSortedByPrice() {
        return bookDetailsRepositary.findAllByOrderByPriceAsc();
    }

    public List<BookDetails>  findByAuthor(String Author){
        return bookDetailsRepositary. findByAuthor(Author);
    }

    public BookDetails updateBook(BookDetails Book){
        return bookDetailsRepositary.save(Book);
    }

    public List<BookDetails>  findByGenre(String genre){
        return bookDetailsRepositary. findByGenre(genre);
    }

    public List<BookDetails>  findByPublisher(String publisher){
        return bookDetailsRepositary. findByPublisher( publisher);
    }

    @Transactional
    public BookDetails addBookBuyDetails(ObjectId bookId, ObjectId bookBuyDetailsId) {
        Optional<BookDetails> bookDetailsOptional = bookDetailsRepositary.findById(bookId);
        Optional<BookBuyDetails> bookBuyDetailsOptional = bookBuyDetailsRepositary.findById(bookBuyDetailsId);

        if (bookDetailsOptional.isPresent() && bookBuyDetailsOptional.isPresent()) {
            BookDetails bookDetails = bookDetailsOptional.get();
            BookBuyDetails bookBuyDetails = bookBuyDetailsOptional.get();

            // Log before adding
            System.out.println("Before adding: " + bookDetails.getBookBuyDetails());
            bookDetails.getBookBuyDetails().add(bookBuyDetails);

            // Log after adding
            System.out.println("After adding: " + bookDetails.getBookBuyDetails());


            return bookDetailsRepositary.save(bookDetails);
        } else {
            return null;
        }
    }


    @Transactional
    public BookDetails removeBookBuyDetails(ObjectId bookId, ObjectId bookBuyDetailsId) {
        Optional<BookDetails> bookDetailsOptional = bookDetailsRepositary.findById(bookId);
        Optional<BookBuyDetails> bookBuyDetailsOptional = bookBuyDetailsRepositary.findById(bookBuyDetailsId);

        if (bookDetailsOptional.isPresent() && bookBuyDetailsOptional.isPresent()) {
            BookDetails bookDetails = bookDetailsOptional.get();
            BookBuyDetails bookBuyDetails = bookBuyDetailsOptional.get();

            bookDetails.getBookBuyDetails().remove(bookBuyDetails);

            return bookDetailsRepositary.save(bookDetails);
        } else {
            return null;
        }
    }

}

