package com.axis2.ws;

public class OrderDesc {
    String orderNo;
    String name;
    String item;


    public OrderDesc(String orderNo, String name, String item){
        this.item = item;
        this.name = name;
        this.item = item;

    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
