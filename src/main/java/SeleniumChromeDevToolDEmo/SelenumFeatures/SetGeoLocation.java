package SeleniumChromeDevToolDEmo.SelenumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import java.util.Map;
import java.util.HashMap;;

public class SetGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map<String,Object> coordinates =  new HashMap<String,Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);

		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		 driver.get("https://www.google.ca");
		 driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		// driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
Thread.sleep(3000);
		    driver.findElements(By.cssSelector(".LC20lb.MBeuO.DKV0Md")).get(0).click();
		    String title =driver.findElement(By.cssSelector(".default-ltr-cache-jpuyb8.e9eyrqp8")).getText();
			System.out.println(title);


	        // Get and print the title of the page
	    //    String title = driver.findElement(By.cssSelector(".default-ltr-cache-jpuyb8 e9eyrqp8")).getText();

	        // Output - Películas ilimitadas, programas de TV y más
	     //   System.out.println("Page Title: " + title);
		

		 
		
		
	}

}
