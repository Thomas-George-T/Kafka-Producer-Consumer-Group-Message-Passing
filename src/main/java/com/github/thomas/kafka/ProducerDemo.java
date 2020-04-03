package com.github.thomas.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(ProducerDemo.class);

        String bootStrapServers = "localhost:9092";
        String topic = "firstTopic";

        // Set Producer Properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create a producer
        KafkaProducer<String, String> producer =  new KafkaProducer<String, String>(properties);

            for (int i =0; i<10; i++) {
                String value = "Hello World " + i;
                // Creating a key to send offsets to particular Partitions
                String key = "id_" + i;

                // Create a producer record
                ProducerRecord<String, String> record =
                        new ProducerRecord<String, String>(topic,key, value);

                logger.info("key: " +key);

                // Send data - asynchronous
                producer.send(record, new Callback() {

                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        // executes on every successful record being sent or on an exception is thrown
                        if (e == null) {

                            logger.info("Received metadata");
                            logger.info("Offset: " + recordMetadata.offset() + "\n" +
                                    "Topic: " + recordMetadata.topic() + "\n" +
                                    "Partition: " + recordMetadata.partition() + "\n" +
                                    "Timestamp: " + recordMetadata.timestamp());
                        } else logger.error("Exception occurred: ", e);
                    }
                });
            }

            logger.info("Messages sent successfully!");
            // flush and close
            producer.close();
        }
    }
