package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		
		//step 1 Launch the browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				
				driver.get("http://leaftaps.com/opentaps/control/main");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//step 2 Username
				driver.findElementById("username").sendKeys("demosalesmanager");
				
				//step 3 enter the password
				driver.findElementById("password").sendKeys("crmsfa");
				
				//step 4 Login
				driver.findElementByClassName("decorativeSubmit").click();
				
				//step 5 CRM SFA link
				driver.findElementByPartialLinkText("CRM").click();
				
				//Step 6 click Lead
				driver.findElementByLinkText("Leads").click();
				
				//step 7 Find LEads
				driver.findElementByPartialLinkText("Find").click();
				
				//step 8 Click email
				driver.findElement(By.xpath("//span[text() = 'Email']")).click();
				
				//step 9 Enter email
				driver.findElementByName("emailAddress").sendKeys("jsrosu12@gmail.com");
				
				//step 10 Click find leads button
				driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
				
				driver.navigate().back();
				
				//step 11 Capture the name of the first lead
				WebElement captureName = driver.findElement(By.xpath("//div[@class = 'x-grid3-cell-inner x-grid3-col-firstName']/a"));
				String firstName = captureName.getText();
				System.out.println("The name of the first lead is : " + firstName);
				
				//step 12 click the frst lead
				captureName.click();
				
				//step 13 Click duplicate lead
				driver.findElementByClassName("subMenuButton").click();
				
				//step 14 verifyt the titlet as duplicate lead
				boolean toVerify = driver.findElementById("sectionHeaderTitle_leads").isDisplayed();
				if (toVerify) {
					System.out.println("The title is Duplicate Lead");
					}
				else
					System.out.println("--------");
				
				//step 15 click create lead
				driver.findElementByClassName("smallSubmit").click();
				
				//step 16 confirm duplicate lead name is same as captured name
			String toConfirm = driver.findElementById("viewLead_firstName_sp").getText();
				if (toConfirm.equals(firstName)) {
					System.out.println("Both are same");
					}
				else
					System.out.println("Both are different");
	
				//step 17 Close the browse
				driver.close();
	}		
	

}
