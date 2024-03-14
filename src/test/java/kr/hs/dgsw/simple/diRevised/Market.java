package kr.hs.dgsw.simple.diRevised;

public class Market {

    public static void main(String[] args) {

        Store store = new Store();

        store.carryIn(new Food());
        store.carryIn(new Toy());
        store.carryIn(new Food());

    }

}
