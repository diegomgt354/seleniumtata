package org.example;

import org.testng.annotations.*;

public class test36_testng1 {

    @BeforeTest
    public void antes(){
        System.out.println("BeforeTest - Class");
    }

    @Test(groups = "Smoke")
    public void test() {
        System.out.println("Test 1 - Class - groups");
    }

    @Test
    public void test2() {
        System.out.println("Test 2 - Class");
    }

    @Test
    public void prueba1() {
        System.out.println("Test 1 que no saldra - Class");
    }

    @Test
    public void prueba2() {
        System.out.println("Test 2 que no saldra - Class");
    }

    @Test
    public void prueba3() {
        System.out.println("Test 3 que no saldra - Class");
    }

    @Test
    public void diego1() {
        System.out.println("Mensaje Test que si saldra 1 - Class");
    }

    @Test
    public void diego2() {
        System.out.println("Mensaje Test que si saldra 2 - Class");
    }

    @AfterTest
    public void despues(){
        System.out.println("AfterTest - Class");
    }

}
