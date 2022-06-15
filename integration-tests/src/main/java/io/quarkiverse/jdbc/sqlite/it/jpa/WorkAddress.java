package io.quarkiverse.jdbc.sqlite.it.jpa;

import javax.persistence.Embeddable;

/**
 * Class marked @Embeddable explicitly so it is picked up.
 *
 * @author Emmanuel Bernard emmanuel@hibernate.org
 */
@SuppressWarnings("unused")
@Embeddable
public class WorkAddress {
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
