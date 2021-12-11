package RestAssuredTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_PrintAllHeaders {
    
    @Test
    public void postRequest(){

        RestAssured.baseURI = "https://api.github.com/users";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET,"/eugenp");
        System.out.println(response.getBody().asString());

        System.out.println("****************************************");

        Headers headers = response.getHeaders();
        for(Header header : headers){
            System.out.println(header.getName() +" | "+header.getValue());
        }
    }
}

