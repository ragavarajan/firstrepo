package tkpackbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tkbase {

	WebDriver driver;

	public WebDriver openbrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\innoppl.INNO0252-PC\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
}
