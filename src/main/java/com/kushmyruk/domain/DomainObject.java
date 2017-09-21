package com.kushmyruk.domain;

public abstract class DomainObject {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
