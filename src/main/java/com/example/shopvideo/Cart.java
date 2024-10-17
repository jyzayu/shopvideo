package com.example.shopvideo;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Cart {
    HashMap<Product, Integer> items = new HashMap<Product, Integer>();

    public void showItems(){
        System.out.println("=== cart ===");
        for(Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue() + "개");
        }
    }

    public Map<String, Integer> showItemsStream(){
//        System.out.println("=== cart ===");
        return items.entrySet().stream()
                .collect(Collectors.toMap(e-> e.getKey().getName(), e-> e.getValue()));
    }

    public void addProduct(Product product, int amount){
        // 있으면 기존의 개수에서 더하고, 처음 나왔으면 추가한다.
//        if(items.containsKey(product)) {
//            items.put(product, items.get(product) + amount);
//        } else {
//            items.put(product, amount);
//        }
        items.merge(product, amount, Integer::sum);
    }

    public void removeProduct(Product product, int quantity) {
//        items.replace(product, items.get(product) - quantity);
//        if(items.get(product) <= 0) {
//            items.remove(product);
//        }

        if(!items.containsKey(product)) {
            items.put(product, quantity);
        } else {
            items.put(product, items.get(product) - quantity);
        }
    }
}
