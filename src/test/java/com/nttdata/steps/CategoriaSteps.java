package com.nttdata.steps;

import com.nttdata.page.CategoriaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoriaSteps {

    private static WebDriver driver;
    private  WebDriverWait wait;


    // Constructor
    public CategoriaSteps(WebDriver driver) {
        CategoriaSteps.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));}

    /**
     * Navega a la categoría ubicada en el header, usando el texto visible en el elemento.
     * Utiliza la variable de XPath definida en CategoriaPage.
     */
    public static void navegarCategoria() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Esperar a que la categoría sea clickeable
        WebElement categoriaElement = wait.until(ExpectedConditions.elementToBeClickable(CategoriaPage.categoriaTittle));

        // Hacer clic en la categoría
        categoriaElement.click();
    }

    /**
     * Espera a que se despliegue el menú y luego selecciona la subcategoría dentro de él.
     * Utiliza la variable de XPath definida en CategoriaPage.
     */
    public static void seleccionarSubcategoriaDesdeMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Esperar a que la subcategoría sea clickeable
        WebElement subcategoriaElement = wait.until(ExpectedConditions.elementToBeClickable(CategoriaPage.subcategoriaTittle));

        // Hacer clic en la subcategoría
        subcategoriaElement.click();

        // Esperar a que la página de productos cargue (puedes cambiar el selector según el DOM de tu página)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content_wrapped")));
    }
}
