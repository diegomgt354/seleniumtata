package org.example.testngxml;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parametros {

    @Parameters({"nombre", "apellido"})
    @Test
    public void saludar(String name, String lastname){
        System.out.println("Hola, mi nombre es "+name+" "+lastname);
    }

}
