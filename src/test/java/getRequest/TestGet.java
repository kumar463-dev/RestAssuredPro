package getRequest;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;


public class TestGet {

    @Test
    public void test(){
        given().
                get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02").
        then().
                statusCode(200).
                body("weather.id[0]",equalTo(300)).
//                body("data.first_name",hasItems("Michael", "Rachel"));
                body("weather.main",hasItem("Drizzle"));
    }
}
