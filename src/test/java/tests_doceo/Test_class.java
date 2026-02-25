//package tests_doceo;
//
//import java.awt.AWTException;
//import java.io.IOException;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import concito.Doceodirect;
//import pages_doceo.Class_masterpage;
//
//public class Test_class extends Doceodirect {
//
//	
//	 @DataProvider(name = "classExcelData")
//	    public Object[][] getclassExcelData() throws IOException {
//	        String filePath = "C:\\Users\\user\\Downloads\\class_data.xlsx"; // Excel path
//	        return utilities.ExcelUtils.getExcelData(filePath, "Sheet1");
//	    }
//
//	 @Test( priority = 1,  dataProvider = "classExcelData")
//	 public void class_data(String cnameng,String cnametel,String year,String feeclass,String studentstota) throws InterruptedException, AWTException {
//		 
//		 Class_masterpage cd = new Class_masterpage(driver);
//		 cd.masterdataclass();
//		 Thread.sleep(2000);
//		 cd.class_masterdata();
//		 Thread.sleep(2000);
//		 cd.add_classes();
//		 Thread.sleep(2000);
//		 cd.classfields(cnameng, cnametel);
//		 Thread.sleep(2000);
//		 cd.section_drops();
//		 Thread.sleep(2000);
//		 cd.academicyeardrop(year);
//		 Thread.sleep(2000);
//		 cd.classfee(feeclass);
//		 Thread.sleep(2000);
//		 cd.students_tot(studentstota);
//		 Thread.sleep(2000);
//		 cd.class_savebutton();
//		 Thread.sleep(2000);
//}
//}
package tests_doceo;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import concito.Doceodirect;
import pages_doceo.Class_masterpage;

public class Test_class extends Doceodirect {

	
	 @DataProvider(name = "classExcelData")
	    public Object[][] getclassExcelData() throws IOException {
	        String filePath = "C:\\Users\\user\\Downloads\\class_data.xlsx"; // Excel path
	        return utilities.ExcelUtils.getExcelData(filePath, "Sheet1");
	    }

	
	 @Test( priority = 1,  dataProvider = "classExcelData")
	 public void class_data(String cnameng,String cnametel,String year,String feeclass,String studentstota) throws InterruptedException, AWTException {
		 
		 Class_masterpage cd = new Class_masterpage(getDriver());
		 cd.masterdataclass();
		 Thread.sleep(2000);
		 cd.class_masterdata();
		 Thread.sleep(2000);
		 cd.add_classes();
		 Thread.sleep(2000);
		 cd.classfields(cnameng, cnametel);
		 Thread.sleep(2000);
		 cd.section_drops();
		 Thread.sleep(2000);
		 cd.academicyeardrop(year);
		 Thread.sleep(2000);
		 cd.classfee(feeclass);
		 Thread.sleep(2000);
		 cd.students_tot(studentstota);
		 Thread.sleep(2000);
		 cd.class_savebutton();
		 Thread.sleep(2000);
}
}

