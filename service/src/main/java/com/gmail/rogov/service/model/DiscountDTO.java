package com.gmail.rogov.service.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DiscountDTO implements Serializable {


    private Long id;
    private String name;
    private Integer percent;
    private LocalDateTime termination;
    private Set<UserDTO> users = new HashSet<>();

    public void setTermination(LocalDateTime termination) {
        this.termination = termination;
    }

    public LocalDateTime getTermination() {
        return termination;
    }

    public void addUser(UserDTO user) {
        users.add(user);
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

    public Integer getPercent() {
        return percent;
    }

    public Set<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDTO> users) {
        this.users = users;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountDTO that = (DiscountDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(percent, that.percent) &&
                Objects.equals(termination, that.termination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, percent, termination);
    }
}
