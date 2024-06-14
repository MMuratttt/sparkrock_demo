package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement USERNAME_TEXTBOX;

    @FindBy(name = "password")
    public WebElement PASSWORD_TEXTBOX;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement LOGIN_BTN;

    @FindBy(xpath = "//div[@class='orangehrm-login-forgot']/p")
    public WebElement FORGOT_PASSWORD_LINK;

    @FindBy(xpath = "//div[@class='oxd-alert oxd-alert--error' and @role='alert']")
    public WebElement INVALID_CREDENTIALS_ALERT;
}
