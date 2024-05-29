package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
}

@Entity
@DiscriminatorValue("CAR")
@Getter
@Setter
class Car2 extends Vehicle2{
    private int seatCount;
}

@Entity
@DiscriminatorValue("TRUCK")
@Getter
@Setter
class Truck2 extends Vehicle2 {
    private double payloadCapactiy;
}