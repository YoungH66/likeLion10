package com.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
}

@Entity
@Getter
@Setter
@DiscriminatorValue("CAR")
class Car extends Vehicle {
    private int seatCount;
}

@Entity
@Getter
@Setter
@DiscriminatorValue("TRUCK")
class Truck extends Vehicle {
    private double payloadCapacity;
}
