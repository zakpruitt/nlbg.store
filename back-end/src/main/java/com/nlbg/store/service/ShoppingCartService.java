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

    public void addProduct(Item item) {
        if (products.containsKey(item)) {
            products.replace(item, products.get(item) + 1);
        } else {
            products.put(item, 1);
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

    public Integer getCartSize() {
        Integer count = 0;
        for (Map.Entry<Item, Integer> entry : products.entrySet()) {
            count += entry.getValue();
        }
        return count;
    }

    public Map<Item, Integer> getProducts() {
        return products;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (Map.Entry<Item, Integer> entry : products.entrySet()) {
            BigDecimal currentPrice = new BigDecimal(entry.getKey().getItemDesiredValue());
            currentPrice = currentPrice.multiply(BigDecimal.valueOf(entry.getValue()));
            total = total.add(currentPrice);
        }
        return total;
    }
}
