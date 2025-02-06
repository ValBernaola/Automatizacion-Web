package com.nttdata.steps;

import com.nttdata.page.ProductosPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductosSteps {

    private WebDriver driver;

    public ProductosSteps(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Realiza el clic en el primer producto para ver los detalles.
     */
    public void hacerClickPrimerProducto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement primerProducto = wait.until(ExpectedConditions.elementToBeClickable(ProductosPage.itemP));
        primerProducto.click();
    }

    /**
     * Ajusta la cantidad del producto según el valor proporcionado.
     *
     * @param cantidad La cantidad de productos que se desea agregar al carrito
     */
    public void ajustarCantidad(int cantidad) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cantidadInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductosPage.AgregarCarrito));

        while (Integer.parseInt(cantidadInput.getAttribute("value")) < cantidad) {
            WebElement botonAumentar = driver.findElement(ProductosPage.ButtonAum);
            botonAumentar.click();
            cantidadInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductosPage.AgregarCarrito));
        }

        while (Integer.parseInt(cantidadInput.getAttribute("value")) > cantidad) {
            WebElement botonDisminuir = driver.findElement(ProductosPage.ButtonDis);
            botonDisminuir.click();
            cantidadInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductosPage.AgregarCarrito));
        }
    }

    /**
     * Después de ajustar la cantidad, agrega el producto al carrito.
     */
    public void agregarProductoAlCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement botonAgregarCarrito = wait.until(ExpectedConditions.elementToBeClickable(ProductosPage.AgregarCarrito));
        botonAgregarCarrito.click();
    }

}
