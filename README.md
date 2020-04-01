![GitHub](https://img.shields.io/github/license/Thomas-George-T/Kafka-Producer-Consumer-Group-Message-Passing?style=plastic)
![GitHub top language](https://img.shields.io/github/languages/top/Thomas-George-T/Kafka-Producer-Consumer-Group-Message-Passing?style=plastic)
![GitHub last commit](https://img.shields.io/github/last-commit/Thomas-George-T/Kafka-Producer-Consumer-Group-Message-Passing?style=plastic)

<p align="center">
  <br>
  <br>
  <a href="#">
    <img height=200 src="https://cdn.svgporn.com/logos/kafka.svg">
  </a>
  <br>
</p>
<br>

## Description
Java code for creating custom Producer and Consumer group demonstrating message passing in Kafka.

## Environment

* Java 1.8 JDK
* Zookeeper
* Kafka >= 2.0
* Linux

## Prerequisites 

Ensure that Zookeeper & Kafka servers are up and running(These should be on separate terminal windows).

Command to start Zookeeper

```
zookeeper-server-start.sh config/zookeeper.properties
```

Command to start Kafka server

```
kafka-server-start.sh config/server.properties
```

## Installation steps

After cloning this repo,

1. Run the maven `clean install` command

```
mvn clean install
```

Maven will now generate a `target` directory with the jar `kafka-1.0-shaded.jar`

2. Move into the `target` directory

```
cd target
```

## Execution steps

### To execute the Producer class

1. Run the kafka console consumer in another terminal window with the following `topic` and `group`

```
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic firstTopic --group my-third-application
```

2. Execute the ProducerDemo class from the jar

```
java -cp kafka-1.0-shaded.jar com.github.thomas.kafka.ProducerDemo
```

3. You should now be able to see the output in your kafka console consumer terminal.

## Source Code

[Producer](src/main/java/com/github/thomas/kafka/ProducerDemo.java)

[ConsumerGroup](old_src/kafkaConsumerGroup/SimpleConsumer.java)
*ConsumerGroup will be deprecated and eventually removed since it's using an older version of the kafka code*
