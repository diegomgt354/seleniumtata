package org.example.testngxml;

import org.testng.annotations.*;

public class Alessio {

    @BeforeSuite
    public void antesdetodo(){
        System.out.println("BeforeSuite - Package");
    }

    @AfterSuite
    public void despuesdetodo(){
        System.out.println("AfterSuite - Package");
    }

    @BeforeTest
    public void primero(){
        System.out.println("BeforeTest - Package");
    }

    @AfterTest
    public void ultimo(){
        System.out.println("AfterTest - Package");
    }

    @BeforeMethod
    public void antesMetodo(){
        System.out.println("BeforeMethod - Package");
    }

    @AfterMethod
    public void despuesMetodo(){
        System.out.println("AfterMethod - Package");
    }

    @BeforeClass
    public void antesclase(){
        System.out.println("BeforeClass - Package");
    }

    @AfterClass
    public void despuesclase(){
        System.out.println("AfterClass - Package");
    }



    @BeforeGroups
    public void antesgrupo(){
        System.out.println("BeforeGroups - Package");
    }

    @AfterGroups
    public void despuesgrupo(){
        System.out.println("AfterGroups - Package");
    }

    @Test(groups = "Smoke")
    public void saludo(){ // ejecuta el test depende del nombre- cual va primero
        System.out.println("Test 1 - Package - groups");
    }
    @Test(dependsOnMethods = {"saludo3","saludo4"})
    public void saludo2(){
        System.out.println("Test 2 - Package");
    }

    @Test(dependsOnMethods = {"saludo5"})
    public void saludo3(){
        System.out.println("Test 3 - Package");
    }

    @Test
    public void saludo4(){
        System.out.println("Test 4 - Package");
    }

    @Test
    public void saludo5(){
        System.out.println("Test 5 - Package");
    }

    @Test(enabled = false) // para que no se ejecute
    public void noejecutable(){
        System.out.println("Este test esta deshabilitado");
    }


    @Test(timeOut = 5000) // tiempo de espera (en milisengundos) hasta que todito este ok
    public void tiempodeespera(){
        System.out.println("Se ejecuta despues de 5 segundos");
    }
}
