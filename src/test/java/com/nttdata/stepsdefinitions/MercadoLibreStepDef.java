package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MercadoLibreStep;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.StepDefinitionAnnotation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercadoLibreStepDef {

    private MercadoLibreStep mercadolibre;
    private WebDriver driver;
    private Scenario scenario;


    @Given("estoy en la página de MercadoLibre")
    public void estoyEnLaPáginaDeMercadoLibre() throws InterruptedException {
        mercadolibre = new MercadoLibreStep(driver);
        mercadolibre.navegarA("https://mercadolibre.com.pe/");
        screenShot();
        //Thread.sleep(2000);
    }

    @When("busco un producto {string}")
    public void buscoUnProducto(String arg0) throws InterruptedException {
        mercadolibre.buscarProducto(arg0);
        screenShot();
    }

    @Then("una lista de resultados")
    public void unaListaDeResultados() {

    }

    @And("valido el primer titulo del resultado sea {string}")
    public void validoElPrimerTituloDelResultadoSea(String arg0) {
        mercadolibre.validarPrimerResultado(arg0);
    }


    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


}
