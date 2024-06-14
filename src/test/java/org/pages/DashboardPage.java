package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.Driver;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']")
    public WebElement DASHBOARD_TITLE;

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    public WebElement USER_DROPDOWN_TAB;

    @FindBy(xpath = "//a[contains(text(),'Logout') and @role='menuitem']")
    public  WebElement LOGOUT_DROPDOWN_ITEM;
}
