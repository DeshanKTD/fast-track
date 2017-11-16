package com.axis2.ws;

public interface Orders {
    /**
     *
     * @param name
     * @param item
     * @return orderNo
     */
    public String placeOrder(String name, String item);

    /**
     *
     * @param orderNo
     * @return string name and item
     */
    public String getOrderInfo(String orderNo);
}
