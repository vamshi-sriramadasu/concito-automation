package concito2;


	
	import org.openqa.selenium.By;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import concito1.Base1;

import java.util.Random;

	public class DirectoryTest extends Base1 {

	    @Test(dataProvider = "directoryData")
	    public void fillDirectory(String name, String phone) throws InterruptedException {
	        // Expand Directory menu
	        driver.findElement(By.xpath("//span[normalize-space()='Directory']")).click();
Thread.sleep(3000);
	        // Click submenu: Update XPath based on sub-module (e.g., Staff Directory)
	        driver.findElement(By.xpath("//a[normalize-space()='Staff Directory']")).click();

	        // Click Add Button (update as per actual page)
	        driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();

	        // Fill Form
	        driver.findElement(By.name("name")).sendKeys(name);
	        driver.findElement(By.name("phone")).sendKeys(phone);

	        // Submit
	        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

	        Thread.sleep(1000);  // Optional wait
	    }

	    @DataProvider(name = "directoryData")
	    public Object[][] getDirectoryData() {
	        return new Object[][] {
	            {getRandomName(), getRandomPhone()},
	            {getRandomName(), getRandomPhone()}
	        };
	    }

	    public String getRandomName() {
	        String[] names = {"Anil", "Sunita", "Raj", "Meena"};
	        return names[new Random().nextInt(names.length)];
	    }

	    public String getRandomPhone() {
	        return "9" + (new Random().nextInt(900000000) + 100000000);
	    }
	}


