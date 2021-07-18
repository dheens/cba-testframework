package com.au.covidgame.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class contains Page initialization and common functions
 * @author  Dhinash
 * @version 1.0
 */

public class BasePage {
    public WebDriver driver;
    public JavascriptExecutor js;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, 40);
    }

    public boolean isElementDisplayed(By element) {
        try{
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return webElement.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public boolean isElementInvisible(By element) {
        try{
            boolean status = wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
            return status;
        }catch(Exception e){
            return false;
        }
    }

    public void click(WebElement element) {
        waitForElement(element);
        element.click();
    }

    public boolean executeJSScript(String script, WebElement element) {
        return (boolean) js.executeScript(script, element);
    }

    public void scrollIntoView(String script, WebElement element) {
        js.executeScript(script, element);
    }

    public String getText(WebElement element) {
        waitForElement(element);
        return element.getText();
    }

    public boolean isElementDisplayed(WebElement element) {
        try{
            WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
            return webElement.isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public void waitForElement(WebElement value)
    {
        wait.until(ExpectedConditions.visibilityOf(value));
    }

}
