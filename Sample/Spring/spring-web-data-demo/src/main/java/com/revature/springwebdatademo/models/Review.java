package com.revature.springwebdatademo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "someNameOtherThanRating")
    private double rating;
    // Fetch type lazy,you don't have to get the corresponding parent restaurant
    // every time you need to get an instance of this class from the DB

    @ManyToOne(fetch = FetchType.LAZY) // many reviews to one restaurant
    @JoinColumn(name = "restaurant_id") // foreign key column hold id of resturant this review is judging

    private Restaurant parentRestaurant;

    public Review() {

    }

    public Review(int id, double rating) {
        this.id = id;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + ", rating=" + rating + "]";
    }

}
