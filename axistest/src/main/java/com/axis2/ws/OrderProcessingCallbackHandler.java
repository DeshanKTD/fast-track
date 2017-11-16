/**
 * OrderProcessingCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.6  Built on : Jul 30, 2017 (09:08:31 BST)
 */
package com.axis2.ws;


/**
 *  OrderProcessingCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class OrderProcessingCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public OrderProcessingCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public OrderProcessingCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for placeOrder method
     * override this method for handling normal response from placeOrder operation
     */
    public void receiveResultplaceOrder(
        com.axis2.ws.OrderProcessingStub.PlaceOrderResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from placeOrder operation
     */
    public void receiveErrorplaceOrder(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for getOrderInfo method
     * override this method for handling normal response from getOrderInfo operation
     */
    public void receiveResultgetOrderInfo(
        com.axis2.ws.OrderProcessingStub.GetOrderInfoResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from getOrderInfo operation
     */
    public void receiveErrorgetOrderInfo(java.lang.Exception e) {
    }
}
