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

* Java JDK 8 (1.8)
* Zookeeper
* Kafka >= 2.0
* Linux

## Prerequisites 

Ensure that Zookeeper & Kafka servers are up and running *( Open in separate terminal windows if necessary )*.

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

1. Run the kafka console consumer in another terminal window with the following `topic` and `group` parameters

```
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic firstTopic --group my-third-application
```

2. Execute the ProducerDemo class from the shaded jar

```
java -cp kafka-1.0-shaded.jar com.github.thomas.kafka.ProducerDemo
```

3. You should now be able to see the output in your Kafka console consumer terminal.

### To execute the Consumer class

1. Execute the ConsumerDemo class from the shaded jar

```
java -cp kafka-1.0-shaded.jar com.github.thomas.kafka.ConsumerDemo
```

2. Run the kafka console producer in another terminal window with the `topic` parameter.

```
kafka-console-producer.sh --broker-list localhost:9092 --topic firstTopic
```

3. You should now be able to see the output in your Kafka consumer terminal. *( Step 1 )*

### To execute both the Producer and Consumer

1. Execute the ProducerDemo class from the shaded jar

```
java -cp kafka-1.0-shaded.jar com.github.thomas.kafka.ProducerDemo
```

2. Execute the ConsumerDemo class from the shaded jar

```
java -cp kafka-1.0-shaded.jar com.github.thomas.kafka.ConsumerDemo
```

3. You should now the see the output in your Consumer terminal.

## Source Code

[Producer](src/main/java/com/github/thomas/kafka/ProducerDemo.java)

[ConsumerGroup](src/main/java/com/github/thomas/kafka/ConsumerDemo.java)

## License

This repository is under Apache License 2.0 - see [License](LICENSE.md) for more details

## Acknowledgement

This was inspired by Stephane Maarek. Check out his [Apache Kafka Series course](https://www.udemy.com/course/apache-kafka/) 