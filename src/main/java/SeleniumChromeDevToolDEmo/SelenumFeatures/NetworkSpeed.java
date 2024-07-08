package SeleniumChromeDevToolDEmo.SelenumFeatures;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.network.Network;
import org.openqa.selenium.devtools.v121.network.model.ConnectionType;

public class NetworkSpeed {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");

		//log file ->
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));
		devTools.addListener(Network.loadingFailed(), loadingFailed->
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
			
			
		});
		long startTime = System.currentTimeMillis();
		 driver.get("https://www.google.ca");
		 driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		    driver.findElements(By.cssSelector(".LC20lb.MBeuO.DKV0Md")).get(0).click();
		 String title =driver.findElement(By.cssSelector(".default-ltr-cache-jpuyb8.e9eyrqp8")).getText();
			System.out.println(title);


		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		driver.close();
		

	}

}
