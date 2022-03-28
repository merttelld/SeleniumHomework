package com.testinium.odev.page;

import com.testinium.odev.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage {
    Methods methods;

    public HomePage(){
        methods = new Methods();
    }

    public void home(){
        methods.waitBySecond(2);
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='logo-icon']")));
    }
}
