package com.test;

import org.openqa.selenium.By;

public class Variables {
    
    // public static final By NAME_FIELD = By.id("name");
    // public static final By EMAIL_FIELD = By.id("email");
    // public static final By SEVERITY_DROPDOWN = By.id("severity");
    // public static final By DESCRIPTION_TEXTAREA = By.id("bug-description");
    
    // // Using XPath for the submit button as per the original code.
    // public static final By SUBMIT_BUTTON = By.xpath("//button[@type='submit']");
    
    // // Using CSS Selector for the success message.
    // public static final By SUCCESS_MESSAGE = By.cssSelector("div.is-success");

    // using xpath
    public static final By FirstName = By.xpath("//input[@id='firstName']");
    public static final By LastName = By.xpath("//input[@id='lastName']");

    // using id
    public static final By PhoneNum = By.id("phone");
    public static final By EmailAdd = By.id("emailAddress");
    public static final By Password = By.id("password");

}
