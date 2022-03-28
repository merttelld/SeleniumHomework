package com.testinium.odev.page;

import com.testinium.odev.driver.BaseTest;
import com.testinium.odev.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductPage {
    Methods methods;
    WebDriver driver;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage(){
        methods = new Methods();
        driver= BaseTest.driver;
    }

    public void selectProduct(){
        methods.waitBySecond(1);
        methods.sendKeys(By.id("search-input"),"Oyuncak");
        methods.waitBySecond(3);
        methods.click(By.cssSelector("#search>span"));
        methods.waitBySecond(3);

    }

    public void scrollPage(){
        List<WebElement> items = driver.findElements(By.cssSelector(".product-list>.product-cr"));
        long listCount = items.stream().count();

        if (listCount>=7){
            String currentItemId = items.get(6).getAttribute("id");
            String navigationItemId = ".product-list>#" + currentItemId;

            methods.scrollWithAction(By.cssSelector(navigationItemId));
        }else if (listCount > 0 && listCount < 7){
            String currentItemId = items.get(0).getAttribute("id");
            String navigationItemId = ".product-list>#" + currentItemId;

            methods.scrollWithAction(By.cssSelector(navigationItemId));
        }
    }

    public void addFavorites(){
        methods.waitBySecond(2);
        methods.click(By.xpath("//*[@id=\"product-579686\"]/div[2]/div[3]/a[4]"));
        methods.waitBySecond(2);
        methods.click(By.xpath("//*[@id=\"product-577332\"]/div[2]/div[3]/a[4]"));
        methods.waitBySecond(2);
        methods.click(By.xpath("//*[@id=\"product-577323\"]/div[2]/div[3]/a[4]"));
        methods.waitBySecond(7);
        methods.click(By.xpath("//*[@id=\"product-577328\"]/div[2]/div[3]/a[4]"));
        methods.waitBySecond(7);
    }

    public void favoriteControl(){
        methods.click(By.xpath("//*[@id=\"header-top\"]/div/div[1]/div[1]/ul/li/a"));
        methods.waitBySecond(4);
        methods.click(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/a[5]"));
        methods.waitBySecond(4);
    }

    public void goToThePointCatalog(){
        methods.click(By.cssSelector(".lvl1catalog"));
        methods.waitBySecond(4);
    }

    public void selectTurkishClassics(){
        methods.waitBySecond(2);
        methods.click(By.cssSelector("#landing-point>div:nth-child(4)>a:nth-child(2)>img"));
        methods.waitBySecond(2);
    }

    public void filterField(){
        methods.waitBySecond(2);
        methods.selectByText(By.cssSelector(".product-filter-header>.sort>select"),"Yüksek Oylama");
        methods.waitBySecond(3);
    }

    public void allBooksAndSelectHobies(){
        methods.waitBySecond(2);
        methods.click(By.cssSelector("#mainNav>div.nav-content>ul>li.book.has-menu.active>div.lvl2.js-bookCr>ul>li:nth-child(3)>span"));
        methods.waitBySecond(2);
        methods.click(By.cssSelector("#mainNav>div.nav-content>ul>li.book.has-menu.active>div.lvl2.js-bookCr>ul>li:nth-child(3)>div>div.open-menu-ct.bookAllCategories>div>ul:nth-child(3) >li:nth-child(14)>a"));
        methods.waitBySecond(2);
        methods.click(By.xpath("//*[@id=\"product-584966\"]/div[3]/div/a/img"));
        methods.waitBySecond(1);
        methods.click(By.id("button-cart"));
        methods.waitBySecond(1);
    }

    public void removeProduct(){
        methods.waitBySecond(2);
        methods.click(By.xpath("//*[@id=\"product-577332\"]/div[2]/div[3]/a[3]/i"));
        methods.waitBySecond(2);
    }

    public void goToTheBasket(){
        methods.waitBySecond(2);
        methods.click(By.xpath("//*[@id=\"cart\"]/div[1]/div[2]/h4"));
        methods.waitBySecond(2);
    }

    public void increaseProduct(){
        methods.waitBySecond(2);
        WebElement number = methods.findElement(By.xpath("//*[@id=\"cart_module\"]/div[1]/table/tbody/tr/td[4]/form/input[1]"));
        number.sendKeys("2");
        methods.waitBySecond(2);
        methods.click(By.xpath("//*[@id=\"cart_module\"]/div[1]/table/thead/tr/td[8]/a"));
        methods.waitBySecond(2);
    }



    }


