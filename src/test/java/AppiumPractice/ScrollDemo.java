package AppiumPractice;

import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ScrollDemo extends BaseTest {
	@Test
	public void ScrollToKnownLocationTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		// If where to scroll is known prior to execution use the below
		//WebElement ele= driver.findElement(AppiumBy.accessibilityId("WebView"));
		//scrollAppiumMethod(ele);
		
		//Own Method
		scrollToView("WebView");
		Thread.sleep(2000);

	}

	@Test
	public void ScrollToEndTest() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		scrollToEnd();
	}
}