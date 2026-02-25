//package pages_doceo;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class Academicyear {
//
//	 protected WebDriver driver;
//     protected WebDriverWait wait;
//	    public Academicyear (WebDriver driver) {
//	        this.driver = driver;
//	        PageFactory.initElements(driver, this);
//	    }
//	    
//	    @FindBy (xpath = "//span[normalize-space()='Master Data']")
//		WebElement masterdata;
//
//	    @FindBy(xpath = "//a[normalize-space()='Academic Years']")
//	    WebElement academic_year;
//
//	    @FindBy(xpath = "(//button[normalize-space()='Add Academic Year'])[1]")
//	    WebElement add_academicyear;
//	    
//	    @FindBy(xpath = "//input[@placeholder='Academic Year']")
//	    WebElement academicyear_name ;
//	    
//	    @FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
//	    WebElement academicyear_savebutt;
//	    
//	    public void masterdata() {
//			masterdata.click();
//		}
//		
//		public void academic_master() {
//	            academic_year.click();
//		}
//		
//		public void academic_add() {
//			add_academicyear.click();
//		}
//		
//		public void academic_name(String academicyearname) {
//                 academicyear_name.sendKeys(academicyearname);
//			
//		}
//		
//		public void academic_save() {
//			academicyear_savebutt.click();
//		}
//
//}

package pages_doceo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Academicyear {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Academicyear(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Master Data']")
    private WebElement masterdata;

    @FindBy(xpath = "//a[normalize-space()='Academic Years']")
    private WebElement academic_year;

    @FindBy(xpath = "(//button[normalize-space()='Add Academic Year'])[1]")
    private WebElement add_academicyear;

    @FindBy(xpath = "//input[@placeholder='Academic Year']")
    private WebElement academicyear_name;

    @FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
    private WebElement academicyear_savebutt;

    // Click Master Data
    public void masterdata() {
        wait.until(ExpectedConditions.elementToBeClickable(masterdata)).click();
    }

    // Click Academic Years
    public void academic_master() {
        wait.until(ExpectedConditions.elementToBeClickable(academic_year)).click();
    }

    // Click Add Academic Year
    public void academic_add() {
        wait.until(ExpectedConditions.elementToBeClickable(add_academicyear)).click();
    }

    // Enter Academic Year Name
    public void academic_name(String academicyearname) {
        wait.until(ExpectedConditions.visibilityOf(academicyear_name)).sendKeys(academicyearname);
    }

    // Click Save
    public void academic_save() {
        wait.until(ExpectedConditions.elementToBeClickable(academicyear_savebutt)).click();
    }

    // Getter for Save Button (optional, if needed in test)
    public WebElement getSaveButton() {
        return academicyear_savebutt;
    }
}
