package com.example.BookStore.Controller;

import com.example.BookStore.Entity.BookBuyDetails;
import com.example.BookStore.Service.BookBuyDetailsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookbuydetails")
public class BookBuyDetailsController {

    @Autowired
    private BookBuyDetailsService bookBuyDetailsService;

    @PostMapping
    public ResponseEntity<BookBuyDetails> createBookBuyDetails(@RequestBody BookBuyDetails bookBuyDetails) {
        System.out.println("Book Added Successfuly");
        return ResponseEntity.ok(bookBuyDetailsService.createBookBuyDetails(bookBuyDetails));
    }

    @GetMapping
    public ResponseEntity<List<BookBuyDetails>> getAll() {
        return ResponseEntity.ok(bookBuyDetailsService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookBuyDetails>> findById(@PathVariable ObjectId id) {
        return ResponseEntity.ok(bookBuyDetailsService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ObjectId id) {
        bookBuyDetailsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/availability")
    public ResponseEntity<List<BookBuyDetails>> findByAvailability() {
        return ResponseEntity.ok(bookBuyDetailsService.findByAvailability());
    }

    @GetMapping("/rating/{ratingReview}")
    public ResponseEntity<List<BookBuyDetails>> findByRating(@PathVariable int ratingReview) {
        return ResponseEntity.ok(bookBuyDetailsService.findByRating(ratingReview));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookBuyDetails> updateById(@PathVariable ObjectId id, @RequestBody BookBuyDetails bookBuyDetails) {
        bookBuyDetails.setId(id);
        return ResponseEntity.ok(bookBuyDetailsService.updateById(bookBuyDetails));
    }


}


