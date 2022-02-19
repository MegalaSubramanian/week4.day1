package week4.day1.assessment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement table = driver.findElement(By.id("table_id"));
		List<WebElement> column = table.findElements(By.xpath("//tr[1]/th"));
		System.out.println("No of Columns are: " + (column.size()));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("No of rows are: " + (rows.size()));
		WebElement elementsProgress = table.findElement(By.xpath("//tr[3]/td[2]"));
		System.out.println("The Progress of Learn to interact with Elements: " + (elementsProgress.getText()));
		List<Integer> progress = new ArrayList<Integer>();
		for (int i = 2; i <= rows.size(); i++) {
			String progressValue = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			System.out.println(progressValue);
			String text = progressValue.replaceAll("[^0-9]", "");
			System.out.println(text);
			int percent = Integer.parseInt(text);
			progress.add(percent);
		}
		Collections.sort(progress);
		Integer value = progress.get(0);
		driver.findElement(By.xpath("//td[contains(text(),'"+value+"')]/following-sibling::td/input")).click();
	}
}
