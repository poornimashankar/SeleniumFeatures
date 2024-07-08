package SeleniumChromeDevToolDEmo.SelenumFeatures;

import java.util.Optional;
import java.util.Map;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.emulation.Emulation;

public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		// send command to CDP Methods-> CDP Methods will invoke and get access to
		// chrome dev tools
		// devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true,
		// Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
		// Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
		// Optional.empty()));

		// devTools.send(Emulation.setDeviceMetricsOverride(600, 1000,50,true,
		// Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),Optional.empty(),
		// Optional.empty(), Optional.empty(),Optional.empty()) );
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Library")).click();
		driver.close();
		// Network.getRequestPostData

		// send command to CDP Methods-> CDP Methods will invoke and get access to
		// chrome dev tools

		Map deviceMetrics = new HashMap() {
			{
				put("width", 600);
				put("height", 1000);
				put("mobile", true);
				put("deviceScaleFactor", 50);
			}
		};

		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		 driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		 driver.findElement(By.cssSelector((".navbar-toggler-icon"))).click();
		 Thread.sleep(3000);
		 driver.findElement(By.linkText("Library")).click();

	}

}
