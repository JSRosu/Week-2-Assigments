package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");

		// maximize and delay
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	
		driver.findElement(By.name("UserFirstName")).sendKeys("Jeba");
		driver.findElement(By.name("UserLastName")).sendKeys("Roslin");
		driver.findElement(By.name("UserEmail")).sendKeys("jsrosu12@gmail.com");
		WebElement JobTitle = driver.findElement(By.name("UserTitle"));
		Select drop1 = new Select(JobTitle);
		drop1.selectByIndex(7);
		
		driver.findElement(By.name("CompanyName")).sendKeys("tech mahindra");
		WebElement Employees = driver.findElement(By.name("CompanyEmployees"));
		Select drop2 = new Select(Employees);
		drop2.selectByIndex(4);
		driver.findElement(By.name("UserPhone")).sendKeys("375984124");
		driver.findElement(By.name("CompanyCountry")).clear();
		WebElement Country = driver.findElement(By.name("CompanyCountry"));
        Select drop3 = new Select(Country);
        drop3.selectByValue("India");
        
        driver.findElement(By.name("checkbox-ui")).click();
	
	}

}
