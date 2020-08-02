package getRequest;

import com.sun.codemodel.JAnnotatable;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class PostReq {

    @Test
    public void postReq(){
//        Map<String , Object> map = new HashMap<String, Object>();
//        map.put("Name", "Nitin");
//        map.put("Profession", "Teacher");
//
//        System.out.println(map);

        JSONObject obj = new JSONObject();
        obj.put("Name", "Nitin");
        obj.put("Job", "Teacher");
//        System.out.println(obj);
//        System.out.println(obj.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(obj.toJSONString()).
        when().
                post("https://reqres.in/api/users").
        then().
                statusCode(201);
    }

    @Test
    public void putRequest(){
        JSONObject request = new JSONObject();
        request.put("name", "Nitin");
        request.put("job", "QA");

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put("https://reqres.in/api/users/2").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void patchRequest(){
        JSONObject request = new JSONObject();
        request.put("name", "Nitin");

        given().
                body(request.toJSONString()).
                header("Content-Type", "application/jason").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
        when().
                patch("https://reqres.in/api/users/2").
        then().
                statusCode(200).
                log().all();

    }


}
