package com.jafar.bookmarkorganizer.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.Instant;
import java.util.List;

public class BookMark {

    @Id
    private String id;

    private String url;
    @Indexed
    private String title;
    @Indexed
    private String description;
    private List<String> tags;
    private Instant createdAt=Instant.now();

    public BookMark(){}

    public BookMark(String id, String url, String title, String description, List<String> tags, Instant createdAt) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
