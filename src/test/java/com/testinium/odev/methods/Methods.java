package com.testinium.odev.methods;

import com.testinium.odev.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;
    Logger logger = LogManager.getLogger(Methods.class);

    public Methods(){
        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By element){
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void click(By element){
        findElement(element).click();
    }

    public void waitBySecond(long seconds) {
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendKeys(By element, String text){
        findElement(element).sendKeys(text);
        logger.info("Sendkeys işlemi başarılı");
    }

    public boolean isElementVisible(By element) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            logger.info("Login başarılı");
            return true;
        }catch (Exception e){
            logger.info("Login olamadı " + e.getMessage());
        return false;
        }
    }

    public void scrollWithAction(By element){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(element)).build().perform();
    }

    public Select getSelect(By element){
        return new Select(findElement(element));
    }

    public void selectByText(By element, String text) {
        getSelect(element).selectByVisibleText(text);
    }

    public void scrollWithJavaScript(By element){
        jsdriver.executeScript("arguments[0].scrollIntoView;",findElement(element));
    }

    public String getAttribute(By element, String attributeName){
        return findElement(element).getAttribute(attributeName);
    }

    public String getText(By element){
        return findElement(element).getText();
    }

    public String getValue(By element){
        return jsdriver.executeScript("return arguments[0].value;",findElement(element)).toString();
    }

}
