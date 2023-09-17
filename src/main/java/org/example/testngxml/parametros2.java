package org.example.testngxml;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parametros2 {

    @Parameters({"nombre", "apodo", "APIKey/password"})
    @Test
    public void saludar2(String name, String apodo, String key){
        System.out.println("Hola, mi nombre es "+name+" y mi apodo es "+apodo);
        System.out.println("Password: " + key);
    }

}
