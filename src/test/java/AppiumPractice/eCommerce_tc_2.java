package AppiumPractice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2 extends MobileBaseTest {

	@Test
	public void browserTest() throws InterruptedException {
		driver.get("https://www.google.com/");
		Thread.sleep(6000);
		Set <String> context=driver.getContextHandles();
		for(String contextName:context) {
			System.out.println(contextName);
		}
		
		driver.findElement(By.id("APjFqb")).sendKeys("Rahul Shetty Academy");
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
	}
}
