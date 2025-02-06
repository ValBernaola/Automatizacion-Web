package com.nttdata.stepsdefinitions;
;
import com.nttdata.steps.CategoriaSteps;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.PopUpSteps;
import com.nttdata.steps.ProductosSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;

public class LoginStepsDef {

    private WebDriver driver;
    private LoginSteps loginSteps;

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/");
        loginSteps = new LoginSteps(driver);
        loginSteps.clickIniciarSesion();


    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
       loginSteps.typeUser(user);
       loginSteps.typePassword(password);
       loginSteps.clickLoginButton();


    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoACategoriaYSubcategoria(String categoria, String subcategoria) {
        CategoriaSteps.navegarCategoria();

        CategoriaSteps.seleccionarSubcategoriaDesdeMenu();
    }


    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        ProductosSteps productosSteps = new ProductosSteps(driver);

        productosSteps.hacerClickPrimerProducto();

        productosSteps.ajustarCantidad(cantidad);

        productosSteps.agregarProductoAlCarrito();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        PopUpSteps popUpSteps = new PopUpSteps(driver);
        popUpSteps.validarPopupConfirmacionProducto();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        PopUpSteps popUpSteps = new PopUpSteps(driver);
        popUpSteps.validarMontoTotal();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        PopUpSteps popUpSteps = new PopUpSteps(driver);
        popUpSteps.finalizarCompra();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        // Validación del título de la página del carrito
        String titulo = driver.getTitle();
        assert titulo.equals("Carrito - Tienda");
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement precioFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".total-price")));

        String precioText = precioFinal.getText();

        double precio = Double.parseDouble(precioText.replace("$", "").trim());

        assert precio > 0 : "El precio total del carrito es incorrecto o no se muestra correctamente";

        double precioEsperado = 50.99;  // Este valor debe ser el cálculo esperado según los productos del carrito
        assert precio == precioEsperado : "El precio final esperado es " + precioEsperado + " pero el precio mostrado es " + precio;
    }
}
