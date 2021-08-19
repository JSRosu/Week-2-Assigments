package selenium.setup;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLinkPage {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//step 1 go to home page
		driver.findElement(By.xpath("(//a[contains(text(), 'Home')])[1]")).click();
		driver.navigate().back();
		
		//step2 Find where am supposed to go
		WebElement find = driver.findElement(By.xpath("//a[contains(text(), 'supposed')]"));
		String link = find.getAttribute("href");
		System.out.println("The link where am supposed to go is : " + link);
		
		// step 3 verify broken
		WebElement verify = driver.findElement(By.xpath("//a[contains(text(), 'broken')]"));
		verify.click();
		String title = driver.getTitle();
		
		if (title.contains("404")) {
			System.out.println("The link is broken");
		}
		else
			System.out.println("The link is not broken");
		driver.navigate().back();
		
		
		
	
		
	}

}
