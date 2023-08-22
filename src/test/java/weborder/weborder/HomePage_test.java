package weborder.weborder;
import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class HomePage_test 
{
    WebDriver driver;
    HomePage HP= new HomePage(driver);
   
    @Test
    public void lounch()
    {
      HP.lounchbrowser();
    }
    
    
	@Test(priority = 1)
    public void clickonlogin() throws IOException, InterruptedException 
    {
    	//excel file--workbook--sheet--row--cell)
            //File file=new File(System.getProperty("D:\\Selenium Practice\\WebOrder Project\\workspace\\weborder\\test-data\\LoginData.xlsx"));
		String User = null,Pass = null;
		FileInputStream inputStream = new FileInputStream("D:\\\\Selenium Practice\\\\WebOrder Project\\\\workspace\\\\weborder\\\\test-data\\\\LoginData.xlsx");
             System.out.println("file found");	
		     XSSFWorkbook workbook=new XSSFWorkbook(inputStream);  
           
		     XSSFSheet sheet=workbook.getSheet("Sheet1"); 
             System.out.println("Sheet Name " +sheet);	
             
             int totalRow=sheet.getLastRowNum();
             System.out.println("Total Row" +totalRow);
           
             int totalcell=sheet.getRow(0).getLastCellNum();
             System.out.println("Total cloumn" +totalcell);	
            
            for(int r=0;r<=totalRow;r++)
            {
            	XSSFRow crow=(XSSFRow) sheet.getRow(r);
            	for (int j=0;j<=totalcell;j++)
            	{
            		 User=crow.getCell(0).getStringCellValue();
            	   Pass=crow.getCell(1).getStringCellValue();
            		Thread.sleep(2000);
            	        	
            	}
        		System.out.println("\nUser name :" + User);
        		System.out.println("pass:" + Pass);
        	HP.setuser(User);
        	HP.setpass(Pass);
        	Thread.sleep(2000);
        	HP.clicklogin();
        	 HP.clearuser();
           }
                      
          HP.clearpass();
                  
    } 
	
	@Test(priority = 2)
	public void verifyhomepage()
	{
		Assert.assertEquals(HP.getheading(), true);
	  System.out.println("Assertion is passed for Home");
	}
}
