package kr.hs.dgsw.simple.di;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Food> stand = new ArrayList<>();

    public void carryIn(Food food) {
        stand.add(food);
    }

    public Food sell() {
        if (!stand.isEmpty()) {
            return stand.removeFirst();
        } else {
            throw new RuntimeException("Sold out");
        }
    }

}
