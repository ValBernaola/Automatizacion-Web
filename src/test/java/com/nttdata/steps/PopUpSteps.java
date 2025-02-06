package com.nttdata.steps;

import com.nttdata.page.PopUpPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpSteps {

    private WebDriver driver;

    // Constructor
    public PopUpSteps(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Valida que el popup de confirmación del producto agregado sea visible.
     */
    public void validarPopupConfirmacionProducto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(PopUpPage.PopUpP));
    }

    public void validarMontoTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Obtener el precio unitario desde el popup
        WebElement precioUnitarioElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PopUpPage.montounidad));
        double precioUnitario = Double.parseDouble(precioUnitarioElement.getText().replace("S/", "").trim().replace(",", "."));

        // Obtener la cantidad de productos desde el popup
        WebElement cantidadProductoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PopUpPage.cantidadP));
        int cantidadProducto = Integer.parseInt(cantidadProductoElement.getText());

        // Obtener el monto total desde el popup
        WebElement totalAmountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PopUpPage.montoTotal));
        String totalAmountText = totalAmountElement.getText().replace("$", "").trim();
        double montoObtenido = Double.parseDouble(totalAmountText.replace(",", "."));

        // Calcular el monto esperado
        double montoCalculado = precioUnitario * cantidadProducto;

        // Comparar el monto calculado con el obtenido
        double tolerance = 0.01;
        Assert.assertEquals(montoCalculado, montoObtenido);
    }


    public void finalizarCompra() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement finalizarCompra = wait.until(ExpectedConditions.elementToBeClickable(PopUpPage.finalizarC));
        finalizarCompra.click();
    }
}
