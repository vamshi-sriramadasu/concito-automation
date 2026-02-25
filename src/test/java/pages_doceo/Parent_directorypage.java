package pages_doceo;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import concito.Doceodirect;

public class Parent_directorypage extends Doceodirect {

	 protected WebDriver driver;
     protected WebDriverWait wait;
	    public Parent_directorypage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }


	    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
	    WebElement directory;

	    @FindBy(xpath = "//a[normalize-space()='Parents']")
	    WebElement parentdirect;
	    
	    @FindBy(xpath = "//button[@id='add-parent-btn']")
	    WebElement parentadd ;
	    
	    @FindBy(xpath = "//input[@placeholder='Father Name Eng']")
	    WebElement fathernameeng;
	    
	    @FindBy(xpath = "//input[@placeholder='Father Name Tel']")
	    WebElement fathernametel;

	    @FindBy(xpath = "//input[@placeholder='Mother Name Eng']")
	    WebElement mothernameeng ;

	    @FindBy(xpath = "//input[@placeholder='Mother Name Tel']")
	    WebElement mothernametel ;

	    @FindBy(xpath = "//input[@id='imageInputFather']")
	    WebElement fatherimage;
	    
	    @FindBy(xpath = "//div[contains(@class,'cropper-modal')]")
	    String fatherimagecropmode;
	    
	    @FindBy(xpath = "//button[@id='cropButtonFather']")
	    WebElement fatherimagecrop;
	    

	    @FindBy(xpath = "//input[@id='imageInputMother']")
	    WebElement motherimage ;
	    
	    @FindBy(xpath = "//button[@id='cropButtonMother']")
	    WebElement motherimagecrop;

	    @FindBy(xpath = "//input[@placeholder='Father Mobile']")
	    WebElement fathermobile ;

	    @FindBy(xpath = "//input[@placeholder='Father E-Mail']")
	    WebElement fatheremail;

	    @FindBy(xpath = "//input[@placeholder='Mother Mobile']")
	    WebElement mothermobile ;

	    @FindBy(xpath = "//input[@placeholder='Mother E-Mail']")
	    WebElement motheremail ;

	    @FindBy(xpath = "//input[@placeholder='Father Occupation']")
	    WebElement fatheroccupation ;

	    @FindBy(xpath = "//input[@placeholder='Mother Occupation']")
	    WebElement motheroccupation;

	    @FindBy(xpath = "//input[@placeholder='Guardian Name Eng']")
	    WebElement guardiannameeng ;

	    @FindBy(xpath = "//input[@placeholder='Guardian Name Tel']")
	    WebElement guardianametel ;

	    @FindBy(xpath = "//input[@placeholder='Guardian Mobile']")
	    WebElement guardianmobile ;

	    @FindBy(xpath = "//input[@placeholder='Address']")
	    WebElement address;

	    @FindBy(xpath = "//input[@placeholder='Pincode']")
	    WebElement pincode;

	    @FindBy(xpath = "//button[@id='saveTeacherBtn']")
	    WebElement savebutton ;
	    
	    public void directty() {
	    	directory.click();
	    }
	    
	    public void parentdrop() {
	    
	    	parentdirect.click();
	    	
	    }
	    
	    public void parentadd() {
	    	parentadd.click();
	    }
	    
	    public void parentregist(String fname,String fnamet,String mname,String mnamet) {
	    	
	    	fathernameeng.sendKeys(fname);
	    	fathernametel.sendKeys(fnamet);
	    	mothernameeng.sendKeys(mname);
	    	mothernametel.sendKeys(mnamet);
	    }
	    
	    public void parentregist1(String fpath) throws AWTException {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    wait.until(ExpectedConditions.visibilityOf(fatherimage));
    	    fatherimage.sendKeys(fpath);
    	    
//    	    WebElement cropModal = wait.until(ExpectedConditions
//    	            .visibilityOfElementLocated(By.xpath(fatherimagecropmode)));
//
//    	    cropModal.click();
//    	   fatherimagecrop.click();
//	    	
	    	
//	    	fatherimage.click();
//	    	
//	    	StringSelection filepathselection = new StringSelection(fpath);
//	    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepathselection, null);
//	    	
//	    	Robot rb = new Robot();
//	    	rb.keyPress(KeyEvent.VK_CONTROL);
//	    	rb.keyPress(KeyEvent.VK_V);
//	    	rb.keyRelease(KeyEvent.VK_V);
//	    	rb.keyRelease(KeyEvent.VK_CONTROL);
//	    	
//	    	rb.keyPress(KeyEvent.VK_ENTER);
//	    	rb.keyPress(KeyEvent.VK_ENTER);
//	    	    
	    	    fatherimagecrop.click();
	    	    
	    }
	    
	    public void parentregist2(String mpath) {
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	    wait.until(ExpectedConditions.visibilityOf(motherimage));
	    	    motherimage.sendKeys(mpath);
	    	   motherimagecrop.click();
	    }
	    
	    public void parentregist3(String fmno ) {
	    	fathermobile.sendKeys(fmno);
	    }
	    
	    public void parentregist4(String femail) {
	    	fatheremail.sendKeys(femail);
	    }
	    
	    public void parentregist5(String mmno ) {
	    	mothermobile.sendKeys(mmno);
	    }
	    
	    public void parentregist6(String memail) {
	    	motheremail.sendKeys(memail);
	    }

	    public void parentregihalf(String focc) {
	    	fatheroccupation.sendKeys(focc);
	    }
	    
	    public void parentregi1(String mocc) {
	    	motheroccupation.sendKeys(mocc);
	    }
	    
	    public void parentregi2(String gname ) {
	    	guardiannameeng.sendKeys(gname);
	    }
	    
	    public void parentregi3(String gnamaet ) {
	    	guardianametel.sendKeys(gnamaet);
	    }
	    
	    public void parentregi4(String gmno) {
	    	guardianmobile.sendKeys(gmno);
	    }
	    
	    public void parentregi5(String addres ) {
         address.sendKeys(addres);
        }
	    
	    public void parentregi6(String pinc ) {
	    	pincode.sendKeys(pinc);
	    }
	    
	    public void parentregi7() {
	    	savebutton.click();
	    }
}
