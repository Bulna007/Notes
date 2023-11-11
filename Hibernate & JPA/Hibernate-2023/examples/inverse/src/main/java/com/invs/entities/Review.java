package com.invs.entities;

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
public class Review implements Serializable {
    private int reviewNo;
    private int rating;
    private String remarks;
    private LocalDate postedDate;
    private String postedBy;
    private Product product;
}
