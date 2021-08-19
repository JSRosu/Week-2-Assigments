package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//step1 enter email address
		driver.findElement(By.id("email")).sendKeys("abc12@gmail.com");
		
		//step 2 Append a text \t = tab
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("txt \t");
		
		//step 3 default txt enter
		WebElement txtDef = driver.findElement(By.xpath("//input[@value='TestLeaf']"));
		txtDef.getAttribute("value");
		
		//step 4 clear txt
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		
		//step 5 to confirm whether it is disabled
		WebElement isEnabled = driver.findElement(By.xpath("//input[@disabled='true']"));
		boolean isEnabledvalue = isEnabled.isEnabled();
		
		if (isEnabledvalue) {
			System.out.println("The edit field is enabled");
			}
		else
			System.out.println("The field is disabled");
		
	}

}
