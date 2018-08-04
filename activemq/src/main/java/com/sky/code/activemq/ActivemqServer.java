package com.sky.code.activemq;

import org.apache.activemq.broker.BrokerService;

public class ActivemqServer {


    public static void main(String[] args)
    {
        BrokerService broker = new BrokerService();

        // configure the broker
        try {
            broker.addConnector("tcp://localhost:61616");
            broker.setPersistent(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            broker.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
