package com.steeplesoft.fwdemo.shared.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

public abstract class BaseModel {

    @Version
    @Column(name = "last_update")
    public LocalDateTime lastUpdate = LocalDateTime.now();

    @PreUpdate
    void updateTimestamp() {
        lastUpdate = LocalDateTime.now();
    }
}
