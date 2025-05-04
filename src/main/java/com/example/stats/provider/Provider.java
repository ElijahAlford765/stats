package com.example.stats.provider;
import jakarta.persistence.*;
@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int providerId;
    private int userId;
    private String about;
    private String experience;
    private String approvalStatus;

    public Provider() {
    }

    public Provider(int userId, String about, String experience, String approvalStatus) {
        this.userId = userId;
        this.about = about;
        this.experience = experience;
        this.approvalStatus = approvalStatus;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "providerId=" + providerId +
                ", userId=" + userId +
                ", about='" + about + '\'' +
                ", experience='" + experience + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                '}';
    }
}
