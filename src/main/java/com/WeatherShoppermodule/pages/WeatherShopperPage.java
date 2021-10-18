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

public class WeatherShopperPage {

    private WebDriver driver;
    private WebDriverWait wait;
    
    Map<String,Integer> hp_ProductAddedCart=new HashMap<>();
    Map<String,Integer> hp_CartValueFetchfromApp=new HashMap<>();

    @FindBy(id="temperature")
    private WebElement temperatureTxt;
    
    @FindBy(xpath = "//button[contains(text(),'Buy moisturizers')]")
    private WebElement BuyMoisturizersBtn;
    
    @FindBy(xpath = "//button[contains(text(),'Buy sunscreens')]")
    private WebElement BuySunscreensBtn;
    
    @FindBy(xpath = "//button[starts-with(text(),'Cart - ')]")
    private WebElement CartBtn;

    @FindBy(xpath = "//span[contains(text(),'Pay with Card')]")
    private WebElement PayWithCardBtn;
    
       public WeatherShopperPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://weathershopper.pythonanywhere.com/");
    }

    public String SelectOptionForShopping()
    {
    	String CurrentTem=this.temperatureTxt.getText();
    	System.out.print("Current Temp"+CurrentTem);
    	
    	//44 °C
    	   	
    	int currtem=Integer.parseInt(CurrentTem.replaceAll("[^0-9]",""));
    	System.out.print("currtem Temp"+currtem);
    	if(currtem <= 19)
    	{
    		this.BuyMoisturizersBtn.click();
    		return "BuyMoisturizers";
    	}
    	else if(currtem >= 34)
    	{
    		this.BuySunscreensBtn.click();
    		return "BuySunscreens";
    	}
    	else
    	{
    		System.out.print("Enjoy the Weather");
    		return "Dont Buy anthing...Enjoy the Weather";
    	}
    		
    	
    }
    
    public void addProducttoCart(String BuyOption)
    {
    	Map<String,Integer> hp=new HashMap<>();
    	List<WebElement> allImages = driver.findElements(By.tagName("img"));
    	for(WebElement imageFromList:allImages){
    		WebElement productname=imageFromList.findElement(By.xpath("following-sibling::p"));
    		String ProductName= productname.getText();
    		System.out.println("ProductName"+ProductName);
    		 
    		 WebElement productAmt=imageFromList.findElement(By.xpath("following-sibling::p[2]"));
    		 String ProductAmt=productAmt.getText();
    		 String proAmt=ProductAmt.replaceAll("[^0-9]","");
    		 System.out.println("proAmt"+proAmt);
    		 hp.put(ProductName, Integer.parseInt(proAmt));
    	}
    	
    	 	
    	if(BuyOption.equals("BuyMoisturizers"))
    	{
    		AddSingleProductToCart(hp,"Aloe");
    		AddSingleProductToCart(hp,"Almond");
    		
    	}
    	else if(BuyOption.equals("BuySunscreens"))
    	{
    		
    		AddSingleProductToCart(hp,"SPF-50");
    		AddSingleProductToCart(hp,"SPF-30");
    	}
    	
    	goTCart();
    }
    
    public void goTCart() {
    	CartBtn.click();
		
	}

	public void AddSingleProductToCart(Map<String,Integer> hp,String ProductToSelect)
    {
    	int LeastAmt=Integer.MAX_VALUE;
		String ProductToAdd = null;
		for(Map.Entry<String,Integer> entry:hp.entrySet())
		{
			
			if(entry.getKey().toLowerCase().contains(ProductToSelect.toLowerCase())) 
			{
				if(LeastAmt >= entry.getValue())
				{
					LeastAmt=entry.getValue();
					ProductToAdd=entry.getKey();
				}
			}
		}
		System.out.println("ProductToAdd"+ProductToAdd);
		WebElement AddButton=driver.findElement(By.xpath("//p[contains(text(),'"+ProductToAdd+"')]/following-sibling::button"));	
		AddButton.click();
		hp_ProductAddedCart.put(ProductToAdd, LeastAmt);
    }
    
    public void verifyCartOptions() throws InterruptedException {
    	Thread.sleep(3000);
    	int CartSum=0;
    	List <WebElement> webtableRows=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
    	int rowcount=webtableRows.size();
    	System.out.println("Row Count"+rowcount);
    	
    	List <WebElement> webtableCols=driver.findElements(By.xpath("//table[@class='table table-striped'] /tbody/tr[1]/td"));
    	int Colcount=webtableCols.size();
    	System.out.println("Col Count"+Colcount);
    	
    	for(int i=1;i<=rowcount;i++)
    	{
    		int j=1;
    			String ItemProductName=driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td["+j+"]")).getText();
    			System.out.println("ItemProductName"+ItemProductName);
    			int ItemProductValue=Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td["+(j+1)+"]")).getText());
    			System.out.println("ItemProductValue"+ItemProductValue);
    			hp_CartValueFetchfromApp.put(ItemProductName, ItemProductValue);
    			CartSum=CartSum+ItemProductValue;
       	}
    	
    	if(hp_ProductAddedCart.equals(hp_CartValueFetchfromApp))
    	{
    		Boolean Vale=true;
    		System.out.println("Cart Values are Correct");
    		Assert.assertTrue(Vale, "Cart Values are Correct");
    	}
    	else
    	{
    		Boolean Vale=false;
    		System.out.println("Cart Values are not Correct");
    		Assert.assertTrue(Vale, "Cart Values are not Correct");
    	}
    	
    	String Sum=driver.findElement(By.xpath("//p[@id='total']")).getText();
    	int CartSumFetchFromApp=Integer.parseInt(Sum.replaceAll("[^0-9]",""));
    	
    	if(CartSum==CartSumFetchFromApp)
    	{
    		System.out.println("Cart Sum is also Correct"+CartSum);
    		Boolean Vale=true;
    		Assert.assertTrue(Vale, "Cart Sum is also Correct");
    	}
    	else
    	{
    		System.out.println("Cart Sum is Not Correct");
    		Boolean Vale=false;
    		Assert.assertTrue(Vale, "Cart Sum is Not Correct");
    	}
    	
    	
    	this.wait.until(ExpectedConditions.visibilityOf(this.PayWithCardBtn));
    	PayWithCardBtn.click();
    }
    
   
}