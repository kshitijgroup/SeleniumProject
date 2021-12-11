package RestAssuredTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_ExtractEachValue {
    
    @Test
    public void postRequest(){

        RestAssured.baseURI = "https://api.github.com/users";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET,"/eugenp");
        System.out.println(response.getBody().asString());

        System.out.println("****************************************");
        
        Assert.assertEquals(response.getBody().asString().contains("baeldung"), true);

        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.get("html_url"));
        System.out.println(jsonPath.get("organizations_url"));
        System.out.println(jsonPath.get("bio"));
        System.out.println(jsonPath.get("location"));
        
    }
}

