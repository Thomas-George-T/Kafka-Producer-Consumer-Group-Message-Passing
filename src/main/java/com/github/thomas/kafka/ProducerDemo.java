package com.github.thomas.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {

        String bootStrapServers = "localhost:9092";

        // Set Producer Properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create a producer
        KafkaProducer<String, String> producer =  new KafkaProducer<String, String>(properties);

        // Create a producer record
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("firstTopic","Hello World!");

        // Send data - asynchronous
        producer.send(record);
        System.out.println("Messages sent successfully!");
        // flush and close
        producer.close();
    }

}
