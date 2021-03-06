package pageObject_Component;

import java.util.List;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectCart {

	public AppiumDriver driver;

	//1st Section - Initialize Page factory
	public PageObjectCart(AppiumDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	//2nd Section - Collect the elements using @FindBy annotation
		@FindBy(id="com.ebay.mobile:id/search_box")
		public WebElement eBaySearch;
		
		@FindBy(id="com.ebay.mobile:id/search_src_text")
		public WebElement ebaySearchtxtbox;
		
		@FindBy(id="com.ebay.mobile:id/search_src_text")
		public WebElement searchresult;
		
		@FindBy(id="com.ebay.mobile:id/textview_item_count")
		public WebElement result;
			
	@FindBy(id="com.ebay.mobile:id/cell_collection_item")
	public WebElement ShoesArePresent;
	
	@FindBy(xpath="//*[@text='REEBOK M49324'][@index='0']")
	public List<WebElement> collectForLoop;
	
	@FindBy(xpath="//*[@text='REEBOK M49324'][@index='0']")
	public WebElement shoe;
	
	@FindBy(xpath="//*[@index='0'][@text='Select']")
	public WebElement selectDropdown;
	
	@FindBy(xpath="//*[@index='0'][@text='13.5']")
	public WebElement selectsize;
	
	@FindBy(id="com.ebay.mobile:id/button_bin")
	public WebElement buyNow;
	
	
	@FindBy(xpath ="//*[@text='Delivery address'][@index='0'][@class='android.view.View']")
	public WebElement deliveryAddress;
	

	//3rd Section - performing action on the elements collected
	public void clicksearch()
	{   
		eBaySearch.click();
	}
	public void enterSearchvalue(String value)
	{
		ebaySearchtxtbox.sendKeys(value+"\n");
	}
	
	public List<WebElement> sizeOfLoop()
	{
		return collectForLoop;
	}
	
	public void clickShoe()
	{
		shoe.click();
	}
	
	public void sDropdown()
	{
		selectDropdown.click();
	}
	
	public void shoesize()
	{
		selectsize.click();
	}
	
	public void buybtn()
	{
		buyNow.click();
	}
	
	public String getaddress()
	{
		return deliveryAddress.getText();
	}
}
