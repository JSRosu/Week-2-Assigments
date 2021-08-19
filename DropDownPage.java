package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownPage {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//step 1 using index
		WebElement useIndex = driver.findElement(By.id("dropdown1"));
		Select drop1 = new Select(useIndex);
		drop1.selectByIndex(1);
		
		//step 2 using TXT
		WebElement useTxt = driver.findElement(By.name("dropdown2"));
		Select drop2 = new Select(useTxt);
		drop2.selectByVisibleText("Selenium");
		
		//step 3 using value
		WebElement useValue = driver.findElement(By.id("dropdown3"));
		Select drop3 = new Select(useValue);
		drop3.selectByValue("1");
	
		//step 4 get number of dropdowns
		WebElement numofDrops = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select listofDrop = new Select(numofDrops);
		listofDrop.selectByIndex(3);
		int size = listofDrop.getOptions().size();
		System.out.println("The number of dropdowns are : " + size);
		
		//Step 5 using sendkeys
		driver.findElement(By.xpath("(//div[@class='example']//select)[5]")).sendKeys("Selenium");
		
		//step 6 select your program
		WebElement selectPg = driver.findElement(By.xpath("(//section[@class='innerblock']//select)[6]"));
		Select drop4 = new Select(selectPg);
		drop4.selectByValue("1");

	}
}