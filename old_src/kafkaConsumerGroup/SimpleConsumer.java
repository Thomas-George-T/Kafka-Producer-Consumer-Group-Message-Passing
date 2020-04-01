package kafkaConsumerGroup;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class SimpleConsumer {
public static void main(String[] args) {
	String topic="HelloKafka";
	String group="Group1";
	
	Properties prop =new Properties();
	prop.put("bootstrap.servers","localhost:9092");
	prop.put("group.id", group);
	prop.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	prop.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	
	KafkaConsumer<String,String> consumer= new KafkaConsumer<String,String>(prop);
	
	consumer.subscribe(Arrays.asList(topic));
	
	while(true){
		ConsumerRecords<String,String> records=consumer.poll(100);
		
		for(ConsumerRecord<String, String> rec:records){
			System.out.printf("offset= %d, key= %s, value= %s", rec.offset(),rec.key(),rec.value());
		}		
	}
}
}
