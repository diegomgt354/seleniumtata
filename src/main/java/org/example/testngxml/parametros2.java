package org.example.testngxml;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parametros2 {

    @Parameters({"nombre", "apodo"})
    @Test
    public void saludar2(String name, String apodo){
        System.out.println("Hola, mi nombre es "+name+" y mi apodo es "+apodo);
    }

}
