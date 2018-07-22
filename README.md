# java-code
all kinds of java code in different topics or fields

## build on docker
````
sh run.sh mvn install
````

## kafka
run a kafka code, please install `docker` and `docker-compose`

````
sudo docker-compose run target
````

then, the docker will give a bash back.run below command to start a producer

````
mvn exec:java -Dexec.mainClass="com.sky.code.kafka.CustomPartitionProducer"
````

open another bash,and run

````
sudo docker-compose run target
````

in the returned bash, run below command to start a consumer.

````
mvn exec:java -Dexec.mainClass="com.sky.code.kafka.CustomPartitionConsumer"
````

you will see the both processes that produce a message and another will consume it.
