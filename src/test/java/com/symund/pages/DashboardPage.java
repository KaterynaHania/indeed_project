package com.symund.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage (){

        PageFactory.initElements(com.symund.utilities.Driver.getDriver(),this);


    }

    @FindBy(xpath = "//div[@id='app-dashboard']/h2")
    public WebElement welcomeMessage;

    @FindBy(xpath="//div[@class='avatardiv avatardiv-shown']")
    public  WebElement avatarBtn;



    @FindBy(xpath="//li[@data-id='logout']")
    public  WebElement logoutBtn;
}

