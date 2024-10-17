package com.example.shopvideo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class Product {
    String key;
    String name;
    int price;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(key, product.key) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}