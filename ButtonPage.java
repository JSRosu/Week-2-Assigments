package selenium.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//step 1 Go to home Page and returning back to buttons page
		driver.findElement(By.id("home")).click();
		driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[2]")).click(); // driver.navigate.back
		
		//step 2 find the position of button x and y
		WebElement xyPos = driver.findElement(By.id("position"));
		Point xy = xyPos.getLocation();
		int x = xy.getX();
		int y = xy.getY();
		System.out.println("The position of X is : " + x);
		System.out.println("The position of Y is : " + y);
		
		//step 3 to find the color
		WebElement color = driver.findElement(By.id("color"));
		String colorName = color.getAttribute("style");
		System.out.println("The color is : " + colorName);
		
		//step 4 to find height and width
		WebElement prop = driver.findElement(By.id("size"));
		Dimension height = prop.getSize();
		Dimension width = prop.getSize();
		System.out.println("The height is : " + height);
		System.out.println("The width is : " + width);
		
	}

}
