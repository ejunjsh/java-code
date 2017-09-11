package com.sky.code.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CustomPartitionProducer {
    private static Producer<String, String> producer;
    public CustomPartitionProducer() {
        Properties props = new Properties();
        // Set the broker list for requesting metadata to find the lead broker
        props.put("bootstrap.servers",
                "kafka1:9092, kafka2:9092, kafka3:9092");

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        // 1 means the producer receives an acknowledgment once the lead replica
        // has received the data. This option provides better durability as the
        // client waits until the server acknowledges the request as successful.
        props.put("request.required.acks", "1");

        producer = new KafkaProducer<>(props);
    }
    public static void main(String[] args) {
        int argsCount = args.length;
        if (argsCount == 0 )
            throw new IllegalArgumentException(
                    "Please provide topic name and Message count as arguments");
        // Topic name and the message count to be published is passed from the
        // command line
        String topic = (String) args[0].split(",")[0];
        String count = (String) args[0].split(",")[1];
        int messageCount = Integer.parseInt(count);
        System.out.println("Topic Name - " + topic);
        System.out.println("Message Count - " + messageCount);
        CustomPartitionProducer simpleProducer = new CustomPartitionProducer();
        simpleProducer.publishMessage(topic, messageCount);
    }
    private void publishMessage(String topic, int messageCount) {
        Random random = new Random();
        for (int mCount = 0; mCount < messageCount; mCount++) {

            String clientIP = "192.168.14." + random.nextInt(255);
            String accessTime = new Date().toString();
            String message = accessTime + ",kafka.apache.org," + clientIP;
            System.out.println(message);


            ProducerRecord<String,String> data=new ProducerRecord<String, String>(topic,clientIP, message);


            // Publish the message
            Future<RecordMetadata> f= producer.send(data);
            try {
                System.out.println("publish to partition "+f.get().partition());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Close producer connection with broker.
        producer.close();
    }
}
