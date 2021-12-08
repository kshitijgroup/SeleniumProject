package RestAssuredTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
    
    @Test
    public void getWeatherDetails(){

        //Specify BaseURI
        RestAssured.baseURI = "https://api.github.com/users";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET, "/eugenp");
        
        //Print response in console output
        System.out.println(response.getBody().asString());

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " +statusCode);
        Assert.assertEquals(statusCode, 200, "Successfull GET status Request");

        //Status line validation
        String statusLine = response.getStatusLine();
        System.out.println("Status Line is: " +statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Successfull GET status line");
        
    }
}
