package com.example.springcloudkafka.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class KafkaDemo {
    public static void main(String[] args) throws Exception {
//        producer();
        consumer();
    }

    private static void producer() throws Exception {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        String topic = "my-topic";
        Integer partition = 0;
        Long timestamp = System.currentTimeMillis();
        String key = "key", value = "value";

        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        Future<RecordMetadata> future = producer.send(new ProducerRecord<String, String>("my-topic",
                partition, timestamp, key, value));

        future.get();
        producer.close();
    }

    private static void consumer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "my-group-1");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("my-topic"));
        ConsumerRecords<String, String> records = consumer.poll(100);
        for (ConsumerRecord<String, String> record : records)
            System.err.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
    }
}
