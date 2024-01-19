package SQAJasonRestAssured;

import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class rest_testcases_Jason {

    @Test
    public void test_cases()
    {
        given().get("https://reqres.in/api/users?page=2").then()
                .assertThat().statusCode(200);

    }


    @Test
    public void test_cases2()
    {
        given().get("https://reqres.in/api/users?page=2").then()
                .assertThat().body("data[0].'email'",equalTo("michael.lawson@reqres.in")).and()
                .assertThat().body("data[0].'first_name'",equalTo("Michael"));

    }

    //Negative senarios:

    @Test
    public void test_cases3()
    {
        String response=RestAssured.get("https://reqres.in/api/users?page=1000000").andReturn().asString();
        Assert.assertTrue(response.contains(" contributions towards server costs are appreciated!"));

    }

    @Test
    void new_case(){
        Response response= RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.getStatusCode());
        System.out.println("the Response is : "+response.asString());
        System.out.println("the status is : "+response.getStatusCode());
        System.out.println("the Body is  : "+response.getBody());
        System.out.println("the Taken Time : "+response.getTime());
        System.out.println("the Header : "+response.getHeader("Content-Type"));

        int StatusCode = response.getStatusCode();
        Assert.assertEquals(StatusCode,200);




    }























}
