package com.nttdata.steps;

import com.nttdata.page.MercadoLibrePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MercadoLibreStep {
    WebDriver driver;

    public MercadoLibreStep(WebDriver driver){
        this.driver = driver;
    }

    public void navegarA(String url){
        driver.get(url);
    }

    public void buscarProducto(String producto) throws InterruptedException {

        WebElement barraBusqueda = driver.findElement(MercadoLibrePage.barraBusqueda);
        barraBusqueda.sendKeys(producto);
        Thread.sleep(2000);

        WebElement botonBusqueda = driver.findElement(MercadoLibrePage.botonBusqueda);
        botonBusqueda.click();
        Thread.sleep(10000);
    }
}
