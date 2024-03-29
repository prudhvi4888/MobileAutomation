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

public class BaseTest {
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
		options.setApp(
				"C:\\Users\\reach\\eclipse-workspace\\AppiumPractice\\src\\test\\java\\Resources\\General-Store.apk");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		// Global implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void longPressAction(WebElement ele) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void swipeAppiumMethod(WebElement ele, String direction) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.25));
	}

	public void scrollToView(String text) {

		String uiAutomatorText = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))";
		try {
			driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorText));
		} catch (NoSuchElementException exception) {

		}
	}

	public void scrollToEnd() {

		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0));
		} while (canScrollMore);
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
		service.stop();
	}
}
