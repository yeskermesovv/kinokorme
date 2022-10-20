package com.example.kinokorme.repository;

import com.example.kinokorme.model.Trailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrailerRepository extends JpaRepository<Trailer, Long> {

    List<Trailer> getAllByTitle(String title);
 }
