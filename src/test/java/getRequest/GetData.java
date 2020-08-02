package getRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetData {

    @Test
    public void testResponseCode(){
        Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");

        int code = response.getStatusCode();
        System.out.println("Status Code is: "+ code);

        Assert.assertEquals(code,400);
    }
    @Test
    public void testResponseBody(){
        Response response = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");

        String body = response.asString();
        System.out.println("Body is: "+ body);
        System.out.println("Response time is: "+ response.getTime());

    }


}
