package org.example.springdatajpa2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name = "jpa_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "product")
    private String product;
    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Order(String product, LocalDate date, Customer customer) {
        this.product = product;
        this.date = date;
        this.customer = customer;
    }
}
