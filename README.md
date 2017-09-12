# java-code
all kinds of java code in different topics or fields

## build
````
sh run.sh mvn install
````

## kafka
````
kafka-topics.sh --create --zookeeper zk1:2181 --replication-factor 1 --partitions 4 --topic kafka-topic
````
````
sh run.sh mvn exec:java -Dexec.mainClass="com.sky.code.kafka.CustomPartitionProducer"
sh run.sh mvn exec:java -Dexec.mainClass="com.sky.code.kafka.CustomPartitionConsumer"
````