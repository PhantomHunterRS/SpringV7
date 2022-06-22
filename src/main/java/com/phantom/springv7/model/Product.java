package com.phantom.springv7.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product {
    public Product(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private int cost;
}
