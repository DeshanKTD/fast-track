package com.axis2.ws;

import org.apache.axis2.AxisFault;

import java.rmi.RemoteException;

public class TestClient {
    public static void main(String [] args){

        try {
            OrderProcessingStub stub = new OrderProcessingStub();
            com.axis2.ws.OrderProcessingStub.PlaceOrder pOrder =
                    new com.axis2.ws.OrderProcessingStub.PlaceOrder();

            pOrder.setItem("bun");
            pOrder.setName("Romal");

            com.axis2.ws.OrderProcessingStub.PlaceOrderResponse pResponse =
                    stub.placeOrder(pOrder);

            String orderNo = pResponse.get_return();

            com.axis2.ws.OrderProcessingStub.GetOrderInfo gInfo =
                    new com.axis2.ws.OrderProcessingStub.GetOrderInfo();

            gInfo.setOrderNo(orderNo);

            System.out.println(orderNo);



        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}
