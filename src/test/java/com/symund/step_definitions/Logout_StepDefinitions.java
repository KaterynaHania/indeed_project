package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Logout_StepDefinitions {
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();


    @When("user clicks to avatar button")
    public void user_clicks_to_avatar_button() {

        dashboardPage.avatarBtn.click();

    }
    @And("user clicks to logout button")
    public void user_clicks_to_logout_button() {

    dashboardPage.logoutBtn.click();

    }

    @Given("user is on the Symund dashboard page")
    public void user_is_on_the_symund_dashboard_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
        loginPage.inputUsername.sendKeys("Employee131");
        loginPage.inputPassword.sendKeys("Employee123");
        loginPage.loginButton.click();


    }

    @When("user navigates and clicks to Back button")
    public void user_navigates_and_clicks_to_back_button() {

       Driver.getDriver().navigate().back();


    }



}
