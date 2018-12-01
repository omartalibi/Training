package integration;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;

import javax.xml.crypto.Data;

import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.lit;

public class test {
    public static void main(String[] args) {

        SparkConf conf = new SparkConf().setMaster("local[1]").setAppName("exemple");

        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);

        DataFrame data = sqlContext.read().format("csv")
                .option("header", "true")
                .option("inferSchema", "true")
                .load("/home/omar/Bureau/bigdata/input/input.csv");

        sqlContext.udf().register("CalculatePlusValue", (Double var1, Double var2) -> calculatePlusValue(var1,var2), DataTypes.DoubleType);

        DataFrame CalculatePlusValue_column=data.select(callUDF("CalculatePlusValue", col("High"), col("Low")));

        DataFrame df_final = data.join(CalculatePlusValue_column);


        //df_final.write().format("csv").save("/home/omar/Bureau/bigdata/output/out");
    }

    static Double calculatePlusValue (Double var1, Double var2){
        return var1 - var2;
    }
}
