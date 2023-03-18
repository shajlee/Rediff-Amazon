package jenkins_tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Rediff {
	
	public static WebDriver driver;
	public static ChromeOptions options;
	
	@BeforeTest
	public void launchUrl() {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://rediff.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
	
	}
		
	@Test(priority =1)
	public void clicOnSignInLink() {
		driver.findElement(By.className("signin")).click();
	}
	@Test(priority =2, dependsOnMethods ="clicOnSignInLink")
	public void logInCredentials() {
		driver.findElement(By.xpath("//input[@id = 'login1']")).sendKeys("chowdhurygs@rediffmail.com");
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("Shajlee1@");
		driver.findElement(By.xpath("//input[@class = 'signinbtn']")).click();
	}
	@Test(priority =3, dependsOnMethods = {"clicOnSignInLink", "logInCredentials"})
	public void clickOnLogOutLink() {
		driver.findElement(By.xpath("//a[@class = 'rd_logout']")).click();
	}
	@Test(priority =4, dependsOnMethods = {"clicOnSignInLink", "logInCredentials", "clickOnLogOutLink"})
	public void rediffHome() {
		driver.findElement(By.cssSelector("div.header div a+span a+a b")).click();
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	
		
		
	}
	
		
		
		
	}
	
		
		
	
	



