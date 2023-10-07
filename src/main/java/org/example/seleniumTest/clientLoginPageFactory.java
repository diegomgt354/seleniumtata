package org.example.seleniumTest;

import org.example.seleniumTest.Components.Base;
import org.example.seleniumTest.pages.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class clientLoginPageFactory extends Base {


    public String txtUserEmail = "diegogutierrez38@testing.com";
    public String txtUserPassword = "Diego123!";
//    public String countryTxt = "India";
//    public List<String> products = Arrays.asList("ZARA COAT 3", "ADIDAS ORIGINAL","IPHONE 13 PRO");

    public List<String> productsOrders = new ArrayList<>();

    @Test(dataProvider = "getData")
    public void OrdersProductsTest(String txtUserEmail, String txtUserPassword, String countryTxt, List<String> products) {

        RegisterPage register = login.goToRegister(); // vamos a la pagina de registro
        register.register(txtUserEmail, txtUserPassword); // registramos un usuario
        register.goToLogin(); // retornar a la pantalla login

//        login
        HomePage dashboar = login.login(txtUserEmail, txtUserPassword); // login

        dashboar.selectProducts(products); // seleccionamos los productos

//        Navbar nav = new Navbar(driver);

        MyCartPage cart = nav.goToCartPage(); // go al carrito de compra

//        validamos que los productos esten en el carrito de compras
        boolean productsInCard = cart.validateProducts(products);
        Assert.assertTrue(productsInCard);

//        delete products aleatory and return new products
        productsOrders = cart.deleteProductRandom(products);
        PaymentPage payment = cart.goToCheckout(); // go a la pantalla de pago

//        continue with the purchase
        payment.informationPlaceOlder(countryTxt); // payment details
        // go a la pantalla de confirmacion de orden
        IdsOrdersPage idOrder = payment.toGoPlaceOrders();

//        obtener la lista de ids de compra
        List<String> txtOrdersIds = idOrder.txtOrdersIds();

//        go a la pantalla de ordenes de compra
        OrdersPage orders = nav.goToOrdersPage();

//       validamos que los id esten en la tabla de compras
        boolean productInTable = orders.validateProductsById(txtOrdersIds);
        Assert.assertTrue(productInTable);

        nav.goSignOut(); // Sign Out
    }

    @Test(dependsOnMethods = "OrdersProductsTest")
    public void validateProductsInOrdersTest(){
        login.login(txtUserEmail, txtUserPassword); // login
        OrdersPage orders = nav.goToOrdersPage();
        boolean productInTable = orders.validateProductsByName(productsOrders);
        Assert.assertTrue(productInTable);

    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
            {"diegogutierrez39@testing.com", "Diego123!", "India",
                Arrays.asList("ZARA COAT 3", "ADIDAS ORIGINAL","IPHONE 13 PRO")},
            {"diegogutierrez40@testing.com", "Diego123!", "Peru",
                    Arrays.asList("ZARA COAT 3", "IPHONE 13 PRO")}
        };
    }
}
