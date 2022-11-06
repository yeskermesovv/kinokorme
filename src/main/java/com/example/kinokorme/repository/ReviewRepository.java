package com.example.kinokorme.repository;

import com.example.kinokorme.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {

}
