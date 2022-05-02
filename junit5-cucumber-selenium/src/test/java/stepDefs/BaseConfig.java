package stepDefs;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseConfig {

	public ChromeDriver driver;
	public WebDriverWait wait;

	public BaseConfig() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://en.wikipedia.org/w/index.php?search");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);;
	}

}
