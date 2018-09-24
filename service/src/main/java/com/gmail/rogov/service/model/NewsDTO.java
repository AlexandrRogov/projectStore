package com.gmail.rogov.service.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class NewsDTO implements Serializable {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime created;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        NewsDTO newsDTO = (NewsDTO) o;
        return Objects.equals(id, newsDTO.id) &&
                Objects.equals(title, newsDTO.title) &&
                Objects.equals(content, newsDTO.content) &&
                Objects.equals(created, newsDTO.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, created);
    }
}
