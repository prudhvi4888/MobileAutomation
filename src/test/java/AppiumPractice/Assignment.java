package AppiumPractice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Assignment extends BaseTest {
	@Test
	public void practiceTest() {
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a long message")).click();
		Assert.assertTrue(driver.findElement(By.id("android:id/alertTitle")).isDisplayed(),
				"Header title failed to display");
		driver.findElement(By.id("android:id/button2")).click();

		// Radio Button
		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Traffic']")).click();
		driver.findElement(By.id("android:id/button2")).click();

		// Text Entry
		driver.findElement(AppiumBy.accessibilityId("Text Entry dialog")).click();
		Assert.assertTrue(driver.findElement(By.id("android:id/alertTitle")).isDisplayed(), "TextEntry did not display");
		driver.findElement(By.id("io.appium.android.apis:id/username_edit")).sendKeys("Prudhvi");
		
		driver.findElement(
				By.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/password_edit']"))
	.sendKeys("Nani");
		driver.findElement(By.id("android:id/button1")).click();
	}

}
