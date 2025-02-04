package io.quarkiverse.sqlite4j.it;

import jakarta.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@SuppressWarnings("unused")
@Entity
public class HibernateTestEntity extends PanacheEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
