package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("4") // Discriminator value for Handle
public class Handle extends Part {

    public Handle() {
        super();
    }

    public Handle(String name, double price, int inv) {
        super(name, price, inv);
    }

    // You can add any additional properties or methods specific to handles here

}
