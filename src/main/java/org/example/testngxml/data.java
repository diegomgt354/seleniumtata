package org.example.testngxml;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class data {

    @Test(dataProvider = "mensajitos")
    public void imprimir(String usuario, String password){
        System.out.println("Usuario: "+usuario+" --> Password: "+password);
    }

    @DataProvider
    public Object[][] mensajitos(){
//        creamos un objeto
        Object[][] data = new Object[3][2];
        data[0][0] = "diego123";
        data[0][1] = "password1";

        data[1][0] = "elizeth123";
        data[1][1] = "password2";

        data[2][0] = "alessio123";
        data[2][1] = "password3";

        return data;
    }

}
