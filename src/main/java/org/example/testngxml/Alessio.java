package org.example.testngxml;

import org.testng.annotations.*;

public class Alessio {

    @BeforeSuite
    public void antesdetodo(){
        System.out.println("Antes de todo");
    }

    @AfterSuite
    public void despuesdetodo(){
        System.out.println("Despues de todo");
    }

    @BeforeTest
    public void primero(){
        System.out.println("Primero");
    }
    @Test
    public void saludo(){
        System.out.println("Hola desde la casa");
    }

    @AfterTest
    public void ultimo(){
        System.out.println("Ultimo");
    }

}
