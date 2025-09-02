package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ReusableMethods {

    WebDriver driver = Main.getDriver();

    WebElement FirstName = driver.findElement(By.xpath("//input[@id='firstName']"));
    WebElement LastName = driver.findElement(By.xpath("//input[@id='lastName']"));
    WebElement PhoneNum = driver.findElement(By.id("phone"));
    WebElement EmailAdd = driver.findElement(By.id("emailAddress"));
    WebElement Password = driver.findElement(By.id("password"));

    WebElement SubmitBtn = driver.findElement(By.id("registerBtn"));

    public void assertFieldName_fname(ExtentTest test){
        try{
            if(driver.findElement(By.xpath("//label[contains(text(),'First Name*')]")).isDisplayed()){
                test.log(Status.INFO, "First Name field name is visible");
            }
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "First Name field name is not visible or mispelled");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void assertFieldName_lname(ExtentTest test){
        try{
            if(driver.findElement(By.xpath("//label[contains(text(),'Last Name*')]")).isDisplayed()){
                test.log(Status.INFO, "Last Name field name is visible");
            }
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Last Name field name is not visible or mispelled");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void assertFieldName_phonenum(ExtentTest test){
        try{
            if(driver.findElement(By.xpath("//label[contains(text(),'Phone number*')]")).isDisplayed()){
                test.log(Status.INFO, "Phone number field name is visible");
            }
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Phone number field name is not visible or mispelled");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void assertFieldName_emailadd(ExtentTest test){
        try{
            if(driver.findElement(By.xpath("//label[contains(text(),'Email address*')]")).isDisplayed()){
                test.log(Status.INFO, "Email address field name is visible");
            }
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Email address field name is not visible or mispelled");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void assertFieldName_password(ExtentTest test){
        try{
            if(driver.findElement(By.xpath("//label[contains(text(),'Password*')]")).isDisplayed()){
                test.log(Status.INFO, "Password field name is visible");
            }
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Password field name is not visible or mispelled");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void assertFieldName_Password_rule(ExtentTest test){
        try{
            if(driver.findElement(By.xpath("//small[@id='pwHelp' and contains(text(),'Password length validation: [6-20] characters')]")).isDisplayed()){
                test.log(Status.INFO, "Password rule is visible");
            }
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Password rule is not visible or mispelled");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void inputFirstName(String fname, ExtentTest test){
        try{
            System.out.println("Input first name: " + fname);
            FirstName.sendKeys(fname);
            test.log(Status.INFO, "Input first name: " + fname);
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Input first name failed");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void inputLastName(String lname, ExtentTest test){
        try{
            System.out.println("Input last name: " + lname);
            LastName.sendKeys(lname);
            test.log(Status.INFO, "Input last name: " + lname);
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Input last name failed");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void inputPhoneNum(String phoneNum, ExtentTest test){
        try{
            System.out.println("Input phone number: " + phoneNum);
            PhoneNum.sendKeys(phoneNum);
            test.log(Status.INFO, "Input phone number: " + phoneNum);
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Input phone number failed");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void inputEmailAdd(String emailAdd, ExtentTest test){
        try{
            System.out.println("Input email address: " + emailAdd);
            EmailAdd.sendKeys(emailAdd);
            test.log(Status.INFO, "Input email address: " + emailAdd);
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Input email address failed");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void inputPassword(String password, ExtentTest test){
        try{
            System.out.println("Input password.");
            Password.sendKeys(password);
            test.log(Status.INFO, "Input password");
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Input password failed");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickSubmitButton(ExtentTest test){
        try{
            System.out.println("Click Submit button");
            SubmitBtn.click();
            test.log(Status.INFO, "Click Submit button");
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Click Submit button failed");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void assertRegistrationResult(ExtentTest test){
        try{
            if (driver.findElement(By.xpath("//div[contains(text(),'Successfully registered the following information')]")).isDisplayed()) {
                test.log(Status.PASS, "Registration successful");
            }
            else if(driver.findElement(By.xpath("//div[contains(text(),'The password should contain between [6,20] characters!')]")).isDisplayed()){
                test.log(Status.FAIL, "Unsuccessful registration");
            }
            else{
                test.log(Status.FAIL, "Flash message is not visible");
            }
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Flash message is incorrect");
            System.err.println("Error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
