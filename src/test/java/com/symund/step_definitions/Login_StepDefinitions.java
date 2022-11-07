package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefinitions {

LoginPage loginPage = new LoginPage();

    @When("user enters valid username")
    public void user_enters_valid_username() {
loginPage.inputUsername.sendKeys("Employee131");

    }
    @When("user enters valid password")
    public void user_enters_valid_password() {
        loginPage.inputPassword.sendKeys("Employee123");

    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
       String actualURL = Driver.getDriver().getCurrentUrl();
       String expectedURL = "https://qa.symund.com/index.php/apps/dashboard/";

        Assert.assertEquals(expectedURL,actualURL);

        String actualWelcomeMessage = new DashboardPage().welcomeMessage.getText();
        String expectedUsername = "Kateryna";

        Assert.assertTrue(actualWelcomeMessage.contains(expectedUsername));


    }

    @When("user enters invalid username {string}")
    public void user_enters_invalid_username(String username) {
        loginPage.inputUsername.sendKeys(username);
    }
    @When("user enters invalid password {string}")
    public void user_enters_invalid_password(String password) {
        loginPage.inputPassword.sendKeys(password);
    }
    @Then("user should see the message {string}")
    public void user_should_see_the_message(String warningMessage) {
       String actualWarningMessage = loginPage.warningMessage.getText();
       String expectedWarningMessage = warningMessage;

       Assert.assertEquals(expectedWarningMessage,actualWarningMessage);

    }





    @Given("user is on the Symund login page")
    public void user_is_on_the_symund_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));

    }


    @And("user clicks to login button")
    public void userClicksToLoginButton() {
        loginPage.loginButton.click();
    }



    @Then("Please fill out this field \\(usernameField) message should be displayed")
    public void please_fill_out_this_field_username_field_message_should_be_displayed() {

        Assert.assertTrue(loginPage.inputUsername.getTagName().equals("input"));



        BrowserUtils.sleep(2);
        System.out.println(loginPage.inputUsername.getAttribute("validationMessage"));
        Assert.assertEquals("Please fill out this field.",loginPage.
                inputUsername.getAttribute("validationMessage"));
    }

    @Then("password must be seen as dots")
    public void password_must_be_seen_as_dots() {

        Assert.assertEquals("password",loginPage.inputPassword.getAttribute("type"));

    }

    @When("clicks eye-button")
    public void clicks_eye_button() {
loginPage.eyeBtn.click();
    }
    @Then("user should see password explicitly")
    public void user_should_see_password_explicitly() {
        Assert.assertEquals("text",loginPage.inputPassword.getAttribute("type"));
    }


    @When("User can see the Forgot password? link")
    public void user_can_see_the_forgot_password_link() {
        Assert.assertEquals("lost-password",loginPage.lostPasswordBtn.getAttribute("id"));


    }
    @And("User can click Forgot password button")
    public void user_can_click_forgot_password_button() {
        loginPage.lostPasswordBtn.click();
    }
    @Then("User can see Reset password button")
    public void user_can_see_reset_password_button() {
        Assert.assertEquals("reset-password-submit",loginPage.resetPasswordBtn.getAttribute("id"));
    }


    @Then("user can see valid placeholder on Password field")
    public void userCanSeeValidPlaceholderOnPasswordField() {

        Assert.assertEquals("password",loginPage.inputPassword.getAttribute("id"));
    }

    @When("user can see valid placeholder on Username field")
    public void userCanSeeValidPlaceholderOnUsernameField() {

        Assert.assertEquals("user",loginPage.inputUsername.getAttribute("id"));

    }
}