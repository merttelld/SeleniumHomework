package com.testinium.odev.page;

import com.testinium.odev.methods.Methods;
import org.openqa.selenium.By;

public class LoginPage {
    Methods methods;

    public LoginPage(){
        methods = new Methods();
    }

    public void login(){
        methods.waitBySecond(2);
        methods.click(By.cssSelector(".menu-top-button.login>a"));
        methods.waitBySecond(2);
        methods.sendKeys(By.id("login-email"), "merteldemir6@gmail.com");
        methods.waitBySecond(2);
        methods.sendKeys(By.id("login-password"),"Ocak1998*");
        methods.waitBySecond(7);
        methods.click(By.xpath("//*[@id=\"login\"]/div[5]/button"));
        methods.waitBySecond(8);

    }
}
