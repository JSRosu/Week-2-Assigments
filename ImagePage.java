package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagePage {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	   //step1 Click to go to home page
		driver.findElement(By.xpath("//img[contains(@src, 'home.png')]")).click();
		driver.navigate().back();
		
	  //step 2 broken img
		WebElement imgBroken = driver.findElement(By.xpath("//img[contains(@src, 'abcd.jpg')]"));
		String size = imgBroken.getAttribute("naturalWidth");
		
		if (size.equals("0")) {
			System.out.println("The image is broken");
		}
		else
			System.out.println("The image is not broken");
	
		
	  // step 3 keyboard or mouse
		driver.findElement(By.xpath("//img[contains(@src, 'keyboard.png')]")).click();
		
	}

}
