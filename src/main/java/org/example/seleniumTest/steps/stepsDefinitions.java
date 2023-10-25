package org.example.seleniumTest.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.seleniumTest.Components.Base;
import org.example.seleniumTest.pages.*;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class stepsDefinitions extends Base {

    public LoginPage loginPage;
    public RegisterPage registerPage;
    public HomePage homePage;
    public MyCartPage myCartPage;
    public PaymentPage paymentPage;

    public IdsOrdersPage idsOrdersPage;
    public OrdersPage ordersPage;
    List<String> txtIds = null;

    @Given("I am on the Login page")
    public void i_am_on_the_Login_page() throws IOException {
        loginPage = launchApplication();
    }

    @When("go to the registration screen")
    public void go_to_the_registration_screen() {
        registerPage = loginPage.goToRegister();
    }

    @When("^enter the (.+) and the (.+) enter the other values and click button Register$")
    public void enter_the_username_and_the_password_enter_the_other_values_and_click_button_register(String username, String password) {
        registerPage.register(username, password);
    }

    @Then("go to the registration confirmation screen with the message {string}")
    public void go_to_the_registration_confirmation_screen_with_the_message_registration_successful(String string) {
        Assert.assertTrue(registerPage.validateRegister(string));
    }

    @When("^enter the (.+) and the (.+) and click button Login$")
    public void enter_the_username_and_the_password_and_click_button_login(String username, String password) {
        homePage = loginPage.login(username, password);
    }

    @Then("go to the login confirmation")
    public void go_to_the_login_confirmation() {
        homePage.validateLoginSuccessfully();
    }

    @When("go to the login screen")
    public void go_to_the_login_screen() {
        registerPage.goToLogin();
    }

    @When("^(.+) add to cart$")
    public void add_to_cart(String product) {
        homePage.selectOneProduct(product);
    }

    @When("^go to cart page$")
    public void go_to_cart_page() {
        myCartPage = homePage.goToCartPage();
    }

    @When("^validate (.+) in cart$")
    public void validate_product_in_cart(String product) {
        Assert.assertTrue(myCartPage.validateOneProduct(product));
    }

    @When("^go to Payment Method$")
    public void go_to_Payment_Method() {
        paymentPage = myCartPage.goToCheckout();
    }

    @When("^we enter the heats of payment with the (.+) and place order$")
    public void we_enter_the_heats_of_payment_with_the_country_and_place_order(String country) {
        paymentPage.informationPlaceOlder(country);
        idsOrdersPage = paymentPage.toGoPlaceOrders();
    }

    @When("^we copy the order id generated in the purchase$")
    public void we_copy_the_order_id_generated_in_the_purchase() {
        txtIds = idsOrdersPage.txtOrdersIds();
    }

    @When("^we go to the order page$")
    public void we_go_to_the_order_page() {
        ordersPage = idsOrdersPage.goToOrders();
    }

    @Then("^the product is registered by order id$")
    public void the_product_is_registered() {
        ordersPage.validateProductsById(txtIds);
    }

    @Then("^validate product by (.+)$")
    public void validate_product_by_name(String product) {
        List<String> txtProducts = Arrays.asList(product);
        ordersPage.validateProductsByName(txtProducts);
    }

    @When("close the browser")
    public void close_the_browser() {
        closeApplication();
    }

    @Then("go to confirmation message {string}")
    public void go_to_the_login_confirmation_message_msgError(String string) {
        loginPage.validateMsgError(string);
    }
}
