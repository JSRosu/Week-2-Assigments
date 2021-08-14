package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		
		// download, launch and load URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		
		// maximize and some delay
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		
		//getting into login page
		driver.findElement(By.linkText("Create New Account")).click();
		
		// firstname, lastname, mob no., password
		driver.findElement(By.name("firstname")).sendKeys("Jeba");
		driver.findElement(By.name("lastname")).sendKeys("Roslin");
		driver.findElement(By.name("reg_email__")).sendKeys("9834268553");
		driver.findElement(By.id("password_step_input")).sendKeys("jesus@123");
		
		
		// DOB dropdowns
		WebElement dayDrp = driver.findElement(By.id("day"));
        Select drop1 = new Select(dayDrp);
        drop1.selectByValue("1");
        
        WebElement monthDrp = driver.findElement(By.id("month"));
	    Select drop2 = new Select(monthDrp);
	    drop2.selectByIndex(3);
	    
	    WebElement yearDrp = driver.findElement(By.id("year"));
	    Select drop3 = new Select(yearDrp);
	    drop3.selectByValue("1995");
	    
	    //gender radio button click
	    driver.findElement(By.className("_58mt")).click();
	    
	    // sign up
	    driver.findElement(By.name("websubmit")).click();
	
	}

}
