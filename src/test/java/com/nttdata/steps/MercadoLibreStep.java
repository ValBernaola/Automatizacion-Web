package com.nttdata.steps;

import org.openqa.selenium.WebDriver;

public class MercadoLibreStep {
    WebDriver driver;

    public MercadoLibreStep(WebDriver driver){
        this.driver = driver;
    }

    public void navegarA(String url){
        driver.get(url);
    }

    public void buscarProducto(String producto){

    }
}
