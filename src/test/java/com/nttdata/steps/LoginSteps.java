package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public LoginSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Hacer clic en el botón "Iniciar Sesión".

     * como para enviar (submit) las credenciales una vez ingresadas.
     */
    public void clickIniciarSesion() {
        WebElement iniciarSesion = wait.until(ExpectedConditions.elementToBeClickable(LoginPage.inicioSesion));
        iniciarSesion.click();
    }

    public  void typeUser(String user){
        WebElement userInputElement = driver.findElement(LoginPage.userField);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));


    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LoginPage.passField).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */

    public void clickLoginButton() {
        this.driver.findElement(LoginPage.loginButton).click();
    }

}
