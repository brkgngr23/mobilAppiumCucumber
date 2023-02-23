package com.teknasyon.automation.core.operations;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofMillis;

public class Mobile {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(Mobile.class.getName());
    private final AppiumDriver<RemoteWebElement> appiumDriver;
    protected static FluentWait<AppiumDriver<MobileElement>> appiumFluentWait;
    private final TouchAction action;

    public Mobile(AppiumDriver<RemoteWebElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.action = new TouchAction(appiumDriver);
    }


    public Mobile pressByElement(By element) {
     appiumDriver.findElement(element).click();
     return this;
        }

    public Mobile checkElementContainsText(By element, String expectedText) {
        LOGGER.info(appiumDriver.findElement(element).getText());
        LOGGER.info(expectedText);
        Assert.assertTrue("Expected text is not contained", appiumDriver.findElement(element).getText().contains(expectedText));
        return this;
    }
    public void coordinateTap(int X, int Y) {

        TouchAction action = new TouchAction(appiumDriver);
        action.tap(PointOption.point( X, Y))
                .release().perform();

    }

    public boolean isNoElement(By locator) {
        WebDriverWait elementExist = new WebDriverWait(appiumDriver,30);
        elementExist.until(ExpectedConditions.visibilityOfElementLocated(locator));
        boolean result;
        try {
            appiumDriver.findElement(locator);
            result= true;

        } catch (org.openqa.selenium.NoSuchElementException e) {
            result=false;

        }
   Assert.assertEquals(result,false);

        return result;
    }

    public Mobile getCompareTwoElementText(By firstElement, By secondElement){
        WebDriverWait elementExist = new WebDriverWait(appiumDriver,30);
        elementExist.until(ExpectedConditions.visibilityOfElementLocated(firstElement));
        elementExist.until(ExpectedConditions.visibilityOfElementLocated(secondElement));

        String firstText= appiumDriver.findElement(firstElement).getText();
        String secondText= appiumDriver.findElement(secondElement).getText();

        Assert.assertEquals(firstText,secondText);
        return this;

    }

    public Mobile getTextControl(By element, String expectedText){
        WebDriverWait elementExist = new WebDriverWait(appiumDriver,30);
        elementExist.until(ExpectedConditions.visibilityOfElementLocated(element));
        String elementText= appiumDriver.findElement(element).getText();
        Assert.assertEquals(elementText,expectedText);
        return this;

    }

    public Mobile clearAndSendKeys (By element, String text){
        WebDriverWait elementExist = new WebDriverWait(appiumDriver,30);
        elementExist.until(ExpectedConditions.visibilityOfElementLocated(element));
        appiumDriver.findElement(element).clear();
        appiumDriver.findElement(element).sendKeys(text);
        return this;
    }

    public void middlePageSwipe(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {

                Dimension d = appiumDriver.manage().window().getSize();
                int width = d.width;
                int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
                int swipeStartHeight = (400 * 90) / 100;
                int swipeEndHeight = (400 * 50) / 100;
                new TouchAction(appiumDriver)
                        .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                        .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                        .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                        .release()
                        .perform();

        }
        Thread.sleep(1000);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("SWİPE EDİLDİ");
        System.out.println("-----------------------------------------------------------------");
    }
    public boolean isEnabled(By locator) {
        WebDriverWait elementExist = new WebDriverWait(appiumDriver,30);
        elementExist.until(ExpectedConditions.visibilityOfElementLocated(locator));
        boolean result;
        try {
            appiumDriver.findElement(locator).isEnabled();
            result= true;

        } catch (Exception e) {
            result=false;

        }
        Assert.assertEquals(result,true);

        return result;
    }

    public boolean isNotEnabled(By locator) {
        boolean result;
        try {
            appiumDriver.findElement(locator).isEnabled();
            result= true;

        } catch (Exception e) {
            result=false;

        }
        Assert.assertEquals(result,false);

        return result;
    }

    public Mobile pressLong(By element) {
        MobileElement mobileElement = (MobileElement) appiumDriver.findElement(element);
        TouchAction action = new TouchAction<>(appiumDriver);
        action
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(mobileElement)).withDuration(Duration.ofSeconds(3)))
                .release()
                .perform();
        return this;
    }
    public Mobile getKeyboardOnUi() {
        Actions actions = new Actions(appiumDriver);
        for (int i=0;i<30;i++) {
            actions.sendKeys(Keys.ARROW_RIGHT);
        }

        return this;
    }

    public void rightSwipe(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {

            Dimension d = appiumDriver.manage().window().getSize();
            int swipeStartWidth = 540, swipeEndWidth = 230;
            int swipeStartHeight = 300;
            int swipeEndHeight = 230;
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeEndWidth))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeStartHeight, swipeEndHeight))
                    .release()
                    .perform();

        }
        Thread.sleep(1000);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("SWİPE EDİLDİ");
        System.out.println("-----------------------------------------------------------------");
    }
}
