package week4.day1.assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement item6 = driver.findElement(By.xpath("//li[text() = Item 6]"));
		WebElement item7 = driver.findElement(By.xpath("//li[text() = Item 7]"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(item6, item7);

	}

}
