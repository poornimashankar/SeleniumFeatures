package SeleniumChromeDevToolDEmo.SelenumFeatures;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.function.Predicate;
import java.net.URI;


public class BasicAuthentication {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");

		Predicate<URI> uriPredicate =uri ->  uri.getHost().contains("httpbin.org");
		//((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");


	}

}
