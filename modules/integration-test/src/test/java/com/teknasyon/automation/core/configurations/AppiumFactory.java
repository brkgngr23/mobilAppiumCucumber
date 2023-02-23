package com.teknasyon.automation.core.configurations;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidOptions;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.RemoteWebElement;
import java.net.URL;
import java.net.MalformedURLException;


public class AppiumFactory {

    private AppiumDriver<RemoteWebElement> appiumDriver;

    public AppiumDriver<RemoteWebElement> createInstance() throws MalformedURLException {
        if (null == appiumDriver) {
            instantiateAppiumDriver();
        }
        return appiumDriver;
    }

    public AppiumDriver<RemoteWebElement> getAppiumDriver() {
        return appiumDriver;
    }

    public void quitAppiumDriver() {
        if (null != appiumDriver) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }

    private void instantiateAppiumDriver() throws MalformedURLException {
        appiumDriver = createAppiumDriver();

    }
    protected AppiumDriver<RemoteWebElement> createAppiumDriver() throws MalformedURLException {
        AndroidOptions androidOptions= new AndroidOptions();
        androidOptions.setPlatformName(MobilePlatform.ANDROID);
        androidOptions.setUdid("emulator-5554");
        androidOptions.setPlatformVersion("11");
        androidOptions.setNoReset(true);
        androidOptions.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.hmh.api.ApiDemos");
        androidOptions.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.hmh.api");
        androidOptions.setCapability(AndroidMobileCapabilityType.SKIP_UNLOCK, true);
        androidOptions.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        androidOptions.setCapability("autoAcceptAlerts", "true");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        appiumDriver = new AndroidDriver(url, androidOptions);
        return appiumDriver;
    }

}
