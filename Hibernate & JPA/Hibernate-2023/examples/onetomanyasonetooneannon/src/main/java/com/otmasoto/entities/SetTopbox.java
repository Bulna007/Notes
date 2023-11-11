package com.otmasoto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode(exclude = {"subscriptions", "serialNo", "price"})
@ToString(exclude = {"subscriptions"})
@Entity
@Builder(builderMethodName = "of")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "settopbox")
public class SetTopbox implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_no")
    private int serialNo;
    private String manufacturer;
    @Column(name = "box_type")
    private String boxType;
    private double price;
    @OneToMany
    @JoinColumn(name = "serial_no", unique = true, nullable = true)
    private Set<Subscription> subscriptions;
}
