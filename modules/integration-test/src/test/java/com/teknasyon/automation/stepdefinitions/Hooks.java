package com.teknasyon.automation.stepdefinitions;

import com.teknasyon.automation.core.configurations.AppiumFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Hooks {

    public static final Logger LOGGER = (Logger) LogManager.getLogger(Hooks.class.getName());
    private final DriverBase driverBase;

    public Hooks(DriverBase driverBase) {
        this.driverBase = driverBase;
    }

    @Before()
    public void beforeScenario(Scenario scenario) {

        DriverBase.appiumDriverThreadLocal = ThreadLocal.withInitial(() -> {
            AppiumFactory appiumFactory = new AppiumFactory();
            DriverBase.appiumDriverThreadPool.add(appiumFactory);
            return appiumFactory;
        });

        LOGGER.info(String.format("Scenario started : %s", scenario.getName()));
    }

    @After()
    public void afterScenario(Scenario scenario) {

        driverBase.quitAppiumDriver();
        LOGGER.info(String.format("Scenario finished : %s", scenario.getName()));
    }
}
