package concito1;

import com.github.javafaker.Faker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Base1 {
    protected WebDriver driver;
    Faker faker;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        faker = new Faker();
        driver.manage().window().maximize();
        driver.get("https://control.doceo.in/Login"); // Replace with actual form URL
    }

    @Test
    public void login() throws InterruptedException {
    	
    	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("9010101010");
    	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("lhs123");
    	driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    	Thread.sleep(3000);
    }
//    @Test
//    public void home() throws InterruptedException {
//    	Select courseDropdown = new Select(driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")));
//        List<WebElement> options = courseDropdown.getOptions();
//        int randomIndex = new Random().nextInt(options.size()); // Avoid selecting the first option if it's a placeholder
//        courseDropdown.selectByIndex(randomIndex);
////    	driver.findElement(By.xpath("(//a[@class='nav-link'])[2]")).click();
////    	Thread.sleep(3000);
////    	driver.findElement(By.xpath("(//a[@class='nav-link'])[5]")).click();
//    }
//    @Test
//    public void enterRandomStudentData() {
//        String name = faker.name().fullName();
//        String email = faker.internet().emailAddress();
//        String phone = faker.phoneNumber().cellPhone();
//        String address = faker.address().fullAddress();
//
//        driver.findElement(By.id("studentName")).sendKeys(name);
//        driver.findElement(By.id("studentEmail")).sendKeys(email);
//        driver.findElement(By.id("studentPhone")).sendKeys(phone);
//        driver.findElement(By.id("studentAddress")).sendKeys(address);
//        
//        // Submit the form
//        driver.findElement(By.id("submitButton")).click();
//    }

    @AfterClass
    public void teardown() {
        //driver.quit();
    }
}
