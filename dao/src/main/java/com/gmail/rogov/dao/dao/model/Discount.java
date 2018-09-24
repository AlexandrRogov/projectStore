package com.gmail.rogov.dao.dao.model;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "T_Discount")
public class Discount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_ID", updatable = false, nullable = false)
    private Long id;
    @NotNull
    @Column(name = "F_NAME",length = 100)
    private String name;
    @NotNull
    @Column(name = "F_PERCENT", unique = true)
    private Integer percent;
    @NotNull
    @Future
    @Column(name = "F_TERMINATION")
    private LocalDateTime termination;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "F_DISCOUNT_ID")
    private Set<User> users = new HashSet<>();

    @ManyToMany(mappedBy = "discounts", cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<>();

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

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public LocalDateTime getTermination() {
        return termination;
    }

    public void setTermination(LocalDateTime termination) {
        this.termination = termination;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return Objects.equals(id, discount.id) &&
                Objects.equals(name, discount.name) &&
                Objects.equals(percent, discount.percent) &&
                Objects.equals(termination, discount.termination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, percent, termination);
    }
}

