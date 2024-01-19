package DataDrivenSQA;

import io.restassured.RestAssured;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class data_driveeen {

    @Test(dataProvider = "test_data")
    public void data_driven(String email,String first_name, String last_name)
    {
        String response= RestAssured.get("https://reqres.in/api/users?page=2").andReturn().asString();
        Assert.assertTrue(response.contains(email));
        Assert.assertTrue(response.contains(first_name));
        Assert.assertTrue(response.contains(last_name));

    }

    @DataProvider
        public String[][]test_data() throws InvalidFormatException, IOException

    {

        read_data rd=new read_data();
        return rd.read_data();
    }

    }


