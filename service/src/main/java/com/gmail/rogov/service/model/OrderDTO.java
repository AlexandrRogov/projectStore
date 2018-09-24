package com.gmail.rogov.service.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class OrderDTO implements Serializable {

    private Long id;
    private LocalDateTime created;
    private Integer quantity;
    private Long userId;
    private Long itemId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) &&
                Objects.equals(created, orderDTO.created) &&
                Objects.equals(quantity, orderDTO.quantity) &&
                Objects.equals(userId, orderDTO.userId) &&
                Objects.equals(itemId, orderDTO.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, quantity, userId, itemId);
    }
}
