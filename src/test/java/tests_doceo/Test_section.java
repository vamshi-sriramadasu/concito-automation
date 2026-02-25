package tests_doceo;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import concito.Doceodirect;
import pages_doceo.Sections_directorypage;

public class Test_section extends Doceodirect {

	 @DataProvider(name = "sectionExcelData")
	    public Object[][] getsectionExcelData() throws IOException {
	        String filePath = "C:\\Users\\user\\Downloads\\sectionData.xlsx"; // Excel path
	        return utilities.ExcelUtils.getExcelData(filePath, "Sheet1");
	    }
	 
	 @Test( priority = 1,  dataProvider = "sectionExcelData")
	 public void section_data(String snameng,String snametel) throws InterruptedException {
		 
		 Sections_directorypage sd = new Sections_directorypage(getDriver());
		 sd.masterdata();
		 Thread.sleep(2000);
		 sd.section_master();
		 Thread.sleep(2000);
		 sd.section_add();
		 Thread.sleep(2000);
		 sd.section_names(snameng, snametel);
		 Thread.sleep(2000);
		 sd.section_save();
		  
	 }
	 

}
