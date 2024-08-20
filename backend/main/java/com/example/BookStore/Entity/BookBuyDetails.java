package com.example.BookStore.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("BooksBuyDetails")
@Data
@NoArgsConstructor
public class BookBuyDetails {


    @Id
    private ObjectId id;
    @NonNull
    private String Description;
    @NonNull
    private String ISBN;
    private boolean Availability;
    private int RatingReview;

    public void setRatingReview(int RatingReview) {
        if (RatingReview > 10) {
            throw new IllegalArgumentException("RatingReview should not be above 10");
        }
        this.RatingReview = RatingReview;
    }
}
