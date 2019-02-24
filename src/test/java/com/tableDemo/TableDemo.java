package com.tableDemo;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

public class TableDemo {

	static WebDriver driver;

	@BeforeClass
	public static void setUp() {

		driver = Driver.getInstance();
		driver.get(ConfigurationReader.getProperty("tableUrl"));
		driver.get(ConfigurationReader.getProperty("herokuUrl"));

	}

	@Ignore
	@Test
	public void test1() {

		WebElement webTable = driver.findElement(By.id("example"));
		List<WebElement> rows = webTable.findElements(By.tagName("tr"));

		System.out.println("total rows :" + rows.size());

	}

	@Test
	public void test2() {

		WebElement table1 = driver.findElement(By.id("table2"));
		List<WebElement> rows = table1.findElements(By.tagName("tr"));

		System.out.println(rows.size());

		List<WebElement> cells = rows.get(4).findElements(By.tagName("td"));

		System.out.println(cells.get(4).getText());

	}

	@Test
	public void loopFromTable() {
		WebElement table1 = driver.findElement(By.id("table1"));
		List<WebElement> rows = table1.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			// System.out.println(row.getText());

			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | ");
			}
			System.out.println();
		}
	}
	@Test
	public void greyhoundTable() throws InterruptedException{
		driver.get("https://www.greyhound.com/north");
		driver.findElement(By.id("datepicker-from")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr[5]//td[2]//a")).click();
	}
}
