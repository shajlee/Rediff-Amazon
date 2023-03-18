package jenkins_tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {
	
	public static WebDriver driver;
	public static ChromeOptions options;
	
	@BeforeTest
	public void launchUrl() {
		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(options);
		driver.get("https://amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	@Test(priority =1)
	public void clickOnSignInLink() {
		driver.findElement(By.cssSelector("span#nav-link-accountList-nav-line-1")).click();
	}
	@Test(priority =2, dependsOnMethods ="clickOnSignInLink")
	public void logInCredentials() {
		driver.findElement(By.cssSelector("input#ap_email")).sendKeys("chowdhurygs@gmail.com");
		driver.findElement(By.cssSelector("input#continue")).click();
		driver.findElement(By.cssSelector("input#ap_password")).sendKeys("Shajlee123");
		driver.findElement(By.cssSelector("input#signInSubmit")).click();
	}
	@Test(priority =3, dependsOnMethods ={"clickOnSignInLink", "logInCredentials"})
	public void clickOnAccount() {
		driver.findElement(By.cssSelector("span#nav-link-accountList-nav-line-1")).click();
	}
	@Test(priority =4, dependsOnMethods ={"clickOnSignInLink", "logInCredentials", "clickOnAccount"})
	public void amazonHome() {
		driver.findElement(By.cssSelector("a#nav-logo-sprites")).click();
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		
		
		
		
		
	
	}
	
	

}
