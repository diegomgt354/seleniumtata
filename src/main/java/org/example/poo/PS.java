package org.example.poo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {

    @BeforeMethod
    public void antesDelMensaje(){
        System.out.println("BeforeMethod - Antes del mensaje");
    }

    @AfterMethod
    public void despuesDelMensaje(){
        System.out.println("AfterMethod - Despues del mensaje");
    }

    public void mensajes(){
        System.out.println("Hola mundo");
    }
}
