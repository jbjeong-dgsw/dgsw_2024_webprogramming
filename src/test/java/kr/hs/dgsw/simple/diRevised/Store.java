package kr.hs.dgsw.simple.diRevised;

import kr.hs.dgsw.simple.di.Food;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Product> stand = new ArrayList<>();

    public void carryIn(Product product) {
        stand.add(product);
    }

    public Product sell() {
        if (!stand.isEmpty()) {
            return stand.removeFirst();
        } else {
            throw new RuntimeException("Sold out");
        }
    }

}
