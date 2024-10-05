package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3") // Discriminator value for Crystal
public class Crystal extends Part {

    public Crystal() {
        super();
    }

    public Crystal(String name, double price, int inv) {
        super(name, price, inv);
    }

    // You can add any additional properties or methods specific to crystals here

}
