package com.ysfseu

import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object SparkParquetExample {
  def main(args: Array[String]) {
    val logFile = "hdfs://byd0085/apps/hive/warehouse/install_running/cor_partner=lotuseed/year=2015/month=1/day=9"
    val conf = new SparkConf().setAppName("SparkParquetExample")
    val sc = new SparkContext(conf)
    val sqlContext=new org.apache.spark.sql.SQLContext(sc)
    val parquetFile = sqlContext.parquetFile(logFile)
    parquetFile.registerAsTable("parquetFile")
    val userId = sqlContext.sql("SELECT usr_id FROM parquetFile")
    val userPair = userId.map(t => (t,1))
    val uniquePair = userPair.reduceByKey((x, y) => x + y)
    val count =uniquePair.count()
  }
}
