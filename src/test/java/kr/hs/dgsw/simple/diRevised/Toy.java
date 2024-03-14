package kr.hs.dgsw.simple.diRevised;

public class Toy implements Product {
    private int price;

    private String name;

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
