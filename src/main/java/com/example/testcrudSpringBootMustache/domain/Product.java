package com.example.testcrudSpringBootMustache.domain;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    public Product() {
    }

    public Product(String name, String brand, int price, int quantity, User author) {

        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String brand;

    private int price;

    private int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public Long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
