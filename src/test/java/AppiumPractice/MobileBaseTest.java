package AppiumPractice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileBaseTest {
	AppiumDriverLocalService service;
	AndroidDriver driver;

	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {

		// To start Appium Server
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\reach\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		// To start app
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("RajEmulator");
		options.setPlatformName("Android");
		options.setDeviceName("emulator-5554");
		options.setCapability("browserName", "chrome");
		options.setChromedriverExecutable("C:\\Users\\reach\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		// Global implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	@AfterClass
	public void tearDown() {

		driver.quit();
		service.stop();
	}
}
