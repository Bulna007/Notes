package com.otmasoto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@EqualsAndHashCode(exclude = {"subscriptionNo", "setTopbox"})
@ToString
@Entity
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dth_subscription")
public class Subscription implements Serializable {
    @Id
    @Column(name = "subscription_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriptionNo;
    @Column(name = "subscriber_nm")
    private String subscriberName;
    private String provider;
    private String plan;
    @Column(name = "monthly_charges")
    private double monthlyCharges;
    @ManyToOne
    @JoinColumn(name = "serial_no", unique = true, nullable = true)
    private SetTopbox setTopbox;

}
