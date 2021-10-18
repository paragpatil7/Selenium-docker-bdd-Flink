package com.test.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.WeatherShoppermodule.pages.*;
import com.cucumber.listener.Reporter;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WeatherShopperSteps{

    private WeatherShopperPage WeatherShopperPage;
    private PaymentPage PaymentPage;
    private WebDriver driver;
    public String BuyOption;

    @Given("^I am on the website Weather Shopper$")
    public void launchSite() {
    	WeatherShopperPage = new WeatherShopperPage(driver);
    	WeatherShopperPage.goTo();
    }
    
    @And("^I Select shopping type for Moisturizers or Sunscreens depends on Current temperature$")
    public void navigateToCurrentTemperature()  {
    	BuyOption=WeatherShopperPage.SelectOptionForShopping();
    	System.out.print("BuyOption"+BuyOption);
    }
    
    @And("^I Select least expensive two Product and add it to the cart$")
    public void addProducttoCart()  {
    	WeatherShopperPage.addProducttoCart(BuyOption);
    }

    @And("^I verify that the added product are correct$")
    public void verifyCart() throws InterruptedException  {
    	WeatherShopperPage.verifyCartOptions();
    }
    
    @Given("^I fill out payment details \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and submit the form$")
  //  @Given("^I fill out payment details \"([^\"]*)\",\"([^\"]*)\"(\\d+)\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and submit the form$")
    public void i_fill_out_payment_details_and_submit_the_form(String email, String CardNumber, String Expiry, String CVV) throws Throwable {
    	PaymentPage = new PaymentPage(driver);
    	PaymentPage.FillandSubmitPayments(email,CardNumber,Expiry,CVV);
        
    }
    
    @Then("^I verify that the Payment is Successfull$")
    public void i_verify_that_the_Payment_is_Successfull() throws Throwable {
       
    	PaymentPage.verifyPaymentSuccessfull();
    	
    }
    
    
    @Before
    public void setupDriver() throws MalformedURLException {
    	/*
    	//driver= new FirefoxDriver();
    			driver=new ChromeDriver();
    			driver.manage().window().maximize();
    			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	
    	*/
    	
    	
    	// BROWSER => chrome / firefox
        // HUB_HOST => localhost / 10.0.1.3 / hostname
        String host = "localhost";
        DesiredCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else{
            dc = DesiredCapabilities.chrome();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
       
        
    }

    @After
    public void quitDriver(){
    	
    	
			Reporter.loadXMLConfig(new File("extent-config.xml"));
		    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");

	//	}
       this.driver.quit();
    }

}