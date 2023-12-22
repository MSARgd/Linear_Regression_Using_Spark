package ma.enset;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
import org.apache.spark.sql.*;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.types.*;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org").setLevel(Level.ERROR);
        Logger.getLogger("akka").setLevel(Level.ERROR);

        SparkSession spark = SparkSession
                .builder()
                .appName("LinearRegressionModel Spark")
                .master("local[*]")
                .getOrCreate();
        Dataset<Row> dataset = spark.read().option("inferSchema",true).option("header",true).csv("advertising.csv");
        VectorAssembler vectorAssembler = new VectorAssembler().setInputCols(new String[]{"TV","Radio","Newspaper"}).setOutputCol("Feautres");
        Dataset<Row> assambledDS = vectorAssembler.transform(dataset);
        Dataset<Row> splits[] = assambledDS.randomSplit(new double[]{0.8, 0.2}, 123);
        Dataset<Row> train = splits[0];
        Dataset<Row> test = splits[1];

//        Model
        LinearRegression lR = new LinearRegression().setLabelCol("Sales").setFeaturesCol("Feautres");
        LinearRegressionModel model = lR.fit(train);
        Dataset<Row> predictions = model.transform(test);
        predictions.show();
        System.out.println("intercept : "+ model.intercept() + "coefficients : "+model.coefficients());
        System.out.println("Loss  : "+ model.loss());
        System.out.println("summary : \n"+model.summary());

    }
}