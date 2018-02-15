package pageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObjectSearch {
	
	public AppiumDriver driver;
	
	
	//2nd Section - Collect the elements using @FindBy annotation
	@FindBy(id="com.ebay.mobile:id/search_box")
	public WebElement eBaySearch;
	
	
	@FindBy(id="com.ebay.mobile:id/search_src_text")
	public WebElement ebaySearchtxtbox;
	
	@FindBy(id="com.ebay.mobile:id/search_src_text")
	public WebElement searchresult;
	
	
	
	
	//1st Section - Initialize Page factory
	public PageObjectSearch(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//3rd Section - performing action on the elements collected
	public void clicksearch()
	{   System.out.println(eBaySearch.getText());
		eBaySearch.click();
	}
	public void enterSearchvalue(String value)
	{
		ebaySearchtxtbox.sendKeys(value+"\n");
	}
	
	
	public String getsearchresultcount()
	{
		return searchresult.getText();
	}
	

}
