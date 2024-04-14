package com.invs.entities;

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
}
