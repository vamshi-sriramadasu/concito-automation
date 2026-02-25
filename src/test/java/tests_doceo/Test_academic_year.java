//package tests_doceo;
//
//import java.io.IOException;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import concito.Doceodirect;
//import pages_doceo.Academicyear;
//
//public class Test_academic_year extends Doceodirect {
//
//	 @DataProvider(name = "academicyearExcelData")
//	    public Object[][] getacademicyearExcelData() throws IOException {
//	        String filePath = "C:\\Users\\user\\Downloads\\academicyearData.xlsx"; // Excel path
//	        return utilities.ExcelUtils.getExcelData(filePath, "Sheet1");
//	    }
//	 @Test( priority = 1,  dataProvider = "academicyearExcelData")
//	 public void section_data(String academicyearname) throws InterruptedException {
//		 
//		 Academicyear ad =new Academicyear(driver);
//		 ad.masterdata();
//		 Thread.sleep(2000);
//		 ad.academic_master();
//		 Thread.sleep(2000);
//		 ad.academic_add();
//		 Thread.sleep(2000);
//		 ad.academic_name(academicyearname);
//		 Thread.sleep(2000);
//		 ad.academic_save();
//		 Thread.sleep(2000);
//		  
//	 }
//	 
//}

package tests_doceo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import concito.Doceodirect;
import pages_doceo.Academicyear;

public class Test_academic_year extends Doceodirect {

    @DataProvider(name = "academicyearExcelData")
    public Object[][] getacademicyearExcelData() throws IOException {
        String filePath = "C:\\Users\\user\\Downloads\\academicyearData.xlsx"; 
        return utilities.ExcelUtils.getExcelData(filePath, "Sheet1");
    }

    @Test(priority = 1, dataProvider = "academicyearExcelData")
    public void section_data(String academicyearname) {

        Academicyear ad = new Academicyear(getDriver());

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        ad.masterdata();
        ad.academic_master();
        ad.academic_add();
        ad.academic_name(academicyearname);

        // Wait until save button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(ad.getSaveButton())); // make getter in page class
        ad.academic_save();
    }
}

