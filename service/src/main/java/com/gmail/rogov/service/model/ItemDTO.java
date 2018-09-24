package com.gmail.rogov.service.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


public class ItemDTO implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String uniqueNumber;
    private BigDecimal price;

    private List<DiscountDTO> discounts = new ArrayList<>();
    private List<OrderDTO> orders = new ArrayList<>();

    public List<DiscountDTO> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<DiscountDTO> discounts) {
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

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(id, itemDTO.id) &&
                Objects.equals(name, itemDTO.name) &&
                Objects.equals(description, itemDTO.description) &&
                Objects.equals(uniqueNumber, itemDTO.uniqueNumber) &&
                Objects.equals(price, itemDTO.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, uniqueNumber, price);
    }
}
