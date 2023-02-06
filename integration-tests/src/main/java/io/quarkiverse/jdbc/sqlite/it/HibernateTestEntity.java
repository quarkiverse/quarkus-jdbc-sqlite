package io.quarkiverse.jdbc.sqlite.it;

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
