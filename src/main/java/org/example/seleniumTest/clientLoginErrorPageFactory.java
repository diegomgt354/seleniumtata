package org.example.seleniumTest;

import org.example.seleniumTest.Components.Base;
import org.example.seleniumTest.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class clientLoginErrorPageFactory extends Base {


    @Test(groups = "ErrorHandling")
    public void loginErrorValidation() throws IOException {

        String txtUserEmail = "correonoexistente@testing.com";
        String txtUserPassword = "passwordnoexistente";
        LoginPage login = new LoginPage(driver);
        login.login(txtUserEmail, txtUserPassword); // login
        boolean msgValidate = login.validateMsgError("Incorrect email or password.");
        Assert.assertTrue(msgValidate);
    }

}
