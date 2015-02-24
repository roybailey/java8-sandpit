package research.sparkjava;

import research.lambda.collection.Gender;
import research.lambda.collection.Person;

import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;


public class SparkJsonApp {

    public static void main(String[] args) {

        port(4545);
        staticFileLocation("/webapp");

        get("/hello", (request, response) -> {
            return "Hello World!";
        });

        get("/hello-json", "application/json", (request, response) -> {
            return new Person.Builder().givenName("Roy").gender(Gender.MALE).age(40).build();
        }, new JsonTransformer());
    }
}
