package stepByStepRestAssured;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;




public class APITests {

    @Test

    void test1()
    {
        Response response= RestAssured.get("https://reqres.in/api/users?page=2");

        System.out.println("the Response is : "+response.asString());
        System.out.println("the status is : "+response.getStatusCode());
        System.out.println("the Body is  : "+response.getBody());
        System.out.println("the Taken Time : "+response.getTime());
        System.out.println("the Header : "+response.getHeader("Content-Type"));

        int StatusCode = response.statusCode();
        Assert.assertEquals(StatusCode,200);






    }













}
