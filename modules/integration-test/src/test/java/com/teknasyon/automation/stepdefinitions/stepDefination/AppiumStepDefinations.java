package com.teknasyon.automation.stepdefinitions.stepDefination;

import com.teknasyon.automation.pageobjects.pages.PageAppium;
import com.teknasyon.automation.stepdefinitions.DriverBase;
import com.teknasyon.automation.stepdefinitions.Hooks;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.sql.SQLException;

public class AppiumStepDefinations {

    private final PageAppium loginPage;

    private final AppiumDriver<RemoteWebElement> appiumDriver;

    public static final Logger LOGGER = (Logger) LogManager.getLogger(Hooks.class.getName());


    public AppiumStepDefinations(DriverBase driverBase) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, MalformedURLException {
        appiumDriver = driverBase.createAppiumInstance();
        loginPage = new PageAppium(appiumDriver);

    }
    @Given("Remove tabs control")
    public void removeAllTabs() throws InterruptedException {
        loginPage.clickAppTab();
        loginPage.clickActionBar();
        loginPage.clickActionBarTab();
        loginPage.clickAddNewTab();
        loginPage.removeTab();
    }

    @Given("{string} {string} change title")
    public void changeTitle(String leftText,String rightText) throws InterruptedException {
        loginPage.clickAppTab();
        loginPage.clickAppActivity();
        loginPage.clickCustomTitle();
        loginPage.controlAndChangeCustomTitle(leftText,rightText);

    }

    @Given("List Dialog Control")
    public void listDialog() throws InterruptedException {
        loginPage.clickAppTab();
        loginPage.clickAlertDialog();
        loginPage.clickListDialog();
        loginPage.listDialogControl();

    }

    @Given("Enable Admin Authority")
    public void enableAdminProcess() throws InterruptedException {
        loginPage.clickAppTab();
        loginPage.clickDeviceAdminTab();
        loginPage.enableAdmin();

    }

    @Given("Long Press Button")
    public void longPressToButton() throws InterruptedException {
        loginPage.clickAppTab();
        loginPage.clickFragmentTab();
        loginPage.contextMenuLongPress();

    }

    @Given("Fragment tab hide control")
    public void hideAndControl() throws InterruptedException {
        loginPage.clickAppTab();
        loginPage.clickFragmentTab();
        loginPage.clickHideAndControl();

    }

    @Given("Scroll to last tab and control")
    public void scrollLastTab() throws InterruptedException {
        loginPage.clickViewsTab();
        loginPage.clickTabs();
        loginPage.getLastTab();

    }

}

