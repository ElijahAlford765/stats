package com.example.stats.petService;


import jakarta.persistence.*;

@Entity
public class PetService{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    private int providerId;
    private String title;
    private String description;
    private float price;
    private String availability;


    private Long id;
    private boolean approved;
    private String status;
    private boolean flagged;
    private int popularity;


    public PetService() {
    }

    public PetService(String title, int popularity, int providerId, int serviceId, String description, float price, String availability, boolean approved, String status, Boolean flagged, Long id) {
        this.serviceId = serviceId;
        this.providerId = providerId;
        this.description = description;
        this.price = price;
        this.availability = availability;
        this.popularity = popularity;
        this.title = title;
        this.id = id;

        this.flagged = flagged;
        this.status = status;
        this.approved = approved;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getApproved() {
        return approved;

    }
    public void setApproved(boolean approved){
        this.approved = approved;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }


    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getPopularity() {
        return popularity;
    }
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "PetService{" +
                "serviceId=" + serviceId +
                ", providerId=" + providerId +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                '}';
    }

}
