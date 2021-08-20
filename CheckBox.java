package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//step 1 Selecting C, C++
		driver.findElement(By.xpath("(//section[@class='innerblock']//input)[4]")).click();
		driver.findElement(By.xpath("(//section[@class='innerblock']//input)[5]")).click();
		
		// step 2 confirm Selenium is checked
		WebElement checked = driver.findElement(By.xpath("(//section[@class='innerblock']//input)[6]"));
		if (checked.isSelected()) {
			System.out.println("The Selenium is selected");
		}
		else {
			System.out.println("Selenium is not selected");
	}
		
		//step 3
		WebElement deselect1 = driver.findElement(By.xpath("(//section[@class='innerblock']//input)[7]"));
		if (deselect1.isSelected()) {
			deselect1.click();
			System.out.println("NOT SELECTED : It was selected");
			}
		else 
			System.out.println("NOT SELECTED : It was not selected");
		
		WebElement deselect2 = driver.findElement(By.xpath("(//section[@class='innerblock']//input)[8]"));
		if (deselect2.isSelected()) {
			deselect2.click();
			System.out.println("I AM SELECTED : It is selected");
			}
		else 
			System.out.println("I AM SELECTED : It was not selected");
		
		//step 4
		driver.findElement(By.xpath("(//div[@class='example']//input)[9]")).click();
		driver.findElement(By.xpath("(//div[@class='example']//input)[10]")).click();
		driver.findElement(By.xpath("(//div[@class='example']//input)[11]")).click();	
		driver.findElement(By.xpath("(//div[@class='example']//input)[12]")).click();
		driver.findElement(By.xpath("(//div[@class='example']//input)[13]")).click();
		}
		
	}


