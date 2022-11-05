package com.symund.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {



    public LoginPage(){
        PageFactory.initElements(com.symund.utilities.Driver.getDriver(),this);
    }

    @FindBy(id = "user")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//div[@id='submit-wrapper']")
    public WebElement loginButton;

    public void login(){
        inputUsername.sendKeys("Employee131");
        inputPassword.sendKeys("Employee123");
        loginButton.click();
    }

@FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement warningMessage;


    @FindBy(xpath = "//input[@type='text']")
    public WebElement passwordAsText;


    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement eyeBtn;

    @FindBy(xpath = "//a[@id='lost-password']")
    public WebElement lostPasswordBtn;

    @FindBy(xpath = "//input[@id='reset-password-submit']")
    public WebElement resetPasswordBtn;



}
