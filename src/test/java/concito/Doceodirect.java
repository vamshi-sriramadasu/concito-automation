////package concito;
////
////import org.openqa.selenium.By;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.chrome.ChromeDriver;
////import org.openqa.selenium.chrome.ChromeOptions;
////import org.testng.annotations.*;
////
////import com.github.javafaker.Faker;
////
////import io.github.bonigarcia.wdm.WebDriverManager;
////
////public class Doceodirect {
////
////    public static WebDriver driver;
////    protected Faker faker;
////
////    @BeforeMethod
////    public void setUp() throws InterruptedException {
////
////
////        driver = new ChromeDriver();
////        driver.manage().window().maximize();
////
////        faker = new Faker();
////
////        driver.get("https://control.doceo.in/Login");
////        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("9010101010");
////        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("lhs123");
////        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
////
////        Thread.sleep(3000);
////    }
////
////    @AfterMethod
////    public void tearDown() {
////        driver.quit();
////    }
////}
//
//package concito;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;
//
//import com.github.javafaker.Faker;
//
//public class Doceodirect {
//	protected WebDriver driver;
//	Faker faker;
//	@BeforeTest
//	public void add_insti() throws InterruptedException {
//		driver=new ChromeDriver();
//		faker = new Faker();
//		driver.get("https://control.doceo.in/Login");
//		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("9010101010");
//    	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("lhs123");
//    	driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
//    	Thread.sleep(3000);
//	}
//
//}

package concito;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.github.javafaker.Faker;

public class Doceodirect {

    // 🔴 CHANGE 1: ThreadLocal instead of normal WebDriver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected Faker faker;

    // 🔴 CHANGE 2: getter method (VERY IMPORTANT)
    protected WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void add_insti() throws InterruptedException {

        // 🔴 CHANGE 3: set driver for current thread
        WebDriver driverRef = new ChromeDriver();
        driver.set(driverRef);

        faker = new Faker();

        getDriver().get("https://control.doceo.in/Login");
        getDriver().manage().window().maximize();

        getDriver().findElement(By.xpath("//input[@placeholder='Username']"))
                   .sendKeys("9010101010");

        getDriver().findElement(By.xpath("//input[@placeholder='Password']"))
                   .sendKeys("lhs123");

        getDriver().findElement(By.xpath("//button[normalize-space()='Login']"))
                   .click();

        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        driver.remove(); // 🔴 IMPORTANT for parallel
    }
}

