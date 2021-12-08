package RestAssuredTesting;

import java.util.HashMap;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
    
    @Test
    public void postRequest(){

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        HashMap<String, Object> hm = new HashMap<String, Object>();
        hm.put("title", "sample post test title");
        hm.put("body", "sample post test body");
        hm.put("userId", "2112");
        hm.put("id", "2121");
        //Request payload sending along with Post Request
        JSONObject requestParams=new JSONObject(hm);

        httpRequest.headers("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        //Response Object
        Response response = httpRequest.request(Method.POST,"/posts");

        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " +statusCode);
        Assert.assertEquals(statusCode, 201);

        System.out.println(response.getBody().asString());
        System.out.println("************************************");

        String userID = response.jsonPath().getString("userId");
        Assert.assertEquals(userID, "2112");

    }
}
