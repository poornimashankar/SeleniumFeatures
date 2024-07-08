package SeleniumChromeDevToolDEmo.SelenumFeatures;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v121.fetch.Fetch;
import org.openqa.selenium.devtools.v123.network.Network;
import org.openqa.selenium.devtools.v123.network.model.Request;
import org.openqa.selenium.devtools.v123.network.model.RequestId;
import org.openqa.selenium.devtools.v123.network.model.Response;

public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), request -> {
			if (request.getRequest().getUrl().contains("shetty")) {
				String mockedUrl = request.getRequest().getUrl().replace("=shetty", "=BadGuy");

				System.out.println(mockedUrl);

				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),
						java.util.Optional.empty()));
			} else {

				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()),
						Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(),
						java.util.Optional.empty()));

			}

		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.cssSelector("p")).getText());


	}

}
