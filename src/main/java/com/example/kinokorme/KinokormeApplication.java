package com.example.kinokorme;

import com.example.kinokorme.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

@SpringBootApplication
public class KinokormeApplication implements CommandLineRunner {

	@Autowired
	private MongoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(KinokormeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		repository.save(new Review("it's just awesomeee"));

		List<Review> reviewList = repository.findAll();
		System.out.println(reviewList);
	}
}
