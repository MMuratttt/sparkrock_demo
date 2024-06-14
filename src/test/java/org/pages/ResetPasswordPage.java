package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utilities.Driver;

public class ResetPasswordPage {

    public ResetPasswordPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='orangehrm-forgot-password-wrapper']")
    public WebElement FORGOT_PASSWORD_CONTAINER;

    @FindBy(name = "username")
    public WebElement USERNAME_TEXTBOX;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SUBMIT_BTN;

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
    public WebElement RESET_PASSWORD_SENT_TITLE;
}
