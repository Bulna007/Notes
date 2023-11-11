package com.invs.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Builder(builderMethodName = "of")
@ToString(exclude = "reviews")
@EqualsAndHashCode(exclude = {"productNo", "reviews"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_no")
    private int productNo;
    @Column(name = "product_nm")
    private String productName;
    private String manufacturer;
    @Column(name="category_nm")
    private String category;
    private double price;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
    //@JoinColumn(name = "product_no", nullable = true)
    private Set<Review> reviews;

}
