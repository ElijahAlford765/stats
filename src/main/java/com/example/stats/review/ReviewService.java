package com.example.stats.review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(int id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByProviderId(int providerId) {
        return reviewRepository.findByProviderId(providerId);
    }

    public boolean deleteReviewById(int id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean replyToReview(int id, String reply) {
        Optional<Review> reviewOpt = reviewRepository.findById(id);
        if (reviewOpt.isPresent()) {
            Review review = reviewOpt.get();
            review.setReply(reply);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    public boolean reportReview(int id) {
        Optional<Review> reviewOpt = reviewRepository.findById(id);
        if (reviewOpt.isPresent()) {
            Review review = reviewOpt.get();
            review.setReported(true);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }



    public double getAverageRating() {
        return reviewRepository.calculateAverageRating(); // Implement this in the repository
    }
}
