package kafkaConsumerGroup;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class SimpleProducer {

	public static void main(String[] args) {
		String topic="HelloKafka";
		Properties prop =new Properties();
		
		prop.put("bootstrap.servers", "localhost:9092");
		prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		KafkaProducer<String,String> producer = new KafkaProducer<String,String>(prop);
		
		for(int i=0;i<10;i++){
			ProducerRecord<String,String> rec = new ProducerRecord<String,String>(topic,Integer.toString(i),"Prod "+i);
			producer.send(rec);
		}
		System.out.println("Messages sent successfully");
		producer.close();
	}
}
