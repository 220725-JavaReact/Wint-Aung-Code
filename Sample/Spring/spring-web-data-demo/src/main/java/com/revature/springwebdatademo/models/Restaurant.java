package com.revature.springwebdatademo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

// by default without the name attibute ,hibernate infers that this table in the db is called restaurant
@Entity(name = "restaurants") // this class has a corresponding table in db called restaurants/

public class Restaurant {
    @Id // this field is equalvalent to the pk in db
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // telling orm that this field has a generated value,don't set
                                                        // the value

    private int id;
    // annotation not necessary, ORM will see this and assume a column caled name
    // exist in the table restaurants
    private String name;
    @Transient
    private double averageRating;// for the average rating we want to calculate this everytime we get a
                                 // restaurant from the dbwe're not saving average rating andTransient tells the
                                 // ORM that

    // fetch type eager means that everytime i get a restaurant , include the
    // related reviews

    // the mappedby property is what we used to tell Hibernate which variable/field
    // are using to represent the parent class in our child class
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parentRestaurant")
    private List<Review> reviews;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }
public Restaurant()
{}

    public Restaurant(String name) {
	super();
	this.name = name;
}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Restaurant [averageRating=" + averageRating + ", id=" + id + ", name=" + name + "]";
    }

}
