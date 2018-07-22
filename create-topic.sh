sleep 5
kafka-topics.sh --create --zookeeper zk:2181 --replication-factor 1 --partitions 4 --topic kafka-topic