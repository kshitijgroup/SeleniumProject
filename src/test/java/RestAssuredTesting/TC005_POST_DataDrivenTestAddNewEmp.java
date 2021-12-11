package RestAssuredTesting;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_POST_DataDrivenTestAddNewEmp {
    
    @Test
    public void addNewEmployee(){

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        RequestSpecification httpRequest = RestAssured.given();

        HashMap<Object, String> hm = new HashMap<Object, String>();
        hm.put("name", "streep");
        hm.put("age", "67");
        hm.put("salary", "665000");
        JSONObject requestParams = new JSONObject(hm);

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST, "/create");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        Assert.assertEquals(responseBody.contains("streep"), true);
        Assert.assertEquals(responseBody.contains("67"), true);
        Assert.assertEquals(responseBody.contains("665000"), true);
        Assert.assertEquals(responseBody.contains("success"), true);
        Assert.assertEquals(responseBody.contains("Successfully! Record has been added."), true);

    }
}
