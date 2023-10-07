package org.example.seleniumTest;

import org.example.seleniumTest.Components.Base;
import org.example.seleniumTest.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class clientRegisterErrorPageFactory extends Base {


    @Test
    public void registerErrorValidation() throws IOException {

        String txtUserEmail = "diegogutierrez28@testing.com";
        String txtUserPassword = "Diego123!";

        RegisterPage register = login.goToRegister(); // vamos a la pagina de registro
        register.register(txtUserEmail, txtUserPassword); // registramos un usuario
        boolean msgValidate = login.validateMsgError("User already exisits with this Email Id!");
        Assert.assertTrue(msgValidate);
    }


}
