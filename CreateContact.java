package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//step 2 Username and password using ID
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		
		//step 3 login using class locator
		driver.findElementByClassName("decorativeSubmit").click();
		
		//step 4 CRM SFA link
		driver.findElementByPartialLinkText("CRM").click();
		
		//step 5 Contact button
		driver.findElementByLinkText("Contacts").click();
		
		//step 6 create contact
		driver.findElementByPartialLinkText("Create").click();
		
		//step 7 first name using ID
		driver.findElementById("firstNameField").sendKeys("Jeba");
		
		// step 8 last name using ID
		driver.findElementById("lastNameField").sendKeys("Roslin");
		
		//step 9 first name local using ID
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("Rose");
		
		// step 10 lastname local using ID
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("Jeb");
		
		//step 11 Dept
		driver.findElementById("createContactForm_departmentName").sendKeys("Automobile");
		
		//step 12 description
		driver.findElementById("createContactForm_description").sendKeys("For testing purpose.");
		
		//step 13 Email
		driver.findElementById("createContactForm_primaryEmail").sendKeys("abc12@gmail.com");
		
		//step 14 dropdown
		WebElement state = driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select drop1 = new Select(state);
		drop1.selectByVisibleText("New York");
	
		//step 15 create contact
		driver.findElementByClassName("smallSubmit").click();
		
		//step 16 Edit button
		driver.findElementByClassName("subMenuButton").click();
		
		//step 17 Clear description
		WebElement clearDes = driver.findElementById("updateContactForm_description");
		clearDes.clear();
	
		//step 18 Important note
		driver.findElementById("updateContactForm_importantNote").sendKeys("For testing purpose.");
		
		// step 19 Update button using Xpath
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		
		//step 20 Get title
		String title = driver.getTitle();
		System.out.println("The title of the page is : " + title);
	
	}

}
