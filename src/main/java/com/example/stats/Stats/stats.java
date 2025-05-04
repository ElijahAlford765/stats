package com.example.stats.Stats;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "stats")
public class stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int providerId;
    private LocalDate date;
    private LocalTime LastUpdated;

    @Column(nullable = false)
    private int totalCustomers;
    private int totalUsers;
    private int totalServices;
    private int totalServiceProviders;
    public int totalReviews;

    private int activeUsers;
    private int ActiveServices;
    private int InactiveServices;

    private String mostPopularService;

    private int PendingProviderApplications;
    private int DeniedProviderApplications;
    private int ApprovedProviderApplications;

    private int HiddenReviews;

    @Column(nullable = false)
    private double avgRating;

    public stats() {
    }

    public stats(int providerId,int id, LocalDate date, LocalTime LastUpdated, int totalCustomers, int totalUsers, int totalServices, int totalServiceProviders, int totalReviews,
                 int activeUsers, int ActiveServices, int InactiveServices, String mostPopularService, int PendingProviderApplications, int DeniedProviderApplications, int ApprovedProviderApplications, int HiddenReviews, double avgRating) {

        this.date = date;
        this.id = id;
        this.LastUpdated = LastUpdated;
        this.totalCustomers = totalCustomers;
        this.totalUsers = totalUsers;
        this.totalServices = totalServices;
        this.totalServiceProviders = totalServiceProviders;
        this.totalReviews = totalReviews;
        this.activeUsers = activeUsers;
        this.ActiveServices = ActiveServices;
        this.InactiveServices = InactiveServices;
        this.mostPopularService = mostPopularService;
        this.PendingProviderApplications = PendingProviderApplications;
        this.DeniedProviderApplications = DeniedProviderApplications;
        this.ApprovedProviderApplications = ApprovedProviderApplications;
        this.HiddenReviews = HiddenReviews;
        this.avgRating = avgRating;
        this.providerId = providerId;
    }
    public int getProviderId(){
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(LocalTime lastUpdated) {
        LastUpdated = lastUpdated;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(int totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public int getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(int totalUsers) {
        this.totalUsers = totalUsers;
    }

    public int getTotalServices() {
        return totalServices;
    }

    public void setTotalServices(int totalServices) {
        this.totalServices = totalServices;
    }

    public int getTotalServiceProviders() {
        return totalServiceProviders;
    }

    public void setTotalServiceProviders(int totalServiceProviders) {
        this.totalServiceProviders = totalServiceProviders;
    }

    public int getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(int totalReviews) {
        this.totalReviews = totalReviews;
    }

    public int getActiveUsers() {
        return activeUsers;
    }

    public void setActiveUsers(int activeUsers) {
        this.activeUsers = activeUsers;
    }

    public int getActiveServices() {
        return ActiveServices;
    }

    public void setActiveServices(int activeServices) {
        ActiveServices = activeServices;
    }

    public int getInactiveServices() {
        return InactiveServices;
    }

    public void setInactiveServices(int inactiveServices) {
        InactiveServices = inactiveServices;
    }

    public String getMostPopularService() {
        return mostPopularService;
    }

    public void setMostPopularService(String mostPopularService) {
        this.mostPopularService = mostPopularService;
    }

    public int isPendingProviderApplications() {
        return PendingProviderApplications;
    }

    public void setPendingProviderApplications(int pendingProviderApplications) {
        PendingProviderApplications = pendingProviderApplications;
    }

    public int isDeniedProviderApplications() {
        return DeniedProviderApplications;
    }

    public void setDeniedProviderApplications(int deniedProviderApplications) {
        DeniedProviderApplications = deniedProviderApplications;
    }

    public int isApprovedProviderApplications() {
        return ApprovedProviderApplications;
    }

    public void setApprovedProviderApplications(int approvedProviderApplications) {
        ApprovedProviderApplications = approvedProviderApplications;
    }

    public int getHiddenReviews() {
        return HiddenReviews;
    }

    public void setHiddenReviews(int hiddenReviews) {
        HiddenReviews = hiddenReviews;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }


    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
                ", date=" + date +
                ", lastUpdated=" + LastUpdated +
                ", totalCustomers=" + totalCustomers +
                ", totalUsers=" + totalUsers +
                ", totalServices=" + totalServices +
                ", totalServiceProviders=" + totalServiceProviders +
                ", totalReviews=" + totalReviews +
                ", activeUsers=" + activeUsers +
                ", activeServices=" + ActiveServices +
                ", inactiveServices=" + InactiveServices +
                ", mostPopularService='" + mostPopularService + '\'' +
                ", pendingProviderApplications=" + PendingProviderApplications +
                ", deniedProviderApplications=" + DeniedProviderApplications +
                ", approvedProviderApplications=" + ApprovedProviderApplications +
                ", hiddenReviews=" + HiddenReviews +
                ", avgRating=" + avgRating +
                '}';
    }

}
