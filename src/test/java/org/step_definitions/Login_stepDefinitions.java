package org.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.pages.DashboardPage;
import org.pages.LoginPage;
import org.pages.ResetPasswordPage;
import org.utilities.ConfigurationReader;
import org.utilities.Driver;
import org.utilities.Utils;

public class Login_stepDefinitions {

    final LoginPage loginPage = new LoginPage();
    final DashboardPage dashboardPage = new DashboardPage();
    final ResetPasswordPage resetPasswordPage = new ResetPasswordPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginURL"));
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String usernameKey, String passwordKey) {
        String username = ConfigurationReader.getProperty(usernameKey);
        String password = ConfigurationReader.getProperty(passwordKey);

        loginPage.USERNAME_TEXTBOX.sendKeys(username);
        loginPage.PASSWORD_TEXTBOX.sendKeys(password);
    }

    @When("clicks on the login button")
    public void clicks_on_the_login_button() {
        loginPage.LOGIN_BTN.click();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        Utils.waitForVisibility(dashboardPage.DASHBOARD_TITLE,10);
        Assert.assertTrue(dashboardPage.DASHBOARD_TITLE.isDisplayed());
        Assert.assertTrue(dashboardPage.USER_DROPDOWN_TAB.isDisplayed());
    }

    @Then("the user should see an error and should not be redirected to the dashboard")
    public void the_user_should_see_an_error_and_should_not_be_redirected_to_the_dashboard() {
        Assert.assertTrue(loginPage.INVALID_CREDENTIALS_ALERT.isDisplayed());
        Assert.assertTrue(loginPage.LOGIN_BTN.isDisplayed());
    }

    @When("the user clicks on the forgot password link")
    public void the_user_clicks_on_the_forgot_password_link() {
        loginPage.FORGOT_PASSWORD_LINK.click();
    }

    @When("enters a registered email address {string}")
    public void enters_a_registered_email_address(String username) {
        Utils.waitForVisibility(resetPasswordPage.FORGOT_PASSWORD_CONTAINER, 10);
        resetPasswordPage.USERNAME_TEXTBOX.sendKeys(username);
        resetPasswordPage.SUBMIT_BTN.click();
    }

    @Then("password recovery email should be sent")
    public void password_recovery_email_should_be_sent() {
        Assert.assertTrue(resetPasswordPage.RESET_PASSWORD_SENT_TITLE.isDisplayed());
    }

    @When("the user enters an invalid OTP code")
    public void the_user_enters_an_invalid_otp_code() {
        // THE TEST DOMAIN DOESN'T HAVE THIS FUNCTIONALITY
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
        // THE TEST DOMAIN DOESN'T HAVE THIS FUNCTIONALITY
    }

    @When("the user enters the valid OTP code")
    public void the_user_enters_the_valid_otp_code() {
        // THE TEST DOMAIN DOESN'T HAVE THIS FUNCTIONALITY
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        // THE TEST DOMAIN DOESN'T HAVE THIS FUNCTIONALITY
    }

    @And("Logout")
    public void logout() {

        dashboardPage.USER_DROPDOWN_TAB.click();
        dashboardPage.LOGOUT_DROPDOWN_ITEM.click();
        Utils.waitForVisibility(loginPage.USERNAME_TEXTBOX,10);

    }
}
