package org.example.seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class clientLogin {
    WebDriver driver;
    WebDriverWait wait;


    By userEmail = By.id("userEmail");
    By userPassword = By.id("userPassword");
    By bthLogin = By.id("login");
    By  btnRegister = By.linkText("Register here");
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By userMobile = By.id("userMobile");
    By selectOccupation = By.cssSelector("select.custom-select");
    By radioMale = By.xpath("//input[@type='radio'][@value='Male']");
    By confirmPassword = By.id("confirmPassword");
    By aboveYear = By.xpath("//input[@type='checkbox']");
    By returnLogin = By.xpath("//section[2]/div/div[2]/button");
    By btnCart = By.xpath("//button[contains(text(),'Cart')]");
    By btnCheckout = By.xpath("//li/button[text()='Checkout']");
    By crediCard = By.xpath("//div[contains(text(),'Card Number')]/../input");
    By expirateMonth = By.xpath("//div[contains(text(),'Expiry Date')]/../select[1]");
    By expirateDay = By.xpath("//div[contains(text(),'Expiry Date')]/../select[2]");
    By CVVCode = By.xpath("//div[contains(text(),'CVV Code')]/../input");
    By NameCard  = By.xpath("//div[contains(text(),'Name on Card')]/../input");
    By ApplyCoupon  = By.xpath("//div[contains(text(),'Apply Coupon')]/../input");
    By btnApplyCoupon = By.xpath("//button[text()='Apply Coupon']");
    By MsgCouponApplied = By.xpath("//p[text()='* Coupon Applied']");
    By direction = By.xpath("//label/../input[contains(@class,'input')]");
    By country = By.xpath("//input[@placeholder='Select Country']");
    By btnPlaceOlder = By.xpath("//a[contains(text(),'Place Order')]");
    By btnOrders = By.xpath("//button[contains(text(),'ORDERS')]");
    By idProduct = By.xpath("//td/label[@class='ng-star-inserted']");
    By idTable = By.cssSelector("table tbody");
    By toastContainer = By.cssSelector("#toast-container");
    By imgCarga = By.cssSelector(".ng-trigger");

    @BeforeMethod
    public void antes(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client/");
        driver.manage().window().maximize();
    }

    @Test
    public void testCompleto() {

        String txtUserEmail = "diegogutierrez7@testing.com";
        String txtUserPassword = "Diego123!";
        List<String> products = Arrays.asList("ZARA COAT 3", "ADIDAS ORIGINAL","IPHONE 13 PRO");

//        register
        clickElement(btnRegister);
        sendKey(firstName,"diego");
        sendKey(lastName,"gutierrez");
        sendKey(userEmail,txtUserEmail);
        sendKey(userMobile,"9876543210");
        selectText(selectOccupation,"Student");
        clickElement(radioMale);
        sendKey(userPassword,txtUserPassword);
        sendKey(confirmPassword,txtUserPassword);
        clickElement(aboveYear);
        clickElement(bthLogin);

//        return login
        clickElement(returnLogin);

//        login
        sendKey(userEmail,txtUserEmail);
        sendKey(userPassword,txtUserPassword);
        clickElement(bthLogin);

////        select products - opcion1
//        List<String> products = Arrays.asList("zara coat 3", "adidas original","iphone 13 pro");
//        for (String pro:products){
//            clickableElement(By.xpath("//*[@id='products']//h5/b[text()='"+pro+"']/../../button[2]")).click();
//            Thread.sleep(3000);
//        }

//        select products = opcion2
        visibilityElement(By.cssSelector(".mb-3"));
        List<WebElement> productsElement = driver.findElements(By.cssSelector(".mb-3"));
        for(String pro : products){
            WebElement product = productsElement.stream().filter(element->element.findElement(By.cssSelector("b")).getText().equals(pro)).findFirst().orElse(null);
            if(product!=null){
                product.findElement(By.cssSelector(".card-body button:last-of-type")).click(); // button:last-of-type selecciona el ultimo boton
                visibilityElement(toastContainer);
                if(invisibilityElement(imgCarga)) System.out.println("Producto '"+pro+"' seleccionado.");
            }

        }

//        cart
        clickElement(btnCart);

//        eliminar un producto aleatorio
        Random random = new Random();
        int indiceAleatorio = random.nextInt(products.size());
        visibilityElement(By.cssSelector(".cartWrap"));

////        opcion 1 - eliminar producto - si la pagina no cambiara
//        clickElement(By.xpath("/html/body//div[1]/h3[text()='"+products.get(indiceAleatorio)+"']/../..//button[@class='btn btn-danger']"));
//        Thread.sleep(3000);
//        System.out.println("Producto eliminado: "+products.get(indiceAleatorio));

//        opcion 2 - eliminar producto - si la pagina esta en constante cambio
        List<WebElement> cartProduct = driver.findElements(By.cssSelector(".cartWrap"));
        WebElement deleteProduct = cartProduct.stream().filter(element->element.findElement(By.cssSelector("h3")).getText().equals(products.get(indiceAleatorio))).findFirst().orElse(null);
        if(deleteProduct != null){
            deleteProduct.findElement(By.cssSelector("button.btn-danger")).click();
            wait.until(ExpectedConditions.invisibilityOf(deleteProduct));
            System.out.println("Producto eliminado: "+products.get(indiceAleatorio));
        }

//        continuar con la compra
        clickElement(btnCheckout);

//        informacion de pago
        sendKey(crediCard, "1234 5678 9012 3456");
        selectText(expirateMonth,"07");
        selectText(expirateDay,"19");
        sendKey(CVVCode, "123");
        sendKey(NameCard, "Diego Manuel");
        sendKey(ApplyCoupon, "rahulshettyacademy");
        clickElement(btnApplyCoupon);
        if(invisibilityElement(imgCarga)) System.out.println(visibilityElement(MsgCouponApplied).getText());
        sendKey(direction, "Mi casa al costado del poste");
        sendKey(country, "Peru");
        clickElement(By.xpath("//section/button/span[contains(text(),'Peru')]"));
        clickElement(btnPlaceOlder);

//        validate id products
        visibilityElement(idProduct);
        List<WebElement> idElements = driver.findElements(idProduct);
        List<String> txtIds = idElements.stream().map(id->id.getText().replace("|","").trim()).collect(Collectors.toList());

        //      products orders
        clickElement(btnOrders);

//        validate order id

        for(String id : txtIds){
            List<WebElement> txtIdsTable = visibilityElement(idTable).findElements(By.cssSelector("tr"));
            txtIdsTable.stream().filter(element -> element.findElement(By.cssSelector("th")).getText().equals(id)).findFirst()
                    .ifPresent(productId -> {
                        System.out.print("Producto '" + productId.findElement(By.cssSelector("tr td:nth-child(3)")).getText() + "' comprado - ");
                        System.out.println("Costo: '" + productId.findElement(By.cssSelector("tr td:nth-child(4)")).getText());
                        Assert.assertTrue(txtIds.contains(productId.findElement(By.cssSelector("th")).getText()));
                    });

        }

    }

    public WebElement visibilityElement(By byElement){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
    }

    public Boolean invisibilityElement(By byElement){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
    }

    public WebElement clickableElement(By byElement){
        return wait.until(ExpectedConditions.elementToBeClickable(byElement));
    }

    public void sendKey(By byElement, String text){
        visibilityElement(byElement).clear();
        visibilityElement(byElement).sendKeys(text);
    }

    public void clickElement(By byElement){
        clickableElement(byElement).click();
    }

    public void selectText(By byElement, String text){
        Select selection = new Select(visibilityElement(byElement));
        selection.selectByVisibleText(text);
    }

}
