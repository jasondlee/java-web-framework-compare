package com.steeplesoft.jwfc.quarkus.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

public class BaseModel {

    @Version
    @Column(name = "last_update")
    public LocalDateTime lastUpdate = LocalDateTime.now();

    @PreUpdate
    void updateTimestamp() {
        lastUpdate = LocalDateTime.now();
    }
}
