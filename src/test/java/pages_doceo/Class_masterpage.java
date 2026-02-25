//package pages_doceo;
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;
//
//public class Class_masterpage {
//
//protected WebDriver driver;
//	
//	public Class_masterpage(WebDriver driver) {
//		
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
//	
//	@FindBy (xpath = "//span[normalize-space()='Master Data']")
//	WebElement masterdata;
//	
//	@FindBy (xpath = "//a[normalize-space()='Classes']")
//	WebElement classes_master;
//	
//	@FindBy (xpath = "//button[@id='add-class-btn']")
//	WebElement add_class;
//	
//	@FindBy (xpath = "//input[@placeholder='Name Eng']")
//	WebElement class_nameng;
//	
//	@FindBy (xpath = "//input[@placeholder='Name Tel']")
//	WebElement class_name_tel ;
//	
//	@FindBy (xpath = "//option[normalize-space()='section A']")
//	WebElement section_namedrop1;
//	
//	@FindBy (xpath = "//option[@value='2']")
//	WebElement section_namedrresop2;
//	
//	@FindBy (xpath = "//select[@placeholder='Academic Year']")
//	WebElement academicyear_dropdown;
//	
//	@FindBy (xpath = "//input[@placeholder='Fee']")
//	WebElement fee_class;
//	
//	@FindBy (xpath = "//input[@placeholder='Students']")
//	WebElement students_total;
//	
//	@FindBy (xpath = "//button[@id='saveTeacherBtn']")
//	WebElement class_savebutt ;
//	
//	public void masterdataclass() {
//		masterdata.click();
//	}
//	
//	public void class_masterdata() {
//		classes_master.click();
//	}
//	
//	public void add_classes() {
//		add_class.click();
//	}
//	
//	public void classfields(String cnameng,String cnametel) {
//		class_nameng.sendKeys(cnameng);
//		class_name_tel.sendKeys(cnametel);
//	}
//	
//	public void section_drops() throws AWTException {
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		section_namedrop1.click();
//		section_namedrresop2.click();
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//	}
//	
//	public void academicyeardrop(String year) {
//		Select dropdown = new Select(academicyear_dropdown);
//		dropdown.selectByVisibleText(year);;
//	}
//	
//	public void classfee(String feeclass) {
//	 fee_class.sendKeys(feeclass);;
//	}
//	
//	public void students_tot(String studentstota) {
//		students_total.sendKeys(studentstota);;
//	} 
//	
//	public void class_savebutton() {
//		class_savebutt.click();
//	}
//	
//	
//	
//}

package pages_doceo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Class_masterpage {

protected WebDriver driver;
	
	public Class_masterpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[normalize-space()='Master Data']")
	WebElement masterdata;
	
	@FindBy (xpath = "//a[normalize-space()='Classes']")
	WebElement classes_master;
	
	@FindBy (xpath = "//button[@id='add-class-btn']")
	WebElement add_class;
	
	@FindBy (xpath = "//input[@placeholder='Name Eng']")
	WebElement class_nameng;
	
	@FindBy (xpath = "//input[@placeholder='Name Tel']")
	WebElement class_name_tel ;
	
	@FindBy (xpath = "//option[normalize-space()='section A']")
	WebElement section_namedrop1;
	
	@FindBy (xpath = "//option[@value='2']")
	WebElement section_namedrop2;
	
	@FindBy (xpath = "//select[@placeholder='Academic Year']")
	WebElement academicyear_dropdown;
	
	@FindBy (xpath = "//input[@placeholder='Fee']")
	WebElement fee_class;
	
	@FindBy (xpath = "//input[@placeholder='Students']")
	WebElement students_total;
	
	@FindBy (xpath = "//button[@id='saveTeacherBtn']")
	WebElement class_savebutt ;
	
	public void masterdataclass() {
		masterdata.click();
	}
	
	public void class_masterdata() {
		classes_master.click();
	}
	
	public void add_classes() {
		add_class.click();
	}
	
	public void classfields(String cnameng,String cnametel) {
		class_nameng.sendKeys(cnameng);
		class_name_tel.sendKeys(cnametel);
	}
	
	public void section_drops() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		section_namedrop1.click();
		section_namedrop2.click();
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public void academicyeardrop(String year) {
		Select dropdown = new Select(academicyear_dropdown);
		dropdown.selectByVisibleText(year);;
	}
	
	public void classfee(String feeclass) {
	 fee_class.sendKeys(feeclass);;
	}
	
	public void students_tot(String studentstota) {
		students_total.sendKeys(studentstota);;
	} 
	
	public void class_savebutton() {
		class_savebutt.click();
	}
	
	
	
}

