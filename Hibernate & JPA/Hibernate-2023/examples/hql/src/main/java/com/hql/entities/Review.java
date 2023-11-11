package com.hql.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@EqualsAndHashCode(exclude = {"reviewNo", "product"})
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_no")
    private int reviewNo;
    private int rating;
    private String remarks;
    @Column(name = "posted_dt")
    private LocalDate postedDate;
    @Column(name = "posted_by")
    private String postedBy;

    @ManyToOne
    @JoinColumn(name = "product_no", nullable = true)
    private Product product;

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewNo=" + reviewNo +
                ", rating=" + rating +
                ", remarks='" + remarks + '\'' +
                ", postedDate=" + postedDate +
                ", postedBy='" + postedBy + '\'' +
                ", product=" + product +
                '}';
    }
}
