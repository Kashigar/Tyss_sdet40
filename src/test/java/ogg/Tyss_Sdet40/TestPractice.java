package ogg.Tyss_Sdet40;

import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static genericUtilityes.ListenerImp.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPractice {

	@Test(dataProvider = "testData")
	public void test(String username,String password) {
		WebDriverManager.chromedriver().setup();
		//		ChromeOptions otp =new ChromeOptions();
		//		otp.addArguments("-- disableArgument");
		WebDriver driver = new ChromeDriver();
		test.info("browser is launched");
		driver.manage().window().maximize();
		test.info("window maximized");
		driver.get("https://www.facebook.com");
		test.info("url launched");
		assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		test.info("tittle asseration is passed");
		System.out.println(username+"  -- > "+password);
		System.out.println("test case is passed");
		driver.close();
	}

	@DataProvider(name = "testData")
	public Object[][] getData() {

		Object[][] data =new Object[2][2];

		data[0][0]= "Prem";
		data[0][1]= "9972";

		data[1][0]="suma";
		data[1][1]="7988";
		return data;
	}

}
