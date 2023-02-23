package com.teknasyon.automation.pageobjects.pages;

import com.teknasyon.automation.pageobjects.locators.campaigns.PageLocatorsAppium;
import com.teknasyon.automation.stepdefinitions.Hooks;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


public class PageAppium extends BasePage {

    public static final Logger LOGGER = (Logger) LogManager.getLogger(Hooks.class.getName());


    public PageAppium(AppiumDriver driver) {
        super(driver);
    }

    public void clickAppTab() {
        appiumMethods.pressByElement(PageLocatorsAppium.appTabButton);
    }

    public void clickViewsTab(){
        appiumMethods.pressByElement(PageLocatorsAppium.viewsTab);
    }

    public void clickTabs() throws InterruptedException {
        appiumMethods.middlePageSwipe(25);
        appiumMethods.pressByElement(PageLocatorsAppium.tabs);
    }

    public void clickAlertDialog() {
        appiumMethods.pressByElement(PageLocatorsAppium.alertDialogTab);
    }

    public void clickListDialog() {
        appiumMethods.pressByElement(PageLocatorsAppium.listDialogButton);
    }

    public void clickActionBar() {
        appiumMethods.pressByElement(PageLocatorsAppium.actionBarButton);
    }

    public void clickAppActivity() {
        appiumMethods.pressByElement(PageLocatorsAppium.appActivityButton);
    }
    public void clickCustomTitle() {
        appiumMethods.pressByElement(PageLocatorsAppium.customTitleButton);
    }

    public void clickDeviceAdminTab() {
        appiumMethods.pressByElement(PageLocatorsAppium.deviceAdminTab);
    }

    public void clickFragmentTab() {
        appiumMethods.pressByElement(PageLocatorsAppium.fragmentTab);
    }

    public void clickActionBarTab() {
        appiumMethods.pressByElement(PageLocatorsAppium.actionBarTabsButton);
        appiumMethods.checkElementContainsText(PageLocatorsAppium.actionBarTabsTitle, "App/Action Bar/Action Bar Tabs");
    }

    public void clickAddNewTab() {
        appiumMethods.pressByElement(PageLocatorsAppium.toggleButton);
        appiumMethods.pressByElement(PageLocatorsAppium.addNewTabButton);
        appiumMethods.checkElementContainsText(PageLocatorsAppium.addFirstTabText, "TAB 0");
        appiumMethods.pressByElement(PageLocatorsAppium.addNewTabButton);
        appiumMethods.checkElementContainsText(PageLocatorsAppium.addSecondTabText, "TAB 1");
        appiumMethods.pressByElement(PageLocatorsAppium.addNewTabButton);
        appiumMethods.checkElementContainsText(PageLocatorsAppium.addThirdTabText, "TAB 2");
    }

    public void removeTab() throws InterruptedException {
        appiumMethods.pressByElement(PageLocatorsAppium.removeLastButton);
        appiumMethods.coordinateTap(862, 74);
        Thread.sleep(1000);
        appiumMethods.checkElementContainsText(PageLocatorsAppium.tabText, "Tab 1");
        appiumMethods.pressByElement(PageLocatorsAppium.removeAllTabsButton);
        appiumMethods.isNoElement(PageLocatorsAppium.addFirstTabText);
    }
    public void controlAndChangeCustomTitle(String leftText,String rightText)  {
        appiumMethods.getTextControl(PageLocatorsAppium.leftInbox,"Left is best");
        appiumMethods.getTextControl(PageLocatorsAppium.rightInbox,"Right is always right");
        appiumMethods.clearAndSendKeys(PageLocatorsAppium.leftInbox,leftText);
        appiumMethods.clearAndSendKeys(PageLocatorsAppium.rightInbox,rightText);
        appiumMethods.pressByElement(PageLocatorsAppium.changeLeftButton);
        appiumMethods.pressByElement(PageLocatorsAppium.changeRightButton);
        appiumMethods.getCompareTwoElementText(PageLocatorsAppium.leftInbox, PageLocatorsAppium.leftTitleText);
        appiumMethods.getCompareTwoElementText(PageLocatorsAppium.rightInbox, PageLocatorsAppium.rightTitleText);
    }
    public void listDialogControl()  {
        appiumMethods.pressByElement(PageLocatorsAppium.listDialogFirstDialog);
        appiumMethods.getTextControl(PageLocatorsAppium.listDialogText,"You selected: 0 , Command one");
        appiumMethods.coordinateTap(500, 1678);
        clickListDialog();
        appiumMethods.pressByElement(PageLocatorsAppium.listDialogSecondDialog);
        appiumMethods.getTextControl(PageLocatorsAppium.listDialogText,"You selected: 1 , Command two");
        appiumMethods.coordinateTap(500, 1678);
        clickListDialog();
        appiumMethods.pressByElement(PageLocatorsAppium.listDialogThirdDialog);
        appiumMethods.getTextControl(PageLocatorsAppium.listDialogText,"You selected: 2 , Command three");
        appiumMethods.coordinateTap(500, 1678);
        clickListDialog();
        appiumMethods.pressByElement(PageLocatorsAppium.listDialogLastDialog);
        appiumMethods.getTextControl(PageLocatorsAppium.listDialogText,"You selected: 3 , Command four");
    }

    public void enableAdmin() throws InterruptedException {
        appiumMethods.pressByElement(PageLocatorsAppium.generalTab);
        appiumMethods.pressByElement(PageLocatorsAppium.enableAdminCheckBox);
        appiumMethods.middlePageSwipe(2);
        appiumMethods.pressByElement(PageLocatorsAppium.activeAdmin);
        appiumMethods.isEnabled(PageLocatorsAppium.disableCameraCheckBox);

    }

    public void contextMenuLongPress() {
        appiumMethods.pressByElement(PageLocatorsAppium.contextTab);
        appiumMethods.pressLong(PageLocatorsAppium.longPressButton);
        appiumMethods.getTextControl(PageLocatorsAppium.firstMenuButton,"Menu A");
        appiumMethods.getTextControl(PageLocatorsAppium.lastMenuButton,"Menu B");

    }

    public void clickHideAndControl() {
        appiumMethods.pressByElement(PageLocatorsAppium.hideAndShowTab);
        appiumMethods.isEnabled(PageLocatorsAppium.firstHideButton);
        appiumMethods.isEnabled(PageLocatorsAppium.secondTextArea);
        appiumMethods.getTextControl(PageLocatorsAppium.secondHideButton,"Hide");
        appiumMethods.pressByElement(PageLocatorsAppium.secondHideButton);
        appiumMethods.getTextControl(PageLocatorsAppium.secondHideButton,"Show");
        appiumMethods.isNotEnabled(PageLocatorsAppium.secondTextArea);
    }

    public void getLastTab() throws InterruptedException {
        appiumMethods.pressByElement(PageLocatorsAppium.scrolableTab);
        appiumMethods.rightSwipe(30);
        appiumMethods.getTextControl(PageLocatorsAppium.scrolableTabLast,"TAB 30");
    }
}