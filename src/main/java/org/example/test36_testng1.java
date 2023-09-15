package org.example;

import org.testng.annotations.*;

public class test36_testng1 {

    @BeforeTest
    public void antes(){
        System.out.println("Antes");
    }

    @Test
    public void test() {
        System.out.println("Prueba 1");
    }

    @Test
    public void test2() {
        System.out.println("Prueba 2");
    }

    @Test
    public void prueba1() {
        System.out.println("Prueba 1 que no saldra");
    }

    @Test
    public void prueba2() {
        System.out.println("Prueba 2 que no saldra");
    }

    @Test
    public void prueba3() {
        System.out.println("Prueba 3 que no saldra");
    }

    @Test
    public void diego1() {
        System.out.println("Mensaje que si saldra 1");
    }

    @Test
    public void diego2() {
        System.out.println("Mensaje que si saldra 2");
    }

    @AfterTest
    public void despues(){
        System.out.println("Despues");
    }

}
