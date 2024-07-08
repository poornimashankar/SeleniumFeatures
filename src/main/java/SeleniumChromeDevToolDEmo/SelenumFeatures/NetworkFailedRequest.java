package SeleniumChromeDevToolDEmo.SelenumFeatures;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.fetch.Fetch;
import org.openqa.selenium.devtools.v121.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v121.network.model.ErrorReason;

import java.util.Arrays;
import java.util.List;

public class NetworkFailedRequest {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");

		//log file ->
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//java.util.Optional<java.lang.String> urlPattern
		Optional<List<RequestPattern>>	patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));
		devTools.send(Fetch.enable(patterns, Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request ->
		{
			
			devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
			
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();


	}

}
