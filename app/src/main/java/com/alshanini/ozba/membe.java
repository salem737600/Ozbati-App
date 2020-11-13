package com.alshanini.ozba;

import androidx.annotation.Keep;

@Keep
public class membe {

    public String phone;
    public String item;
    public int price;

    public membe() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}