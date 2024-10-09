package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part{
String companyName;

    public OutsourcedPart() {}

    public OutsourcedPart(String name, double price, int inv, int minInv, int maxInv) {
        super(name, price, inv, minInv, maxInv);
    }

    public OutsourcedPart(long id, String name, double price, int inv, int minInv, int maxInv) {
        super(id, name, price, inv, minInv, maxInv);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
