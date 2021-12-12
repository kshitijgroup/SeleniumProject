package RestAssuredTesting;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_POST_DataDrivenTestAddNewEmp {
    
    @Test(dataProvider = "addEmpData")
    public void addNewEmployee(String ename, String eage, String esal) throws Exception{

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        RequestSpecification httpRequest = RestAssured.given();

        HashMap<Object, String> hm = new HashMap<Object, String>();
        hm.put("name", ename);
        hm.put("age", eage);
        hm.put("salary", esal);
        JSONObject requestParams = new JSONObject(hm);

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.POST, "/create");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        Thread.sleep(2000);
        Assert.assertEquals(responseBody.contains(ename), true);
        Assert.assertEquals(responseBody.contains(eage), true);
        Assert.assertEquals(responseBody.contains(esal), true);
        Assert.assertEquals(responseBody.contains("success"), true);
        Assert.assertEquals(responseBody.contains("Successfully! Record has been added."), true);

    }

    @DataProvider(name="addEmpData")
    String[][] getEmpData(){
        String empData[][] = {{"abckc","45","34000"},
                              {"xyzkc","89","7600"},
                              {"pqrkc","10","34990"}};
        return (empData);
    }

}
