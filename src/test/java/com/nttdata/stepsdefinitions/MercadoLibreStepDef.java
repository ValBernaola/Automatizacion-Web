package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MercadoLibreStep;
import io.cucumber.java.Before;
import io.cucumber.java.StepDefinitionAnnotation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercadoLibreStepDef {

   MercadoLibreStep mercadolibre;
   WebDriver driver;

    @Before(order = 0)
    public void setUp(){
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("estoy en la página de MercadoLibre")
    public void estoyEnLaPáginaDeMercadoLibre() throws InterruptedException {
        mercadolibre = new MercadoLibreStep(driver);
        mercadolibre.navegarA("https://mercadolibre.com.pe/");

        Thread.sleep(2000);
    }

    @When("busco un producto {string}")
    public void buscoUnProducto(String arg0) throws InterruptedException {
        mercadolibre.buscarProducto(arg0);
    }

    @Then("una lista de resultados")
    public void unaListaDeResultados() {
    }

    @And("valido el primer titulo del resultado")
    public void validoElPrimerTituloDelResultado() {
    }
}
