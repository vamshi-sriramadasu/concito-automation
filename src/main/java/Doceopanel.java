import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Doceopanel {

	WebDriver driver;
	Random rand= new Random();
	 @BeforeClass
	    public void setup() {
	        driver = new ChromeDriver();
	        
	        driver.manage().window().maximize();
	        driver.get("https://control.doceo.in/concitomind/superadmin/register");
	        
	        
	        
	    }
	 @Test(priority=1)
	    public void login() throws InterruptedException {
	    	
	    	driver.findElement(By.xpath("//input[@placeholder='Enter mobile']")).sendKeys("9010101001");
	    	driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("ghs123");
	    	driver.findElement(By.xpath("//button[@class='login-btn']")).click();
	    	Thread.sleep(3000);
	    }
	 @Test(priority=2)
	 public void masterdata() throws InterruptedException {
		 
		WebElement ddown= driver.findElement(By.xpath("//span[normalize-space()='Master Data']"));
		ddown.click();
		WebElement classesSubMenu = driver.findElement(By.xpath("//a[contains(text(),'Classes')]"));
        classesSubMenu.click();
        WebElement addcls= driver.findElement(By.xpath("//button[@id='add-class-btn']"));
        addcls.click(); 
        WebElement nameng= driver.findElement(By.xpath("//input[@placeholder='Name Eng']"));
        nameng.sendKeys("SIXTH CLASS");
        WebElement nametel= driver.findElement(By.xpath("//input[@placeholder='Name Tel']"));
        nametel.sendKeys("పదకొండవ తరగతి\r\n"
        		+ "");
        WebElement sections= driver.findElement(By.xpath("//select[@id='section_id']"));
        Select sectdrop =new Select(sections);
        sectdrop.selectByVisibleText("section a");
        sectdrop.selectByVisibleText("section b");
        
        WebElement acayear= driver.findElement(By.xpath("//select[@placeholder='Academic Year']"));
        Select year = new Select(acayear);
        year.selectByVisibleText("2025-26");
        
        WebElement fee = driver.findElement(By.xpath("//input[@placeholder='Fee']"));
        fee.sendKeys("200000");
        WebElement studentsno = driver.findElement(By.xpath("//input[@placeholder='Students']"));
        studentsno.sendKeys("30");
        WebElement savebutt = driver.findElement(By.xpath("//button[@id='saveTeacherBtn']"));
        savebutt.click();
//        WebElement directory = driver.findElement(By.xpath("//span[normalize-space()='Directory']"));
//        directory.click();
//        WebElement studentsSubMenu = driver.findElement(By.xpath("//a[@xpath='1']"));
//        studentsSubMenu.click();
//        WebElement addstudent = driver.findElement(By.xpath("//button[@id='add-student-btn']"));
//        addstudent.click();
        
         WebElement studymaterials = driver.findElement(By.xpath("//span[normalize-space()='Study Materials']"));
         studymaterials.click();
         WebElement addmaterial = driver.findElement(By.id("add-teacher-btn"));
         addmaterial.click();
         WebElement matname = driver.findElement(By.xpath("//input[@name='name_en']"));
         matname.sendKeys("dictionary");
         WebElement matnametel = driver.findElement(By.xpath("//input[@name='name_te']"));
         matnametel.sendKeys("dictionaryt");
         
         WebElement selclass = driver.findElement(By.xpath("//select[@name='class_id']"));
         Select clsdrop = new Select(selclass);
         clsdrop.selectByVisibleText("FIRST CLASS");
         
         WebElement selsec = driver.findElement(By.xpath("//select[@name='section_id']"));
         Select secdrop = new Select(selsec);
         secdrop.selectByVisibleText("section a");
         
        WebElement selteach = driver.findElement(By.xpath(""));
         Select teachdrop = new Select(selteach);
         teachdrop.selectByVisibleText("SAIDUL");
       
         
         
         
     
	 }
	 
	 @Test(priority=3)
	 public void studentdata() {
		 
		 WebElement parent = driver.findElement(By.xpath("//select[@placeholder='Parent Name']"));
		 Select par = new Select(parent);
		 par.selectByVisibleText("bhargav");
		 WebElement nameofs=driver.findElement(By.xpath("//div[@class='col-xl-3 col-lg-6 col-12 form-group']//input[@placeholder='Name Eng']"));
		 nameofs.sendKeys("piyush");
		 
		 
	 }
	 

	 @Test(dataProvider = "classnames")
	 public void addClass(String classNameEng) throws InterruptedException {
		    Random rand = new Random();

		    
		    driver.findElement(By.name("class_name")).sendKeys(classNameEng);

		    
		    String[] teluguSamples = {"పదవ తరగతి", "ఎన్నో తరగతి", "తొలిసారి", "మార్చి తరగతి", "పరీక్ష తరగతి"};
		    driver.findElement(By.name("class_name_telugu")).sendKeys(teluguSamples[rand.nextInt(teluguSamples.length)]);

		    
		    WebElement sectionList = driver.findElement(By.name("section_name[]"));
		    Select sectionDropdown = new Select(sectionList);
		    sectionDropdown.selectByVisibleText("section a");
		    sectionDropdown.selectByVisibleText("section b");

		    Select yearDropdown = new Select(driver.findElement(By.name("academic_year")));
		    yearDropdown.selectByVisibleText("2025-26");

		    int feeAmount = (rand.nextInt(10) + 1) * 1000;  
		    driver.findElement(By.name("fee")).sendKeys(String.valueOf(feeAmount));

		    
		    int students = rand.nextInt(21) + 20;  
		    driver.findElement(By.name("students")).sendKeys(String.valueOf(students));

		    
		    driver.findElement(By.xpath("//button[text()='Save']")).click();

		   
		    Thread.sleep(2000);
		}

}
