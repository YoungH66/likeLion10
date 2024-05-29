package com.example.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passports")
@Getter
@Setter
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "passport_number")
    private String passportNumber;

    @OneToOne
    @JoinColumn(unique = true, name = "person_id")
    private Person person;

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
