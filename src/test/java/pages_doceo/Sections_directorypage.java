package pages_doceo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sections_directorypage {

	protected WebDriver driver;
	
	public Sections_directorypage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[normalize-space()='Master Data']")
	WebElement masterdata;
	
	@FindBy (xpath = "//a[normalize-space()='Sections']")
	WebElement sections;
	
	@FindBy (xpath = "//button[@id='add-class-btn']")
	WebElement add_section;
	
	@FindBy (xpath = "//input[@placeholder='Name Eng']")
	WebElement section_name_eng;
	
	@FindBy (xpath = "//input[@placeholder='Name Tel']")
	WebElement section_name_tel ;
	
	@FindBy (xpath = "//a[normalize-space()='Sections']")
	WebElement section_savebut;
	
	public void masterdata() {
		masterdata.click();
	}
	
	public void section_master() {
		sections.click();
	}
	
	public void section_add() {
		add_section.click();
	}
	
	public void section_names(String snameng,String snametel) {
		section_name_eng.sendKeys(snameng);
		section_name_tel.sendKeys(snameng);
	}
	
	public void section_save() {
		section_savebut.click();
	}
}

//}

