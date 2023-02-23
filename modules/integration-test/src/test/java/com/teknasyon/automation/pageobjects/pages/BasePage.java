package com.teknasyon.automation.pageobjects.pages;

import com.teknasyon.automation.core.operations.Mobile;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {

    protected RemoteWebDriver driver;
    protected Mobile appiumMethods;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        appiumMethods = new Mobile(driver);
    }
}
