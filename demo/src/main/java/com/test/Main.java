package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Main {
    private static WebDriver driver;
    private static ExtentReports extent;


    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void main(String[] args) {
        try{
            WebDriver driver = Main.getDriver();
            driver.get("https://qa-practice.netlify.app/bugs-form");

            ExtentSparkReporter htmlReport = new ExtentSparkReporter("extent-report.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReport);
            htmlReport.config().setReportName("test");

            System.out.println("Scenario 1: Input valid credentials");
            scenario1();

            System.out.println("Scenario 2: Input Invalid credentials");
            scenario2();

            System.out.println("Scenario 3: No credentials submitted");
            scenario3();

            System.out.println("Scenario 4: Assert visible elements in the page");
            scenario4();

            driver.quit();
            extent.flush();
        }
        catch (AssertionError | Exception e){
            System.err.println("Main program error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void scenario1(){
        driver.get(driver.getCurrentUrl());
        ReusableMethods flows = new ReusableMethods();
        ExtentTest test = extent.createTest("Scenario 1: Input valid credentials");

        try{
           flows.inputFirstName("Sean Melvin John", test);
           flows.inputLastName("Dela Cruz", test);
           flows.inputPhoneNum("09276303526", test);
           flows.inputEmailAdd("seanmelvinjohndelacruz@gmail.com", test);
           flows.inputPassword("seanpassword123", test);
           flows.clickSubmitButton(test);
           flows.assertRegistrationResult(test);
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Scenario failed");
            System.err.println("Scenario error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void scenario2(){
        driver.get(driver.getCurrentUrl());
        ReusableMethods flows = new ReusableMethods();
        ExtentTest test = extent.createTest("Scenario 2: Input Invalid credentials");

        try{
           flows.inputFirstName("Sean", test);
           flows.inputLastName("Dela Cruz", test);
           flows.inputPhoneNum("0927", test);
           flows.inputEmailAdd("seanmelvinjohndelacruz@gmail.com", test);
           flows.inputPassword("sean", test);
           flows.clickSubmitButton(test);
           flows.assertRegistrationResult(test);
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Scenario failed");
            System.err.println("Scenario error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void scenario3(){
        driver.get(driver.getCurrentUrl());
        ReusableMethods flows = new ReusableMethods();
        ExtentTest test = extent.createTest("Scenario 3: No credentials submitted");

        try{
           flows.assertRegistrationResult(test);
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Scenario failed");
            System.err.println("Scenario error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    public static void scenario4(){
        driver.get(driver.getCurrentUrl());
        ReusableMethods flows = new ReusableMethods();
        ExtentTest test = extent.createTest("Scenario 4: Assert visible fields in the page");

        try{
            flows.assertFieldName_fname(test);
            flows.assertFieldName_lname(test);
            flows.assertFieldName_phonenum(test);
            flows.assertFieldName_emailadd(test);
            flows.assertFieldName_password(test);
            flows.assertFieldName_Password_rule(test);
        }
        catch (AssertionError | Exception e){
            test.log(Status.FAIL, "Scenario failed");
            System.err.println("Scenario error occured: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
