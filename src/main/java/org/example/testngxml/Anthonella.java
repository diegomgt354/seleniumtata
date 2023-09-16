package org.example.testngxml;

import org.testng.annotations.Test;

public class Anthonella {

    @Test(groups = "Smoke")
    private void saludar(){
        System.out.println("Te saludo desde otra clase - groups");
    }

}
