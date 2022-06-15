package io.quarkiverse.jdbc.sqlite.it.jpa;

import javax.persistence.MappedSuperclass;

/**
 * Mapped superclass test
 *
 * @author Emmanuel Bernard emmanuel@hibernate.org
 */
@SuppressWarnings("unused")
@MappedSuperclass
public class Human extends Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
