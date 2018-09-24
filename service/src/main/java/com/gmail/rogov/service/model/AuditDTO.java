package com.gmail.rogov.service.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class AuditDTO implements Serializable {

    private Long id;
    private String eventType;
    private LocalDateTime created;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditDTO auditDTO = (AuditDTO) o;
        return Objects.equals(id, auditDTO.id) &&
                Objects.equals(eventType, auditDTO.eventType) &&
                Objects.equals(created, auditDTO.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, created);
    }
}
