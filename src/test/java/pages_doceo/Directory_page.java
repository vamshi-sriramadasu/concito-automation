//
//
//
//
//
//package pages_doceo;
//
//import java.awt.AWTException;
//import java.time.Duration;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import concito.Doceodirect;
//
//public class Directory_page extends Doceodirect {
//
//    protected WebDriver driver;
//
//    public Directory_page(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
//    WebElement directory;
//
//    @FindBy(xpath = "//a[@href='https://control.doceo.in/register/students']")
//    WebElement student;
//
//    @FindBy(xpath = "//button[@id='add-student-btn']")
//    WebElement student_add;
//
//    @FindBy(xpath = "//select[@placeholder='Parent Name']")
//    WebElement parent_name_dropdown;
//
//    @FindBy(xpath = "//div[@class='col-xl-3 col-lg-6 col-12 form-group']//input[@placeholder='Name Eng']")
//    WebElement name_eng;
//
//    @FindBy(xpath = "(//input[@placeholder='Name Tel'])[1]")
//    WebElement name_tel;
//
//    @FindBy(xpath = "(//select[@placeholder='Academic Year'])[1]")
//    WebElement academic_year_dropdown;
//
//    @FindBy(xpath = "(//select[@placeholder='Class Name'])[1]")
//    WebElement class_dropdown;
//
//    @FindBy(xpath = "(//select[@id='section_id'])[1]")
//    WebElement section_dropdown;
//
//    @FindBy(xpath = "(//input[@id='tution_fee'])[1]")
//    WebElement tution_fee;
//
//    @FindBy(xpath = "//input[@placeholder='Discount']")
//    WebElement discount;
//
//    @FindBy(xpath = "//option[contains(text(),'EXAM FEE(₹ 5000)')]")
//    WebElement extra_fee;
//
//    @FindBy(xpath = "//select[@id='reference']")
//    WebElement reference_dropdown;
//
//    @FindBy(xpath = "//select[@placeholder='Reference Type']")
//    WebElement referencetype_dropdown;
//
//    @FindBy(xpath = "//input[@id='final_amount']")
//    WebElement referenceamount;
//
//    @FindBy(xpath = "//input[@placeholder='Total Amount']")
//    WebElement total_amount;
//
//    // ----------------- DOJ -----------------
//    @FindBy(xpath = "//input[@name='doj']")
//    public WebElement dojtik;
//
//    // ----------------- DOB -----------------
//    @FindBy(xpath = "//input[@name='dob']")
//    public WebElement dob1;
//
//    
//    @FindBy(xpath = "//input[@placeholder='Blood Group']")
//    WebElement blood_group;
//
//    @FindBy(xpath = "//select[@name='gender']")
//    WebElement gender;
//
//    @FindBy(xpath = "//input[@placeholder='Caste Eng']")
//    WebElement caste_eng;
//
//    @FindBy(xpath = "//input[@placeholder='Caste Tel']")
//    WebElement caste_tel;
//
//    @FindBy(xpath = "//input[@placeholder='Religion Eng']")
//    WebElement religion_eng;
//
//    @FindBy(xpath = "//input[@placeholder='Religion Tel']")
//    WebElement religion_tel;
//
//    @FindBy(xpath = "//input[@placeholder='Nationality Eng']")
//    WebElement nation_eng;
//
//    @FindBy(xpath = "//input[@placeholder='Nationality Tel']")
//    WebElement nation_tel;
//
//    @FindBy(xpath = "//select[@placeholder='Bus Name']")
//    WebElement bus_dropdown;
//
//    @FindBy(xpath = "//input[@placeholder='Authorized Person Eng']")
//    WebElement authorized_person_eng;
//
//    @FindBy(xpath = "//input[@placeholder='Authorized Person Tel']")
//    WebElement authorized_person_tel;
//
//    @FindBy(xpath = "//input[@placeholder='Relation Eng']")
//    WebElement authorised_person_relation_eng;
//
//    @FindBy(xpath = "//input[@placeholder='Relation Tel']")
//    WebElement authorised_person_relation_tel;
//
//    @FindBy(xpath = "//input[@placeholder='Relation Mobile']")
//    WebElement relation_mobile;
//
//    @FindBy(xpath = "(//input[@type='file'])[1]")
//    WebElement student_image;
//    
//    @FindBy(xpath = "//button[@id='cropButtonFather']")
//    WebElement student_imagecrop;
//
//    @FindBy(xpath = "(//input[@type='file'])[2]")
//    WebElement authorised_person_image;
//    
//    @FindBy(xpath = "//button[@id='cropButtonMother']")
//    WebElement authimagecrop;
//
//    @FindBy(xpath = "//div[@class='ui-datepicker-title']")
//    WebElement datepickerTitle;
//    
//    @FindBy(xpath = "//button[@id='saveTeacherBtn']")
//    WebElement stusavebutt;
//    
//
//    @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
//    WebElement nextButton;
//
//    @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
//    WebElement prevButton;
//
//    // ------------------ Existing Methods ------------------ //
//
//    public void directory_student() {
//        directory.click();
//    }
//
//    public void studentdrop() {
//        student.click();
//    }
//
//    public void studentaddbutt() {
//        student_add.click();
//    }
//
//    public void register_student(String name, String namet) {
//        new Select(parent_name_dropdown).selectByIndex(2);
//        name_eng.sendKeys(name);
//        name_tel.sendKeys(namet);
//        new Select(academic_year_dropdown).selectByIndex(1);
//        new Select(class_dropdown).selectByIndex(1);
//    }
//
//    public void afterclassdrop(String tutionfee, String discountfee) {
//        new Select(section_dropdown).selectByIndex(1);;
//        tution_fee.sendKeys(tutionfee);
//        discount.sendKeys(discountfee);
//        extra_fee.click();
//        WebElement refr = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(reference_dropdown));
//        new Select(refr).selectByIndex(1);
//    }
//
//    public void aftereference( String amount, String totalamount) {
//        WebElement refr2 = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(referencetype_dropdown));
//        new Select(refr2).selectByIndex(1);
//
//        WebElement refr3 = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(referenceamount));
//        refr3.clear();
//        refr3.sendKeys(amount);
//        total_amount.sendKeys(totalamount);
//    }
//
//    // JavaScriptExecutor method to set date value in input
//    public void selectdatebyjs(WebDriver driver, WebElement element, String dateVal) {
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].setAttribute('value', '"+dateVal+"');", element);
//    }
//    
//    public void selectdatebyjsdob(WebDriver driver, WebElement element1, String dateVal1) {
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].setAttribute('value', '"+dateVal1+"');", element1);
//    }
//    
//    public void blood(String bloodgr) {
//    	blood_group.sendKeys(bloodgr);
//    }
//    
//    public void genderdrop(String genderselection) {
//    	new Select(gender).selectByVisibleText(genderselection);
//    }
//    
//    public void castesel(String casteeng) {
//    	caste_eng.sendKeys(casteeng);
//    }
//    
//    public void casteselt(String castetelugu) {
//    	caste_tel.sendKeys(castetelugu);
//    }
//    
//    public void religionengsel(String religioneng) {
//    	religion_eng.sendKeys(religioneng);
//    }
//    
//    public void religiontelugusel(String religionte) {
//    	religion_tel.sendKeys(religionte);
//    }
//    
//    public void nationalityeng(String nationalityeng) {
//    	nation_eng.sendKeys(nationalityeng);
//    }
//    
//    public void nationality(String nationalitytel) {
//    	nation_tel.sendKeys(nationalitytel);
//    }
//    
//    public void busdrop() {
//    	new Select(bus_dropdown).selectByIndex(1);
//    }
//    
//    public void authorisedperson(String authorisedeng) {
//    	authorized_person_eng.sendKeys(authorisedeng);
//    }
//    
//    public void authorisedpersontel(String authorisedtel) {
//    	authorized_person_tel.sendKeys(authorisedtel);
//    }
//    
//    public void relationauthor(String relationauthoreng) {
//    	authorised_person_relation_eng.sendKeys(relationauthoreng);
//    }
//    
//    public void relationauthtel(String relationauthortel,String relationmobile) {
//    	authorised_person_relation_tel.sendKeys(relationauthortel);
//    	relation_mobile.sendKeys(relationmobile);
//    }
//    
//    
//    public void studentpic(String spath) throws AWTException{
//    	
////    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//// 	    wait.until(ExpectedConditions.visibilityOf(student_image));
////    	student_image.sendKeys(spath);
////    	
////    	 student_imagecrop.click();
//    	
//    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	    wait.until(ExpectedConditions.elementToBeClickable(student_image));
//
//    	
////    	JavascriptExecutor js = (JavascriptExecutor) driver;
////    	js.executeScript("arguments[0].removeAttribute('hidden');", student_image);
////    	
//    	    
//    	    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", student_image);
//    	    
//    	    
//    	student_image.sendKeys(spath);
//    	
//    	wait.until(ExpectedConditions.elementToBeClickable(student_imagecrop));
//    	
//    	student_imagecrop.click();
//
//	    	   
//	    }
//    
//    
//    public void authpic(String apath) throws AWTException {
////    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////  	    wait.until(ExpectedConditions.visibilityOf(authorised_person_image));
////    	authorised_person_image.sendKeys(apath);
////    	authimagecrop.click();
//    	
//    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	    wait.until(ExpectedConditions.elementToBeClickable(authorised_person_image));
//    	
////    	JavascriptExecutor js = (JavascriptExecutor) driver;
////    	js.executeScript("arguments[0].removeAttribute('hidden');", authorised_person_image);
////    	
//    	
//    	    ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", authorised_person_image);
//    	        
//    	    
//    	authorised_person_image.sendKeys(apath);
//    	
//    	wait.until(ExpectedConditions.elementToBeClickable(authimagecrop));
//    	
//    	authimagecrop.click();
//
//    	
//    }
//    
//    public void studentsavebutton() {
//    stusavebutt.click();
//    }
//}

package pages_doceo;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import concito.Doceodirect;

public class Directory_page extends Doceodirect {

    public Directory_page() {
        PageFactory.initElements(getDriver(), this); 
    }

    // --- WebElements ---
    @FindBy(xpath = "(//a[@class='nav-link'])[2]") WebElement directory;
    @FindBy(xpath = "//a[@href='https://control.doceo.in/register/students']") WebElement student;
    @FindBy(xpath = "//button[@id='add-student-btn']") WebElement student_add;
    @FindBy(xpath = "//select[@placeholder='Parent Name']") WebElement parent_name_dropdown;
    @FindBy(xpath = "//div[@class='col-xl-3 col-lg-6 col-12 form-group']//input[@placeholder='Name Eng']") WebElement name_eng;
    @FindBy(xpath = "(//input[@placeholder='Name Tel'])[1]") WebElement name_tel;
    @FindBy(xpath = "(//select[@placeholder='Academic Year'])[1]") WebElement academic_year_dropdown;
    @FindBy(xpath = "(//select[@placeholder='Class Name'])[1]") WebElement class_dropdown;
    @FindBy(xpath = "(//select[@id='section_id'])[1]") WebElement section_dropdown;
    @FindBy(xpath = "(//input[@id='tution_fee'])[1]") WebElement tution_fee;
    @FindBy(xpath = "//input[@placeholder='Discount']") WebElement discount;
    @FindBy(xpath = "//option[contains(text(),'EXAM FEE(₹ 5000)')]") WebElement extra_fee;
    @FindBy(xpath = "//select[@id='reference']") WebElement reference_dropdown;
    @FindBy(xpath = "//select[@placeholder='Reference Type']") WebElement referencetype_dropdown;
    @FindBy(xpath = "//input[@id='final_amount']") WebElement referenceamount;
    @FindBy(xpath = "//input[@placeholder='Total Amount']") WebElement total_amount;
    @FindBy(xpath = "//input[@name='doj']") public WebElement dojtik;
    @FindBy(xpath = "//input[@name='dob']") public WebElement dob1;
    @FindBy(xpath = "//input[@placeholder='Blood Group']") WebElement blood_group;
    @FindBy(xpath = "//select[@name='gender']") WebElement gender;
    @FindBy(xpath = "//input[@placeholder='Caste Eng']") WebElement caste_eng;
    @FindBy(xpath = "//input[@placeholder='Caste Tel']") WebElement caste_tel;
    @FindBy(xpath = "//input[@placeholder='Religion Eng']") WebElement religion_eng;
    @FindBy(xpath = "//input[@placeholder='Religion Tel']") WebElement religion_tel;
    @FindBy(xpath = "//input[@placeholder='Nationality Eng']") WebElement nation_eng;
    @FindBy(xpath = "//input[@placeholder='Nationality Tel']") WebElement nation_tel;
    @FindBy(xpath = "//select[@placeholder='Bus Name']") WebElement bus_dropdown;
    @FindBy(xpath = "//input[@placeholder='Authorized Person Eng']") WebElement authorized_person_eng;
    @FindBy(xpath = "//input[@placeholder='Authorized Person Tel']") WebElement authorized_person_tel;
    @FindBy(xpath = "//input[@placeholder='Relation Eng']") WebElement authorised_person_relation_eng;
    @FindBy(xpath = "//input[@placeholder='Relation Tel']") WebElement authorised_person_relation_tel;
    @FindBy(xpath = "//input[@placeholder='Relation Mobile']") WebElement relation_mobile;
    @FindBy(xpath = "(//input[@type='file'])[1]") WebElement student_image;
    @FindBy(xpath = "//button[@id='cropButtonFather']") WebElement student_imagecrop;
    @FindBy(xpath = "(//input[@type='file'])[2]") WebElement authorised_person_image;
    @FindBy(xpath = "//button[@id='cropButtonMother']") WebElement authimagecrop;
    @FindBy(xpath = "//button[@id='saveTeacherBtn']") WebElement stusavebutt;

    // --- Methods ---
    public void directory_student() { directory.click(); }
    public void studentdrop() { student.click(); }
    public void studentaddbutt() { student_add.click(); }

    public void register_student(String name, String namet) {
        new Select(parent_name_dropdown).selectByIndex(2);
        name_eng.sendKeys(name);
        name_tel.sendKeys(namet);
        new Select(academic_year_dropdown).selectByIndex(1);
        new Select(class_dropdown).selectByIndex(1);
    }

    public void afterclassdrop(String tutionfee, String discountfee) {
        new Select(section_dropdown).selectByIndex(1);
        tution_fee.sendKeys(tutionfee);
        discount.sendKeys(discountfee);
        extra_fee.click();
        WebElement refr = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(reference_dropdown));
        new Select(refr).selectByIndex(1);
    }

    public void aftereference(String amount, String totalamount) {
        WebElement refr2 = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(referencetype_dropdown));
        new Select(refr2).selectByIndex(1);

        WebElement refr3 = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(referenceamount));
        refr3.clear();
        refr3.sendKeys(amount);
        total_amount.sendKeys(totalamount);
    }

    public void selectdatebyjs(WebElement element, String dateVal) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('value', '"+dateVal+"');", element);
    }

    public void selectdatebyjsdob(WebElement element, String dateVal) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].setAttribute('value', '"+dateVal+"');", element);
    }

    public void blood(String bloodgr) { blood_group.sendKeys(bloodgr); }
    public void genderdrop(String genderselection) { new Select(gender).selectByVisibleText(genderselection); }
    public void castesel(String casteeng) { caste_eng.sendKeys(casteeng); }
    public void casteselt(String castetelugu) { caste_tel.sendKeys(castetelugu); }
    public void religionengsel(String religioneng) { religion_eng.sendKeys(religioneng); }
    public void religiontelugusel(String religionte) { religion_tel.sendKeys(religionte); }
    public void nationalityeng(String nationalityeng) { nation_eng.sendKeys(nationalityeng); }
    public void nationality(String nationalitytel) { nation_tel.sendKeys(nationalitytel); }
    public void busdrop() { new Select(bus_dropdown).selectByIndex(1); }
    public void authorisedperson(String authorisedeng) { authorized_person_eng.sendKeys(authorisedeng); }
    public void authorisedpersontel(String authorisedtel) { authorized_person_tel.sendKeys(authorisedtel); }
    public void relationauthor(String relationauthoreng) { authorised_person_relation_eng.sendKeys(relationauthoreng); }
    public void relationauthtel(String relationauthortel, String relationmobileVal) {
        authorised_person_relation_tel.sendKeys(relationauthortel);
        relation_mobile.sendKeys(relationmobileVal);
    }

    public void studentpic(String spath) throws AWTException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(student_image));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.display='block';", student_image);
        student_image.sendKeys(spath);
        wait.until(ExpectedConditions.elementToBeClickable(student_imagecrop));
        student_imagecrop.click();
    }

    public void authpic(String apath) throws AWTException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(authorised_person_image));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.display='block';", authorised_person_image);
        authorised_person_image.sendKeys(apath);
        wait.until(ExpectedConditions.elementToBeClickable(authimagecrop));
        authimagecrop.click();
    }

    public void studentsavebutton() { 
    	stusavebutt.click(); }
}

