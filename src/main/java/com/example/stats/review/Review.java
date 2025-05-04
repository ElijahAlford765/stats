package com.example.stats.review;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;
    private int customerId;
    private int providerId;
    private int serviceId;
    private int rating;
    private String description;
    private Date createdAt;
    private String reply; // Provider's response
    private boolean reported;
    // Flag for reported reviews
    @Column(nullable = false)
    private boolean flagged;
    private boolean hidden;

    public Review() {}

    public Review(boolean hidden,int customerId, int providerId, int serviceId, int rating, String description, Date createdAt, boolean flagged) {
        this.customerId = customerId;
        this.providerId = providerId;
        this.serviceId = serviceId;
        this.rating = rating;
        this.description = description;
        this.createdAt = createdAt;
        this.reply = "";
        this.reported = false;
        this.flagged = flagged;

        this.hidden = hidden;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", customerId=" + customerId +
                ", providerId=" + providerId +
                ", serviceId=" + serviceId +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", reply='" + reply + '\'' +
                ", reported=" + reported +
                '}';
    }
}
