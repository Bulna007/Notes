package com.otml.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Restaurant implements Serializable {
    private int restaurantNo;
    private String restaurantName;
    private String cuisine;
    private int rating;
    private String contactNo;
    private List<Order> orders;

    public int getRestaurantNo() {
        return restaurantNo;
    }

    public void setRestaurantNo(int restaurantNo) {
        this.restaurantNo = restaurantNo;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant that)) return false;
        return getRestaurantName().equals(that.getRestaurantName()) && getCuisine().equals(that.getCuisine()) && getContactNo().equals(that.getContactNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRestaurantName(), getCuisine(), getContactNo());
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantNo=" + restaurantNo +
                ", restaurantName='" + restaurantName + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", rating=" + rating +
                ", contactNo='" + contactNo + '\'' +
                ", orders=" + orders +
                '}';
    }
}
