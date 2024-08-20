

package com.example.BookStore.Controller;

import com.example.BookStore.Entity.BookDetails;

import com.example.BookStore.Service.BookDetailsService;
import com.example.BookStore.Service.BookDetailsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/BookDetails")
public class BookDetailsController {

    @Autowired
    private BookDetailsService bookDetailService;

    @GetMapping
    public ResponseEntity<List<BookDetails>> getBookDetails(){
        return ResponseEntity.ok(bookDetailService.getAll());
    }

    @GetMapping("Author{author}")
    public ResponseEntity<List<BookDetails>> findByAuthor(@RequestParam String author){
        if (author == null || author.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
        return ResponseEntity.ok(bookDetailService.findByAuthor(author));
    }

    @GetMapping("/Genre")
    public ResponseEntity<List<BookDetails>> getByGenre(@RequestParam String genre){
        if (genre == null || genre.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
        return ResponseEntity.ok(bookDetailService.findByGenre(genre));
    }

    @GetMapping("/Publisher")
    public ResponseEntity<List<BookDetails>> getByPublisher(@RequestParam String publisher){
        if (publisher == null || publisher.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
        return ResponseEntity.ok(bookDetailService.findByPublisher(publisher));
    }

    @GetMapping("/Price")
    public ResponseEntity<List<BookDetails>> getByPrice(){
        return ResponseEntity.ok(bookDetailService.getBooksSortedByPrice());
    }

    @PostMapping
    public ResponseEntity<BookDetails> createBook(@RequestBody BookDetails book){
        if (book == null || book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(bookDetailService.createNewBook(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDetails> updateBook(@PathVariable ObjectId id, @RequestBody BookDetails book){
        book.setId(id);
            return ResponseEntity.ok((bookDetailService.updateBook(book)));
        }
    @PostMapping("/{bookId}/addBookBuyDetails/{bookBuyDetailsId}")
    public ResponseEntity<BookDetails> addBookBuyDetails(
            @PathVariable("bookId") ObjectId bookId,
            @PathVariable("bookBuyDetailsId") ObjectId bookBuyDetailsId) {
        BookDetails updatedBookDetails = bookDetailService.addBookBuyDetails(bookId, bookBuyDetailsId);
        return ResponseEntity.ok(updatedBookDetails);
    }

    @DeleteMapping("/{bookId}/removeBookBuyDetails/{bookBuyDetailsId}")
    public ResponseEntity<BookDetails> removeBookBuyDetails(@PathVariable ObjectId bookId, @PathVariable ObjectId bookBuyDetailsId) {
        return ResponseEntity.ok(bookDetailService.removeBookBuyDetails(bookId, bookBuyDetailsId));
    }

}

