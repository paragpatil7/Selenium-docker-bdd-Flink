package com.WeatherShoppermodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;
    
        
    @FindBy(id="email")
    private WebElement emailTxt;
    
    @FindBy(id="card_number")
    private WebElement card_numberTxt;
    
    @FindBy(id="cc-exp")
    private WebElement expTxt;
    
    @FindBy(id="cc-csc")
    private WebElement CVVTxt;
    
    @FindBy(id="billing-zip")
    private WebElement zipTxt;
    
    @FindBy(id="submitButton")
    private WebElement submitButtonPaymentBtn;
    
    @FindBy(id = "search_button_homepage")
    private WebElement searchBtn;
    
    @FindBy(xpath = "//p[@class='text-justify']")
    private WebElement PAYMENTView;

    public PaymentPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

       
    public void FillandSubmitPayments(String email, String CardNumber, String Expiry, String CVV) throws InterruptedException
    {
    	
    	
    	driver.switchTo().frame(0);
    	this.wait.until(ExpectedConditions.visibilityOf(this.emailTxt));

    	emailTxt.sendKeys(email);
    	
    	JavascriptExecutor jse=(JavascriptExecutor)driver;
    	jse.executeScript("document.getElementById('card_number').value="+CardNumber+";");
    	
    	jse.executeScript("document.getElementById('cc-exp').value='11/23';");
    	    	
    	CVVTxt.sendKeys(CVV);
    	zipTxt.sendKeys("1234");
    	submitButtonPaymentBtn.click();
    	
    }
    
    
    public void verifyPaymentSuccessfull() throws InterruptedException
    {
    	this.wait.until(ExpectedConditions.titleContains("Confirmation")); 
    	String pageSource=driver.getPageSource();
    	System.out.println("pageSource..."+pageSource);
    	if(pageSource. contains("Your payment was successful. You should receive a follow-up call from our sales team."))
    	{
    		System.out.println("Payment Successfull...");
    		Boolean Vale=true;
    		Assert.assertTrue(Vale, "Payment Successfull");
    	}
    	else
    	{
    		System.out.println("Payment Not Successfull...");
    		Boolean Vale=false;
    		Assert.assertTrue(Vale, "Payment Not Successfull...got error while doing payment");
    	}
    }
    

}