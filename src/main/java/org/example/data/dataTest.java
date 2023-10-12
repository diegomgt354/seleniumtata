package org.example.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class dataTest {

//    data test one
    @Test(dataProvider = "dataTest1")
    public void test1(String name, String lastname1, String lastname2){
        System.out.println(name+" "+lastname1+" "+lastname2);
    }

    @DataProvider
    public Object[][] dataTest1(){
        return new Object[][]{
                {"Diego", "Gutierrez", "Tafur"},
                {"Alessio", "Gutierrez", "Rojas"},
                {"Elizeth", "Rojas", "Delgado"}
        };
    }


//    data test two
    @Test(dataProvider = "dataTest2")
    public void test2(HashMap<String, String> data){
        System.out.println(data.get("name")+" "+data.get("lastname1")+" "+data.get("lastname2"));
    }

    @DataProvider
    public Object[][] dataTest2(){

        HashMap<String, String> data1 = new HashMap<>();
        data1.put("name", "Diego");
        data1.put("lastname1", "Gutierrez");
        data1.put("lastname2", "Tafur");

        HashMap<String, String> data2 = new HashMap<>();
        data2.put("name", "Alessio");
        data2.put("lastname1", "Gutierrez");
        data2.put("lastname2", "Rojas");

        HashMap<String, String> data3 = new HashMap<>();
        data3.put("name", "Elizeth");
        data3.put("lastname1", "Rojas");
        data3.put("lastname2", "Delgado");

        return new Object[][]{{data1}, {data2}, {data3}};
    }

//    data test three - json
    @Test(dataProvider = "dataTest3")
    public void test3(HashMap<String, String> data){
        System.out.println(data.get("name")+" "+data.get("lastname1")+" "+data.get("lastname2"));
    }

    @DataProvider
    public Object[][] dataTest3() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//main//java//org//example//data//dataJson.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }

    public List<HashMap<String,String>> getJsonDataToMap(String location) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(location), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
        return data;
    }
}
