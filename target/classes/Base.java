package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver intializedriver() throws IOException {
		prop = new Properties();
		// FileInputStream file = new
		// FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		FileInputStream file = new FileInputStream(
				"E:\\MYSTUYDY\\WORKSPACE\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		String browsername = prop.getProperty("browser");
		System.out.println(browsername);
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\MYSTUYDY\\WORKSPACE\\webdrivers\\chromedriver.exe");
			/*
			 * ChromeOptions options= new ChromeOptions(); options.addArguments("headless");
			 */driver = new ChromeDriver();

		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\webdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}