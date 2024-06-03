package com.invs.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Builder(builderMethodName = "of")
@ToString(exclude = "reviews")
@EqualsAndHashCode(exclude = {"productNo", "reviews"})
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private int productNo;
    private String productName;
    private String manufacturer;
    private String category;
    private double price;
    private Set<Review> reviews;

}
