package org.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class test3 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void antes() {
		// String rutaWebDriver = System.getProperty("user.dir");
		// System.setProperty("webdriver.chrome.driver",
		// rutaWebDriver+"\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // espera
		// implicita que se establece de forma global
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // espera explicita el cual se aplica a un elemento en
																	// especifico
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
	}

	@Test
	@Ignore
	public void ingresoIncorrecto() {
		find(By.id("inputUsername")).sendKeys("diegomgt");
		find(By.name("inputPassword")).sendKeys("pass123");
		find(By.id("chkboxOne")).click();
		find(By.cssSelector("input#chkboxTwo")).click();
		find(By.xpath("//*[@id=\"container\"]/div[2]/form/button")).click();
		String textoError = find(By.className("error")).getText();
		Assert.assertEquals(textoError, "* Incorrect username or password"); // validamos que el texto sea el correcto

		// CssSelector:
		// TagName[atribute='value']
		// TagName[atribute='value']:nth-child(2)
		// TagName.className
		// TagName#id
		// en consola: $('TagName.className') para buscar

		// xpath
		// //TagName[@atribute='value']
		// //input[@type='text'][@placeholder='Name']
		// //input[@type='text'][@placeholder='Name'][2]
		// en consola: $x('//TagName[@atribute='value']') para buscar
	}

	@Test
	@Ignore
	public void olvidoContrasenia() {
		find(By.linkText("Forgot your password?")).click();
		find(By.xpath("//input[@placeholder='Name']")).sendKeys("diegomgt");
		find(By.xpath("//input[@placeholder='Email']")).sendKeys("diego@gmail.com.es");
		find(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("987654321");
		find(By.className("reset-pwd-btn")).click();

		String mensaje = find(By.className("infoMsg")).getText();
		Assert.assertTrue(mensaje.contains("Please use temporary password"));
	}

	@Test
	public void login() {
		String nameUser = "diegomgt";
		find(By.id("inputUsername")).sendKeys(nameUser);
		find(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		find(By.id("chkboxOne")).click();
		find(By.cssSelector("input#chkboxTwo")).click();
		find(By.xpath("//*[@id=\"container\"]/div[2]/form/button")).click();

		String mensajeHello = find(By.cssSelector("div[class='login-container'] h2")).getText();
		Assert.assertTrue(mensajeHello.contains(nameUser));

		find(By.cssSelector("div[class='login-container'] p"));
	}

	@AfterTest
	public void despues() {
		driver.quit();
	}

	private WebElement find(By identificador) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(identificador));
	}

}
