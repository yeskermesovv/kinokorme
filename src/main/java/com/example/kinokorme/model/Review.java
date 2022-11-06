package com.example.kinokorme.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "review")
@Getter
@Setter
public class Review {

    @Id
    private String id;

    private String content;

    public Review(String content) {
        this.content = content;
    }
}
