package com.example.stats.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByFlagged(boolean flagged);
    List<Review> findByProviderId(int providerId);
    @Query("SELECT AVG(r.rating) FROM Review r")
    double getAverageRating();
    @Query("SELECT COALESCE(AVG(r.rating), 0) FROM Review r WHERE r.hidden = false")
    double calculateAverageRating();
}
