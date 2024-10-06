package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Crystal;
import com.example.demo.domain.Handle;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
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
        System.out.println("Products: " + products);
        System.out.println("Parts: " + parts);
        System.out.println("Number of products: " + products.size());
        System.out.println("Number of parts: " + parts.size());
        for (Part part : parts) {
            System.out.println("Part Name: " + part.getName() + ", Price: " + part.getPrice() + ", Inventory: " + part.getInv());
        }
        if (products.isEmpty() && parts.isEmpty()) {
            System.out.println("Adding sample inventory...");

            Set<Part> partsSet = new HashSet<>();

            // Sample parts
            Part crystal1 = new Crystal("Kyber Crystal", 100.0, 10);
            Part crystal2 = new Crystal("Synthetic Crystal", 120.0, 15);
            Part handle1 = new Handle("Curved Handle", 150.0, 5);
            Part handle2 = new Handle("Straight Handle", 140.0, 7);
            Part handle3 = new Handle("Double-bladed Handle", 200.0, 3);

            // Add sample parts, checking for duplicates
            addPartWithCheck(partsSet, crystal1);
            addPartWithCheck(partsSet, crystal2);
            addPartWithCheck(partsSet, handle1);
            addPartWithCheck(partsSet, handle2);
            addPartWithCheck(partsSet, handle3);

            Set<Product> productsSet= new HashSet<>();

            //  Same products
            Product product1 = new Product(1L, "Lightsaber 1", 299.99, 10);
            Product product2 = new Product(2L, "Lightsaber 2", 349.99, 8);
            Product product3 = new Product(3L, "Lightsaber 3", 399.99, 5);
            Product product4 = new Product(4L, "Lightsaber 4", 499.99, 3);
            Product product5 = new Product(5L, "Lightsaber 5", 599.99, 2);

            // Add sample products, checking for duplicates
            addProductWithCheck(productsSet, product1);
            addProductWithCheck(productsSet, product2);
            addProductWithCheck(productsSet, product3);
            addProductWithCheck(productsSet, product4);
            addProductWithCheck(productsSet, product5);

            System.out.println("Sample inventory added.");
        } else {
            System.out.println("Inventory already exists, no sample data added.");
        }
    }

    private void addPartWithCheck(Set<Part> partsSet, Part part) {
        // Check if the part already exists in the set
        if (!partsSet.add(part)) {
            // If part exists, create a multipack version
            String multiPackName = part.getName() + " Multi-Pack";
            Part multiPackPart = new Crystal(multiPackName, part.getPrice() * 2, part.getInv() * 2); // adjust the type based on part type
            System.out.println("Duplicate part found: " + part.getName() + ", adding a multi-pack version: " + multiPackName);
            partService.save(multiPackPart);
        } else {
            // If part does not exist, save it
            partService.save(part);
        }
    }

    private void addProductWithCheck(Set<Product> productsSet, Product product) {
        // Check if the product already exists in the set
        if (!productsSet.add(product)) {
            // If product exists, create a multipack version
            String multiPackName = product.getName() + " Multi-Pack";
            Product multiPackPart = new Product(multiPackName, product.getPrice() * 2, product.getInv() * 2); // adjust the type based on part type
            System.out.println("Duplicate product found: " + product.getName() + ", adding a multi-pack version: " + multiPackName);
            productService.save(multiPackPart);
        } else {
            // If product does not exist, save it
            productService.save(product);
        }
    }
}
