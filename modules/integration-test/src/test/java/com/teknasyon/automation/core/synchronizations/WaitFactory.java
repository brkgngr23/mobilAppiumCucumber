package com.teknasyon.automation.core.synchronizations;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFactory {

    private final WebDriverWait wait;

    public WaitFactory(AppiumDriver driver) {
        wait = new WebDriverWait(driver, 20);
    }

    public WebElement waitForPresenceOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementVisible(By locator) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitForElementIsClickable(By locator) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }


    public void waitForElementContainsText(By locator, String partialText) {
        WebElement element = waitForPresenceOfElementLocated(locator);
        wait.until(ExpectedConditions.textToBePresentInElement(element, partialText));
    }

}
