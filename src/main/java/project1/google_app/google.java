package project1.google_app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.*;

public class google
{
	WebDriver driver;  
    @BeforeTest
    private void beforetst() {
    	
    	System.setProperty("webdriver.chrome.driver", "E:\\NF\\DevOps\\INTEL\\Eclipse\\docs\\chromedriver_win32\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless");    //test will run at background not in GUI 
    	driver = new ChromeDriver(options);     //initialised the driver to ChromeDriver and call options
    }
    
    @BeforeMethod   //we will open the bowser
    private void openbrowser() {
    	driver.get("file:///E:/NF/DevOps/INTEL/Jenkins/case_study/cv.html");
    }
    
	@Test           //here we will declaire the elements which we need to find and test
	private void test() {
		Boolean b = driver.findElement (By.name ("submit")).isDisplayed();
		System.out.println("Logo tested successfully" + b);
		driver.findElement (By.name ("submit")).click();
		
		}
	
	
	
	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { google.class });
		testng.addListener(tla);
		testng.run();
	}
	
	
	
}