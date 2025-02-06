package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginPage {

    //Localizadores de elementos
    public static By inicioSesion = By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span");
    public static By userField = By.id("field-email");
    public static By passField = By.id("field-password");
    public static By loginButton = By.id("submit-login");

}
