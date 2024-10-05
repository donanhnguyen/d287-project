package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Crystal;
import com.example.demo.domain.Handle;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.ProductServiceImpl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InventoryService {

    @Autowired
    public ProductServiceImpl productService;

    @Autowired
    public PartServiceImpl partService;

    public void addSampleInventory() {
        List<Product> products = productService.findAll();
        List<Part> parts = partService.findAll();

        if (products.isEmpty() && parts.isEmpty()) {
            System.out.println("EMPTY!!!!!");
            Part crystal1 = new Crystal("Kyber Crystal", 100.0, 10); // Assuming price = 100.0, inv = 10
            Part crystal2 = new Crystal("Synthetic Crystal", 120.0, 15); // Assuming price = 120.0, inv = 15
            Part handle1 = new Handle("Curved Handle", 150.0, 5); // Assuming price = 150.0, inv = 5
            Part handle2 = new Handle("Straight Handle", 140.0, 7); // Assuming price = 140.0, inv = 7
            Part handle3 = new Handle("Double-bladed Handle", 200.0, 3); // Assuming price = 200.0, inv = 3

            partService.save(crystal1);
            partService.save(crystal2);
            partService.save(handle1);
            partService.save(handle2);
            partService.save(handle3);

            // Check if duplicates exist and add a multipack part

            // Create and save products with the parts
            // Save the products to the repository
            productService.save(new Product(1L, "Lightsaber 1", 299.99, 10));
            productService.save(new Product(2L, "Lightsaber 2", 349.99, 8));
            productService.save(new Product(3L, "Lightsaber 3", 399.99, 5));
            productService.save(new Product(4L, "Lightsaber 4", 499.99, 3));
            productService.save(new Product(5L, "Lightsaber 5", 599.99, 2));
        }
    }
}
