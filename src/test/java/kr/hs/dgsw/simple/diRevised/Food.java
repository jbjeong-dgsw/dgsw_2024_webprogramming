package kr.hs.dgsw.simple.diRevised;

import java.util.Date;

public class Food implements Product {
    private int price;

    private Date expirationDate;

    @Override
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }



}
