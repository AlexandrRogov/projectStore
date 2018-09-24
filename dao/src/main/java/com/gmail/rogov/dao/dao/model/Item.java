package com.gmail.rogov.dao.dao.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


@Entity
@Table(name = "T_ITEM")
public class Item implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_ID", updatable = false, nullable = false)
    private Long id;
    @NotNull
    @Column(name = "F_NAME", length = 100)
    private String name;
    @NotNull
    @Column(name = "F_DESCRIPTION", length = 150)
    private String description;
    @NotNull
    @Column(name = "F_UNIQUE_NUMBER", unique = true, length = 70)
    private String uniqueNumber;
    @NotNull
    @Column(name = "F_PRICE")
    private BigDecimal price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "F_ITEM_ID")
    private List<Order> orders = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "T_ITEM_DISCOUNT",
            joinColumns = {@JoinColumn(name = "F_ITEM_ID")},
            inverseJoinColumns = {@JoinColumn(name = "F_DISCOUNT_ID")}
    )
    private List<Discount> discounts = new ArrayList<>();

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(description, item.description) &&
                Objects.equals(uniqueNumber, item.uniqueNumber) &&
                Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, uniqueNumber, price);
    }
}
