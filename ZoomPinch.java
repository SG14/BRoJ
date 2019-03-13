package wiproEbay;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZoomPinch {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","GT-I9300I");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");
		
		
		//app details
		capabilities.setCapability("appPackage","com.ebay.mobile");
		capabilities.setCapability("appActivity","com.ebay.mobile.activities.MainActivity");
		
		
		//appium server details
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//Note I am using hardcoded sleep at 2 places because we dont have any element to capture and wait for it.
		Thread.sleep(8000);

		//clicking on the search and entering the search value and searching
		driver.findElementById("com.ebay.mobile:id/search_box").click();
		driver.findElementById("com.ebay.mobile:id/search_src_text").sendKeys("Nike Shoes" + "\n");
	
		WebDriverWait wait = new WebDriverWait(driver, 8000);
		WebElement until1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ebay.mobile:id/textview_item_count")));
		until1.isDisplayed();
		
		String text1 = driver.findElementById("com.ebay.mobile:id/textview_item_count").getText();
		System.out.println(text1);
		
		//Wait for the image to load
		driver.findElementById("com.ebay.mobile:id/cell_collection_item").click();
		WebDriverWait wait2 = new WebDriverWait(driver, 8000);
		WebElement until2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.ebay.mobile:id/imageview_image")));
		until2.isDisplayed();
				
		driver.findElementById("com.ebay.mobile:id/imageview_image").click();
		
		
		WebElement ele_image = driver.findElementById("com.ebay.mobile:id/photo_gallery_item");
		int x=ele_image.getLocation().getX()+ele_image.getSize().getWidth()/2;
		int y=ele_image.getLocation().getY()+ele_image.getSize().getHeight()/2;
		System.out.println("x is  "+x+" y is "+y);
		Thread.sleep(4000);
		
		//Zoom
		TouchAction finger1= new TouchAction(driver);
		finger1.press(ele_image, x, y-20).moveTo(ele_image, x, y-200);
		
		TouchAction finger2= new TouchAction(driver);
		finger2.press(ele_image, x, y+20).moveTo(ele_image, x, y+200);
		
		MultiTouchAction action= new MultiTouchAction(driver);
		action.add(finger1).add(finger2).perform();
													
		Thread.sleep(8000);
		//*******************************************************
		//Pinch
		TouchAction finger3= new TouchAction(driver);
		finger3.press(ele_image, x, y-200).moveTo(ele_image, x, y-20);
		
		TouchAction finger4= new TouchAction(driver);
		finger4.press(ele_image, x, y+200).moveTo(ele_image, x, y+20);
		
		MultiTouchAction action2= new MultiTouchAction(driver);
		action2.add(finger3).add(finger4).perform();
		System.out.println("Helo");
		Thread.sleep(3000);
		
		
		

	}

}
