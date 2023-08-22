package weborder.weborder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewAllOrderPage {
	
	WebDriver driver;
	public ViewAllOrderPage(WebDriver driver)
    {
  	  this.driver=driver;
    }

	By checkall=By.xpath("//a[@id='ctl00_MainContent_btnCheckAll']");
	By uncheckall=By.xpath("//a[@id='ctl00_MainContent_btnUncheckAll']");
	By delete=By.xpath("//input[@id='ctl00_MainContent_btnDelete']");
	By title=By.xpath("//h2[contains(text(),'List of All Orders')]");
	
	public boolean VerifyViewAllOrder()
	{
		boolean titl=driver.findElement(title).isDisplayed();
		return titl;
	}
	
	public void ClickOnCheckAll()
	{
		
	}
	
	public void ClickUnCheckAll()
	{
		
	}
}
