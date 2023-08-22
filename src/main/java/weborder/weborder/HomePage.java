package weborder.weborder;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

	WebDriver driver;
	
    public HomePage(WebDriver driver)
	      {
	    	  this.driver=driver;
	      }
	
	By username=By.xpath("//input[@id='ctl00_MainContent_username']");
	By password=By.name("ctl00$MainContent$password");
	By login=By.name("ctl00$MainContent$login_button");
	By head=By.xpath("//h1[contains(text(),'Web Orders')]");
	
	public void lounchbrowser()
	    {
	       driver= new ChromeDriver();
	       driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
	       driver.manage().window().maximize();
	    }
	
	
	public void setuser(String struser)
	{
	   	 driver.findElement(username).sendKeys(struser);
	}
	public void clearuser()
	{
		driver.findElement(username).clear();
	}
	public void setpass(String strpass)
	{
		driver.findElement(password).sendKeys(strpass);
	}
	public void clearpass()
	{
		driver.findElement(password).clear();
	}
	
	public void clicklogin()
	{
		driver.findElement(login).click();
	}
	
	public boolean getheading()
	{
		boolean title=driver.findElement(head).isDisplayed();
		return title;
	}
}
