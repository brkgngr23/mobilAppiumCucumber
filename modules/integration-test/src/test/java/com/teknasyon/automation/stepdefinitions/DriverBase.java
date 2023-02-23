package com.teknasyon.automation.stepdefinitions;

import com.teknasyon.automation.core.configurations.AppiumFactory;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverBase {

    public static List<AppiumFactory> appiumDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    public static ThreadLocal<AppiumFactory> appiumDriverThreadLocal;


    public AppiumDriver<RemoteWebElement> createAppiumInstance() throws MalformedURLException {
        return appiumDriverThreadLocal.get().createInstance();
    }

    public AppiumDriver<RemoteWebElement> getAppiumDriver() {
        return appiumDriverThreadLocal.get().getAppiumDriver();
    }

    public void quitAppiumDriver() {
        appiumDriverThreadPool.forEach(AppiumFactory::quitAppiumDriver);
    }

}
