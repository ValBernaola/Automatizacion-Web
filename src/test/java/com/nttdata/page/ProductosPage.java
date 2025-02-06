package com.nttdata.page;

import org.openqa.selenium.By;

    public class ProductosPage {
    public static By itemP = By.id("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a");
    public static By ButtonAum = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]/i");
    public static By ButtonDis = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[2]/i");
    public static By AgregarCarrito = By.id("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    }
