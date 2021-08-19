package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//step 1 yes or no
		driver.findElementById("yes").click();
	
		//step2 set default
		WebElement unchecked = driver.findElement(By.xpath("//label[@for='Unchecked']"));
		if (unchecked.isSelected()) {
			System.out.println("unChecked is selected by default");
			
		}
		else
			System.out.println("checked is selected");
		
		//step3 age selection
		int myAge = 26;
		if (myAge < 20) {
			
			driver.findElement(By.xpath("//label[contains(text(),'age')]/following-sibling::input[@value='0']")).click();
		}
			else if (myAge>40) {
				
				driver.findElement(By.xpath("//label[contains(text(),'age')]/following-sibling::input[@value='2']")).click();
				
			}	
			
				
		
	}

}
