# SparkParquetExample
Using Scala and SparkR to read Parquet File and Running on cluster

For scala:

This is a demo project for reading parquet file in cluster and processing it.This project is written in Scala. And we use maven to manage the dependencies.

Spark version 1.0.0
Scala version 2.10.4

Build:
    come into the direcotory containing pom.xml
    mvn install 
    Notes: it takes a long time if you build it for the first time
Run on cluster:
    yarn-cluster mode:
        spark-submit --class com.ysfseu.SparkParquetExample --master yarn-cluster  ~/target/spark-parquet-example-0.1.0-SNAPSHOT.jar 1000
    Yarn mode:
        Firstly, create environment variabe for HADOOP_CONF_DIR by using the following command:
        export HADOOP_CONF_DIR=/etc/hadoop/conf.cloudera.yarn
        export YARN_CONF_DIR=/etc/hadoop/conf.cloudera.yarn
        Finally,run
        spark-submit --class com.ysfseu.SparkParquetExample --master yarn-client  ~/target/spark-parquet-example-0.1.0-SNAPSHOT.jar 1000
NOtes: I put this project in ~/. Please change the directory to yours.


For R

export HADOOP_CONF_DIR=/etc/hadoop/conf.cloudera.yarn
export YARN_CONF_DIR=/etc/hadoop/conf.cloudera.yarn
./spark-submit --master yarn ~/R/dataframe.R 1000

