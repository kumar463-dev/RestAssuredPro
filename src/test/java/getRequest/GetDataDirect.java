package getRequest;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

public class GetDataDirect {

    @Test
    public void testResponseCode(){
        int code = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02").getStatusCode();
        System.out.println("Status Code is: "+ code);

        Assert.assertEquals(code,200);
    }
    @Test
    public void testResponseBody(){

        String body = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02").asString();
        long time = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02 ").getTime();
        System.out.println("Response time is: "+time);

    }

    @Test
    public void testExtra(){
        given()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .statusCode(200)
                .body("data.id[0]",equalTo(7));
    }

}
