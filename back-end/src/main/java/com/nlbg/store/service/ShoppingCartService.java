package com.nlbg.store.service;

import com.nlbg.store.domain.Item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ShoppingCartService {

    @Autowired
    private ItemService itemService;
    private Map<Item, Integer> products = new HashMap<>();

    public void addProduct(Item item, Integer quantity) {
        if (products.containsKey(item)) {
            products.replace(item, products.get(item) + quantity);
        } else {
            products.put(item, quantity);
        }
    }

    public void removeProduct(Item item) {
        if (products.containsKey(item)) {
            if (products.get(item) > 1)
                products.replace(item, products.get(item) - 1);
            else if (products.get(item).equals(1)) {
                products.remove(item);
            }
        }
    }

    public Map<Item, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }

//    public BigDecimal getTotal() {
//        return products.entrySet().stream()
//                .map(entry -> entry.getKey().getItemDesiredValue().multiply(BigDecimal.valueOf(entry.getValue())))
//                .reduce(BigDecimal::add)
//                .orElse(BigDecimal.ZERO);
//    }
}
