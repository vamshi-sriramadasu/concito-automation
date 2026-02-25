//package pages_doceo;
//
//public class Scrap {
//
//	
//
////  public void aftertotalamount( String bloodgroup, String casteng, String castelu,
////                               String religioneng, String religiontel, String nationeng, String nationtel) {
////      //selectDateOfJoining(doj);
////      //selectDateOfBirth(dob);
////
////      blood_group.sendKeys(bloodgroup);
////      new Select(gender).selectByIndex(1);
////      caste_eng.sendKeys(casteng);
////      caste_tel.sendKeys(castelu);
////      religion_eng.sendKeys(religioneng);
////      religion_tel.sendKeys(religiontel);
////      nation_eng.sendKeys(nationeng);
////      nation_tel.sendKeys(nationtel);
////      new Select(bus_dropdown).selectByIndex(1);
////  }
////
////  public void afterbusdrop(String authnameengl, String authnametelu, String authrelationeng,
////                           String authrelationtel, String rel_mobileno, String studpath, String authpath) {
////      authorized_person_eng.sendKeys(authnameengl);
////      authorized_person_tel.sendKeys(authnametelu);
////      authorised_person_relation_eng.sendKeys(authrelationeng);
////      authorised_person_relation_tel.sendKeys(authrelationtel);
////      relation_mobile.sendKeys(rel_mobileno);
////      student_image.sendKeys(studpath);
////      authorised_person_image.sendKeys(authpath);
////  }
////
////  // ------------------ Calendar Widget Methods ------------------ //
////
////  private void selectDateCustom(WebElement dateField, int year, int month, int day) {
////      dateField.click();
////      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////
////      WebElement calendarPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
////              By.xpath("//div[contains(@class,'datepicker')]")));
////
////      while (true) {
////          WebElement monthYear = calendarPopup.findElement(By.xpath(".//th[@class='datepicker-switch']"));
////          String displayed = monthYear.getText(); // e.g., "September, 2025"
////          String[] parts = displayed.replace(",", "").split(" ");
////          String displayedMonth = parts[0];
////          int displayedYear = Integer.parseInt(parts[1]);
////
////          int displayedMonthIndex = monthStringToInt(displayedMonth);
////
////          if (displayedYear == year && displayedMonthIndex == month) {
////              break;
////          } else if (displayedYear > year || (displayedYear == year && displayedMonthIndex > month)) {
////              calendarPopup.findElement(By.xpath(".//th[@class='prev']")).click();
////          } else {
////              calendarPopup.findElement(By.xpath(".//th[@class='next']")).click();
////          }
////
////          calendarPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
////                  By.xpath("//div[contains(@class,'datepicker')]")));
////      }
////
////      WebElement dayCell = wait.until(ExpectedConditions.elementToBeClickable(
////              calendarPopup.findElement(By.xpath(".//td[not(contains(@class,'old')) and not(contains(@class,'new')) and text()='" + day + "']"))));
////      dayCell.click();
////  }
////
////  private int monthStringToInt(String month) {
////      switch (month.toLowerCase()) {
////          case "january": return 1;
////          case "february": return 2;
////          case "march": return 3;
////          case "april": return 4;
////          case "may": return 5;
////          case "june": return 6;
////          case "july": return 7;
////          case "august": return 8;
////          case "september": return 9;
////          case "october": return 10;
////          case "november": return 11;
////          case "december": return 12;
////          default: return 0;
////      }
////  }
////
////  public void selectDateOfJoining(int year, int month, int day) {
////      selectDateCustom(date_of_joining_selection, year, month, day);
////  }
////
////  public void selectDateOfJoining(String dateStr) {
////      String[] parts = dateStr.split("-");
////      selectDateCustom(date_of_joining_selection,
////              Integer.parseInt(parts[0]),
////              Integer.parseInt(parts[1]),
////              Integer.parseInt(parts[2]));
////  }
////
////  public void selectDateOfBirth(int year, int month, int day) {
////      selectDateCustom(date_of_birth_selection, year, month, day);
////  }
////
////  public void selectDateOfBirth(String dateStr) {
////      String[] parts = dateStr.split("-");
////      selectDateCustom(date_of_birth_selection,
////              Integer.parseInt(parts[0]),
////              Integer.parseInt(parts[1]),
////              Integer.parseInt(parts[2]));
////  }
////}
//}
//
//
//package pages_doceo;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
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
//    @FindBy(xpath = "//input[@name='doj']")
//    WebElement date_of_joining_selection;
//    
//
//    @FindBy(xpath = "//select[contains(@class,'ui-datepicker-month')]")
//    WebElement doj_month;
//    
//
//    @FindBy(xpath = "//select[contains(@class,'ui-datepicker-year')]")
//    WebElement doj_year;
//    
//    @FindBy(xpath = "//table[contains(@class,'ui-datepicker-calendar')]//a[text()='18']")
//    WebElement doj_day;
//    
//
//    @FindBy(xpath = "//input[@name='dob']")
//    WebElement date_of_birth_selection;
//    
//    @FindBy(xpath = "")
//    WebElement dob_month;
//
//    @FindBy(xpath = "")
//    WebElement dob_year;
//
//    @FindBy(xpath = "")
//    WebElement dob_day;
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
//    @FindBy(xpath = "//input[@id='imageInputFather']")
//    WebElement student_image;
//
//    @FindBy(xpath = "//input[@id='imageInputMother']")
//    WebElement authorised_person_image;
//
//    // ------------------ Existing Methods ------------------ //
//
//    public void directory_student() { directory.click(); }
//    public void studentdrop() { student.click(); }
//    public void studentaddbutt() { student_add.click(); }
//
//    public void register_student(String name, String namet) {
//        new Select(parent_name_dropdown).selectByIndex(1);
//        name_eng.sendKeys(name);
//        name_tel.sendKeys(namet);
//        new Select(academic_year_dropdown).selectByIndex(1);
//        new Select(class_dropdown).selectByIndex(1);
//    }
//
//    public void afterclassdrop(String tutionfee, String discountfee) {
//        new Select(section_dropdown).selectByIndex(1);
//        tution_fee.sendKeys(tutionfee);
//        discount.sendKeys(discountfee);
//        extra_fee.click();
//        WebElement refr = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(reference_dropdown));
//        new Select(refr).selectByIndex(1);
//    }
//
//    public void aftereference(String amount, String totalamount) {
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
//      public void doj() {
//    	  
//    	  Select dd =new Select(date_of_joining_selection);
//    	  
//      }
//      
//      }


////package pages_doceo;
////
////import java.text.SimpleDateFormat;
////import java.time.Duration;
////import java.util.Calendar;
////import java.util.Date;
////
////import org.openqa.selenium.By;
////import org.openqa.selenium.WebDriver;
////import org.openqa.selenium.WebElement;
////import org.openqa.selenium.support.FindBy;
////import org.openqa.selenium.support.PageFactory;
////import org.openqa.selenium.support.ui.ExpectedConditions;
////import org.openqa.selenium.support.ui.Select;
////import org.openqa.selenium.support.ui.WebDriverWait;
////
////import concito.Doceodirect;
////
////public class Directory_page extends Doceodirect {
////
////    protected WebDriver driver;
////
////    public Directory_page(WebDriver driver) {
////        this.driver = driver;
////        PageFactory.initElements(driver, this);
////    }
////
////    @FindBy(xpath = "(//a[@class='nav-link'])[2]")
////    WebElement directory;
////
////    @FindBy(xpath = "//a[@href='https://control.doceo.in/register/students']")
////    WebElement student;
////
////    @FindBy(xpath = "//button[@id='add-student-btn']")
////    WebElement student_add;
////
////    @FindBy(xpath = "//select[@placeholder='Parent Name']")
////    WebElement parent_name_dropdown;
////
////    @FindBy(xpath = "//div[@class='col-xl-3 col-lg-6 col-12 form-group']//input[@placeholder='Name Eng']")
////    WebElement name_eng;
////
////    @FindBy(xpath = "(//input[@placeholder='Name Tel'])[1]")
////    WebElement name_tel;
////
////    @FindBy(xpath = "(//select[@placeholder='Academic Year'])[1]")
////    WebElement academic_year_dropdown;
////
////    @FindBy(xpath = "(//select[@placeholder='Class Name'])[1]")
////    WebElement class_dropdown;
////
////    @FindBy(xpath = "(//select[@id='section_id'])[1]")
////    WebElement section_dropdown;
////
////    @FindBy(xpath = "(//input[@id='tution_fee'])[1]")
////    WebElement tution_fee;
////
////    @FindBy(xpath = "//input[@placeholder='Discount']")
////    WebElement discount;
////
////    @FindBy(xpath = "//option[contains(text(),'EXAM FEE(₹ 5000)')]")
////    WebElement extra_fee;
////
////    @FindBy(xpath = "//select[@id='reference']")
////    WebElement reference_dropdown;
////
////    @FindBy(xpath = "//select[@placeholder='Reference Type']")
////    WebElement referencetype_dropdown;
////
////    @FindBy(xpath = "//input[@id='final_amount']")
////    WebElement referenceamount;
////
////    @FindBy(xpath = "//input[@placeholder='Total Amount']")
////    WebElement total_amount;
////
////    // ----------------- DOJ -----------------
////    @FindBy(xpath = "//input[@name='doj']")
////    WebElement dojtik;
////
////    @FindBy(xpath = "//select[contains(@class,'ui-datepicker-month')]")
////    WebElement doj_month;
////
////    @FindBy(xpath = "//select[contains(@class,'ui-datepicker-year')]")   //(//div[@class='datepicker--nav-title'])[1]
////    WebElement doj_year;
////    
////    @FindBy(xpath = "(//div[@class='datepicker--nav-title'])[2]")
////    WebElement doj1;
////
////    // ----------------- DOB -----------------
////    @FindBy(xpath = "//input[@name='dob']")
////    WebElement dob1;
////
//////    @FindBy(xpath = "//select[contains(@class,'ui-datepicker-month')]")
//////    WebElement dob_month;
//////
//////    @FindBy(xpath = "//select[contains(@class,'ui-datepicker-year')]")
//////    WebElement dob_year;
////
////    // ----------------- Other Fields -----------------
////    @FindBy(xpath = "//input[@placeholder='Blood Group']")
////    WebElement blood_group;
////
////    @FindBy(xpath = "//select[@name='gender']")
////    WebElement gender;
////
////    @FindBy(xpath = "//input[@placeholder='Caste Eng']")
////    WebElement caste_eng;
////
////    @FindBy(xpath = "//input[@placeholder='Caste Tel']")
////    WebElement caste_tel;
////
////    @FindBy(xpath = "//input[@placeholder='Religion Eng']")
////    WebElement religion_eng;
////
////    @FindBy(xpath = "//input[@placeholder='Religion Tel']")
////    WebElement religion_tel;
////
////    @FindBy(xpath = "//input[@placeholder='Nationality Eng']")
////    WebElement nation_eng;
////
////    @FindBy(xpath = "//input[@placeholder='Nationality Tel']")
////    WebElement nation_tel;
////
////    @FindBy(xpath = "//select[@placeholder='Bus Name']")
////    WebElement bus_dropdown;
////
////    @FindBy(xpath = "//input[@placeholder='Authorized Person Eng']")
////    WebElement authorized_person_eng;
////
////    @FindBy(xpath = "//input[@placeholder='Authorized Person Tel']")
////    WebElement authorized_person_tel;
////
////    @FindBy(xpath = "//input[@placeholder='Relation Eng']")
////    WebElement authorised_person_relation_eng;
////
////    @FindBy(xpath = "//input[@placeholder='Relation Tel']")
////    WebElement authorised_person_relation_tel;
////
////    @FindBy(xpath = "//input[@placeholder='Relation Mobile']")
////    WebElement relation_mobile;
////
////    @FindBy(xpath = "//input[@id='imageInputFather']")
////    WebElement student_image;
////
////    @FindBy(xpath = "//input[@id='imageInputMother']")
////    WebElement authorised_person_image;
////    
////    @FindBy(xpath = "//div[@class='ui-datepicker-title']")
////    WebElement datepickerTitle;
////
////    @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
////    WebElement nextButton;
////
////    @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
////    WebElement prevButton;
////    
////
////    // ------------------ Existing Methods ------------------ //
////
////    public void directory_student() {
////        directory.click();
////    }
////
////    public void studentdrop() {
////        student.click();
////    }
////
////    public void studentaddbutt() {
////        student_add.click();
////    }
////
////    public void register_student(String name, String namet) {
////        new Select(parent_name_dropdown).selectByIndex(1);
////        name_eng.sendKeys(name);
////        name_tel.sendKeys(namet);
////        new Select(academic_year_dropdown).selectByIndex(1);
////        new Select(class_dropdown).selectByIndex(1);
////    }
////
////    public void afterclassdrop(String tutionfee, String discountfee) {
////        new Select(section_dropdown).selectByIndex(1);
////        tution_fee.sendKeys(tutionfee);
////        discount.sendKeys(discountfee);
////        extra_fee.click();
////        WebElement refr = new WebDriverWait(driver, Duration.ofSeconds(10))
////                .until(ExpectedConditions.elementToBeClickable(reference_dropdown));
////        new Select(refr).selectByIndex(1);
////    }
////
////    public void aftereference(String amount, String totalamount) {
////        WebElement refr2 = new WebDriverWait(driver, Duration.ofSeconds(10))
////                .until(ExpectedConditions.elementToBeClickable(referencetype_dropdown));
////        new Select(refr2).selectByIndex(1);
////
////        WebElement refr3 = new WebDriverWait(driver, Duration.ofSeconds(10))
////                .until(ExpectedConditions.elementToBeClickable(referenceamount));
////        refr3.clear();
////        refr3.sendKeys(amount);
////        total_amount.sendKeys(totalamount);
////    }
////
//////    public void doj() throws Exception {
//////    	
//////    	 
//////    	dojtik.click();
//////    	
//////    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//////    	
//////    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datepickers-container")));
//////    	
////////    	String cmonth = driver.findElement(By.className("datepicker--nav-title")).getText();
////////    	
////////    	while (cmonth.equals(tdate)) {
////////    		
////////    		driver.findElement(By.className("datepicker--nav-action")).click();
////////    		
////////    	cmonth = driver.findElement(By.className("datepicker--nav-title")).getText();
////////    		
////////    	}
////////		
//////    	WebElement dayelement = driver.findElement(By.xpath("(//div[@data-month='8'])[1]"));
//////    	
//////    	dayelement.click();
//////			
//////		}
//////    public void dob() {
//////    	
//////    	dob1.click();
//////    	
//////WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//////    	
//////    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='datepickers-container']")));
//////    	
//////WebElement dayelement1 = driver.findElement(By.xpath("(//div[@data-month='8'])[4]"));
//////    	dayelement1.click();
//////    	
//////    }
//////    	
////    	
////    
////    public void selectDate(WebElement dateField, String day, String month, String year) {
////        
////        dateField.click();
////
////    }
////
////    	
////    }
////
////    
////    
////   
//
//
//
//
//
//package pages_doceo;
//
//import java.security.KeyStore.Entry.Attribute;
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.openqa.selenium.By;
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
//    // ----------------- Other Fields -----------------
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
//    @FindBy(xpath = "//input[@id='imageInputFather']")
//    WebElement student_image;
//
//    @FindBy(xpath = "//input[@id='imageInputMother']")
//    WebElement authorised_person_image;
//
//    @FindBy(xpath = "//div[@class='ui-datepicker-title']")
//    WebElement datepickerTitle;
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
//        new Select(parent_name_dropdown).selectByIndex(1);
//        name_eng.sendKeys(name);
//        name_tel.sendKeys(namet);
//        new Select(academic_year_dropdown).selectByIndex(1);
//        new Select(class_dropdown).selectByIndex(1);
//    }
//
//    public void afterclassdrop(String tutionfee, String discountfee) {
//        new Select(section_dropdown).selectByIndex(1);
//        tution_fee.sendKeys(tutionfee);
//        discount.sendKeys(discountfee);
//        extra_fee.click();
//        WebElement refr = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(reference_dropdown));
//        new Select(refr).selectByIndex(1);
//    }
//
//    public void aftereference(String amount, String totalamount) {
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
////    // ------------------ Smart Date Picker Method ------------------ //
////    public void selectDate(WebElement dateField, String day, String month, String year) {
////        // Step 1: Open date picker
////        dateField.click();
////
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='datepicker -bottom-left- -from-bottom-'])[1]")));
////
////        // Step 2: Loop until the correct month & year appear
////        while (true) {
////            String currentTitle = driver.findElement(By.xpath("//div[contains(@class,'datepicker--nav-title')]")).getText();
////            // Example: "September, 2025"
////
////            if (currentTitle.equals(month + ", " + year)) {
////                break; // correct month/year reached
////            } else {
////                String[] parts = currentTitle.replace(",", "").split(" ");
////                String currentMonth = parts[0].trim();
////                int currentYear = Integer.parseInt(parts[1].trim());
////
////                if (currentYear > Integer.parseInt(year) ||
////                    (currentYear == Integer.parseInt(year) && monthNumber(currentMonth) > monthNumber(month))) {
////                    driver.findElement(By.xpath("//input[@placeholder='dd/mm/yyyy']")).click(); // Prev
////                } else {
////                    driver.findElement(By.xpath("//div[contains(@class,'datepicker-nav-action') and @data-action='next']")).click(); // Next
////                }
////            }
////        }
////
////        // Step 3: Click the day
////        WebElement dayElement = driver.findElement(By.xpath("//div[contains(@class,'datepicker--cell-day') and text()='" + day + "']"));
////        dayElement.click();
////    }
////
////    // Helper function
////    private int monthNumber(String monthName) {
////        Map<String, Integer> months = new HashMap<>();
////        months.put("January", 1); months.put("February", 2); months.put("March", 3);
////        months.put("April", 4); months.put("May", 5); months.put("June", 6);
////        months.put("July", 7); months.put("August", 8); months.put("September", 9);
////        months.put("October", 10); months.put("November", 11); months.put("December", 12);
////        return months.get(monthName);
////    }
//
////    
////    public void selectdate() {
////    	
////    	dojtik.click();
////    	
////    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////    	
////    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='datepicker -bottom-left- -from-bottom-'])[1]")));
////    	
////    	String amy = driver.findElement(By.id("datepickers-container")).getText();
////    	
////    	System.out.println(amy);
////
////    }
////    
//    
//    
//    public void selectdatebyjs(WebDriver driver, WebElement element, String dateVal) {
//    	
//    	JavascriptExecutor js = (JavascriptExecutor)driver;
//    	js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
//    }
//    
//    
//    
//}
