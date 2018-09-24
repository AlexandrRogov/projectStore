package com.gmail.rogov.service.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;


public class UserDTO implements Serializable {

    private Long id;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime created;

    private Long roleId;
    private Set<CommentDTO> comments = new HashSet<>();
    private Set<NewsDTO> newsSet = new HashSet<>();
    private Set<AuditDTO> audits = new HashSet<>();
    private List<OrderDTO> orders = new ArrayList<>();
    private Long discountID;

    public void addNews(NewsDTO news) {
        newsSet.add(news);
    }

    public void addComment(CommentDTO comment) {
        comments.add(comment);
    }

    public void addAudit(AuditDTO audit) {
        audits.add(audit);
    }

    public void addOrder(OrderDTO order) {
        orders.add(order);
    }

    public Long getDiscountID() {
        return discountID;
    }

    public void setDiscountID(Long discountID) {
        this.discountID = discountID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


    public Set<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDTO> comments) {
        this.comments = comments;
    }

    public Set<NewsDTO> getNewsSet() {
        return newsSet;
    }

    public void setNewsSet(Set<NewsDTO> newsSet) {
        this.newsSet = newsSet;
    }

    public Set<AuditDTO> getAudit() {
        return audits;
    }

    public void setAudit(Set<AuditDTO> audits) {
        this.audits = audits;
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
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) &&
                Objects.equals(password, userDTO.password) &&
                Objects.equals(firstName, userDTO.firstName) &&
                Objects.equals(lastName, userDTO.lastName) &&
                Objects.equals(created, userDTO.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, firstName, lastName, created);
    }
}
