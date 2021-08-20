package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
	
		
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
		
		//step 8 Click on phn 
		driver.findElement(By.xpath("(//span[@class = 'x-tab-strip-text '])[2]")).click();
		
		//step 9 enter phn num
		driver.findElementByName("phoneNumber").sendKeys("9894803335");
		
		//step 10 click on find leads
		driver.findElement(By.xpath("(//button[@class = 'x-btn-text'])[7]")).click();
		
		driver.navigate().back();
		
		//step 11 Capture lead ID of first resulting lead
		WebElement findLead = driver.findElement(By.xpath("//div[contains(@class, 'x-grid3-cell-inner x-grid3-col-partyId')]/a"));
				
		String leadId = findLead.getText();
		System.out.println("The first lead ID is : " + leadId );
		
		//step 12 Click first Lead 
		findLead.click();
		
		//step 13 Click delete
		driver.findElementByClassName("subMenuButtonDangerous").click();
		
		//step 14 Click find lead
		driver.findElementByPartialLinkText("Find").click();
		
		//step 15 enter the captured ID
		driver.findElementByName("id").sendKeys(leadId);
		
		
		//step 16 click find leads
		driver.findElement(By.xpath("(//button[@class = 'x-btn-text'])[7]")).click();
		
		//step 17 Verify no records found
		Boolean toVerify = driver.findElement(By.xpath("//div[text() = 'No records to display']")).isDisplayed();
		if (toVerify) {
			System.out.println("The lead is deleted");
			}
		else 
			System.out.println("The lead is not deleted");
		
		//step 18 close the browser
		driver.close();
	}

}
