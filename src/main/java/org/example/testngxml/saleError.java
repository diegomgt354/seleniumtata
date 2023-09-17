package org.example.testngxml;

import org.testng.Assert;
import org.testng.annotations.Test;

public class saleError {
    @Test
    public void aproposito(){
        System.out.println("Error en la clase");
        Assert.assertTrue(false);
    }
}
