package com.testinium.odev.test;

import com.testinium.odev.driver.BaseTest;
import com.testinium.odev.page.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage();

        loginPage.login();
    }
}
