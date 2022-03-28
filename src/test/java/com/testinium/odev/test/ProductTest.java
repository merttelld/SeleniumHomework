package com.testinium.odev.test;

import com.testinium.odev.driver.BaseTest;
import com.testinium.odev.page.HomePage;
import com.testinium.odev.page.LoginPage;
import com.testinium.odev.page.ProductPage;
import org.junit.Test;

public class ProductTest extends BaseTest {
    @Test
    public void productTest(){
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        HomePage homePage = new HomePage();

        loginPage.login();
        productPage.scrollPage();
        productPage.selectProduct();
        productPage.addFavorites();
        homePage.home();
        productPage.favoriteControl();
        productPage.goToThePointCatalog();
        productPage.selectTurkishClassics();
        productPage.filterField();
        productPage.allBooksAndSelectHobies();
        productPage.removeProduct();
        productPage.goToTheBasket();
        productPage.increaseProduct();
    }
}
