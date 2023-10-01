package org.example.seleniumTest;

import org.example.seleniumTest.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class clientLoginPageFactory {
    WebDriver driver;

    @BeforeMethod
    public void antes(){
        driver = new ChromeDriver();
    }

    @Test
    public void test() {

        String txtUserEmail = "diegogutierrez24@testing.com";
        String txtUserPassword = "Diego123!";
        String countryTxt = "India";
        List<String> products = Arrays.asList("ZARA COAT 3", "ADIDAS ORIGINAL","IPHONE 13 PRO");

//        iniciamos con login
        LoginPage login = new LoginPage(driver);
        login.toGo(); // vamos a la pagina

        RegisterPage register = login.goToRegister(); // vamos a la pagina de registro
        register.register(txtUserEmail, txtUserPassword); // registramos un usuario
        register.goToLogin(); // retornar a la pantalla login

//        login
        DashboardPage dashboar = login.login(txtUserEmail, txtUserPassword); // login

        dashboar.selectProducts(products); // seleccionamos los productos

        MyCartPage cart = dashboar.goToCartPage(); // go al carrito de compra

//        validamos que los productos esten en el carrito de compras
        boolean productsInCard = cart.validateProducts(products);
        Assert.assertTrue(productsInCard);

//        eliminar un producto aleatorio
        cart.deleteProductRandom(products);
        PaymentPage payment = cart.goToCheckout(); // go a la pantalla de pago

//        continuar con la compra
        payment.informationPlaceOlder(countryTxt); // datos de pago
        // go a la pantalla de confirmacion de orden
        IdsOrdersPage idOrder = payment.toGoPlaceOrders();

//        obtener la lista de ids de compra
        List<String> txtOrdersIds = idOrder.txtOrdersIds();
//        go a la pantalla de ordenes de compra
        OrdersPage orders = idOrder.goToOrders();

//       validamos que los id esten en la tabla de compras
        boolean productInTable = orders.validateProducts(txtOrdersIds);
        Assert.assertTrue(productInTable);

    }

    @AfterMethod
    public void despues(){
        driver.close();
    }

}
