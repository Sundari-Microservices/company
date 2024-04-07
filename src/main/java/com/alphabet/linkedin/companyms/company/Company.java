package com.alphabet.linkedin.companyms.company;


import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Company")
public class Company {

//    fields: {companyId, companyName, companyDescription, companyLocation, List<job> jobs}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String companyDescription;
    private String companyLocation;

    private long jobId;

    private long reviewId;
    private double companyRating;



    public Company(){

    }

//    public Company(Long id, String companyName, String companyDescription, String companyLocation, List<Job> jobs, List<Review> reviews) {
//        this.id = id;
//        this.companyName = companyName;
//        this.companyDescription = companyDescription;
//        this.companyLocation = companyLocation;
//        this.jobs = jobs;
//        this.reviews = reviews;
//    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public double getRating() {
        return companyRating;
    }

    public void setRating(double companyRating) {
        this.companyRating = companyRating;
    }


}
