package com.axis2.ws;

import java.util.HashMap;

public class OrdersImpl implements Orders{
    HashMap<String,OrderDesc> map = new HashMap<String,OrderDesc>();
    public static int orderNo = 0;
    String defaultString = "0000";

    public String placeOrder(String name,String item){
        OrdersImpl.orderNo = OrdersImpl.orderNo +1;
        String oderNumber = defaultString + OrdersImpl.orderNo;
        OrderDesc od = new OrderDesc(oderNumber,name,item);
        this.map.put(oderNumber,od);

        return oderNumber;
    }

    public String getOrderInfo(String orderNo){
        OrderDesc retObj = this.map.get(orderNo);
        String retVal = retObj.getName()+" "+retObj.getItem();
        return  retVal;
    }
}
