package week4.day1.assessment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/TextChange.html");
		WebElement button = driver.findElement(By.xpath("//button"));
		System.out.println("Before button changes: " + (button.getText()));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Click ME!')]")));
		System.out.println("After button changes: " + (button.getText()));
		button.click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Text on alert:" + text);
	}

}
