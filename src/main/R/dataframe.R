library(SparkR)

# Initialize SparkContext and SQLContext
sc <- sparkR.init(appName="SparkR-Parquet-example")
sqlContext <- sparkRSQL.init(sc)

# Create a DataFrame from a Parquet file
path<-"hdfs://byd0085/apps/hive/warehouse/install_running/cor_partner=lotuseed/year=2015/month=1/day=9"
AppDF <- parquetFile(sqlContext, path)
printSchema(AppDF)

# Register this DataFrame as a table.
registerTempTable(AppDF, "appdf")

# SQL statements can be run by using the sql methods provided by sqlContext
appinfo <- sql(sqlContext, "SELECT app_id as App,count(*)as User FROM appdf GROUP BY app_id")


# save to parquet file 
write.df(appinfo, "/ysfseu/appinfo.parquet","parquet","overwrite")
# Stop the SparkContext now
sparkR.stop()
