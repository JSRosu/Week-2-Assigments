package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		
		
		WebElement webUser = driver.findElement(By.id("username")); // this will locate

		webUser.sendKeys("demosalesmanager"); // this will type the username

		// step 6: locate password and enter the paswrd as crmsfa
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// step 7: locate login button and click on it.

		driver.findElement(By.className("decorativeSubmit")).click();

		// click on the login button CRM/SFA hyperlink

		driver.findElement(By.linkText("CRM/SFA")).click();
		// click leads

		driver.findElement(By.linkText("Leads")).click();

		// Click create lead

		driver.findElement(By.linkText("Create Lead")).click();

		// enter company name

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");

		// enter firstname

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Jeba");
		
		// enter lastname

				driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Roslin");

			

		// dropdown
		
		WebElement drop1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
Select drpDwn = new Select(drop1);
drpDwn.selectByIndex(1);

WebElement drop2 = driver.findElement(By.id("createLeadForm_industryEnumId"));
Select dropDown = new Select(drop2);
dropDown.selectByIndex(10);

WebElement MarketingCampaign = driver.findElement(By.name("marketingCampaignId"));
Select drop3 = new Select(MarketingCampaign);
drop3.selectByIndex(3);


driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Jeba");
driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Roslin");
driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Miss");
driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("03/1/95");
driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Sales");
driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Automobiles");



WebElement Ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
Select drop5 = new Select(Ownership);
drop5.selectByIndex(6);

driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("10");

driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("38,642 crores USD ");
driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("2WEG5J0");
driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("&&");
driver.findElement(By.id("createLeadForm_description")).sendKeys("Testing purpose");
driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Testing purpose");





driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("+91 9085356733");

driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("1");
driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Jeba");


driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("1");

driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("testleaf.com");
driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("acb@gmail.com");

driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Roslin");
driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Jeba");






driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Electronic city phase II");
driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("VGN PG");
driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Austin");


WebElement State = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
Select drop7 = new Select(State);
drop7.selectByIndex(4);

driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("73301");


driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("73301");

driver.findElement(By.name("submitButton")).click();






	}

}
