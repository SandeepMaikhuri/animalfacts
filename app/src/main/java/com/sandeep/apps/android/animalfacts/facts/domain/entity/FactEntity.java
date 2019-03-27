package com.sandeep.apps.android.animalfacts.facts.domain.entity;

public class FactEntity {

    private String id;
    private String updatedAt;
    private String createdAt;
    private String user;
    private String text;
    private int v;
    private boolean deleted;
    private String type;
    private String source;
    private boolean used;

    public FactEntity(String id) {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return ("id" + id) + "updatedAt" + updatedAt + "createdAt" + createdAt + "user" + user + "text" + text + "v" + v + "deleted" + deleted + "type" + type + "source" + source + "used" + used;
    }
}
