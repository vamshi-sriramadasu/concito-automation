//package tests_doceo;
//
//import java.awt.AWTException;
//import java.io.IOException;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import concito.Doceodirect;
//import pages_doceo.Parent_directorypage;
//
//public class Test2_parent extends Doceodirect {
//	
//	
//	 @DataProvider(name = "parentExcelData")
//	    public Object[][] getParentExcelData() throws IOException {
//	        String filePath = "src/test/resources/ParentData.xlsx"; // keep Excel file here
//	        return ExcelUtils.getExcelData(filePath, "Sheet1");
//
//	        @Test(priority = 1, dataProvider = "parentExcelData")
//	        public void parentreg(
//	                String fatherName, String fatherNameT, String motherName, String motherNameT,
//	                String fatherImg, String motherImg, String fatherPhone, String fatherEmail,
//	                String motherPhone, String motherEmail, String fatherOcc, String motherOcc,
//	                String childName, String childNameT, String childPhone, String address, String pincode
//	        ) throws InterruptedException, AWTException {
//
//		Parent_directorypage pd = new Parent_directorypage(driver);
//		pd.directty();
//		Thread.sleep(3000);
//		pd.parentdrop();
//		Thread.sleep(3000);
//		pd.parentadd();
//		Thread.sleep(3000);
//		pd.parentregist("suresh", "suresht", "sunitha", "sunithat");
//		Thread.sleep(3000);
//		pd.parentregist1("C:\\Users\\user\\Pictures\\AI_Generated_Image.png"); // Correct
//
//		
//		Thread.sleep(3000);
//		pd.parentregist2("C:\\Users\\user\\Pictures\\Capture.PNG"); // Correct
//
//		Thread.sleep(3000);
//		pd.parentregist3("7993898007");
//		Thread.sleep(3000);
//		pd.parentregist4("suresh@gmail.com");
//		Thread.sleep(3000);
//		pd.parentregist5("9010105306");
//		Thread.sleep(3000);
//		pd.parentregist6("sunitha@gmail.com");
//		Thread.sleep(3000);
//		pd.parentregihalf("bussiness");
//		Thread.sleep(3000);
//		pd.parentregi1("housewife");
//		Thread.sleep(3000);
//		pd.parentregi2("sara");
//		Thread.sleep(3000);
//		pd.parentregi3("sarat");
//		Thread.sleep(3000);
//		pd.parentregi4("9093777474");
//		Thread.sleep(3000);
//		pd.parentregi5("hyd");
//		Thread.sleep(3000);
//		pd.parentregi6("508258");
//		Thread.sleep(3000);
//		pd.parentregi7();
//	}
//}


package tests_doceo;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import concito.Doceodirect;
import pages_doceo.Parent_directorypage;

public class Test2_parent extends Doceodirect {

    @DataProvider(name = "parentExcelData")
    public Object[][] getParentExcelData() throws IOException {
        String filePath = "C:\\Users\\user\\Downloads\\new_parent_data.xlsx"; // Excel path
        return utilities.ExcelUtils.getExcelData(filePath, "Sheet1");
    }

    @Test(priority = 1, dataProvider = "parentExcelData")
    public void parentreg(
            String fatherName, String fatherNameT, String motherName, String motherNameT,
            String fatherImg, String motherImg, String fatherPhone, String fatherEmail,
            String motherPhone, String motherEmail, String fatherOcc, String motherOcc,
            String childName, String childNameT, String childPhone, String address, String pincode
    ) throws InterruptedException, AWTException {

        Parent_directorypage pd = new Parent_directorypage(getDriver());

        pd.directty();
        Thread.sleep(2000);
        pd.parentdrop();
        Thread.sleep(2000);
        pd.parentadd();
        Thread.sleep(2000);

        
        pd.parentregist(fatherName, fatherNameT, motherName, motherNameT);
        pd.parentregist1(fatherImg);
        pd.parentregist2(motherImg);
        pd.parentregist3(fatherPhone);
        pd.parentregist4(fatherEmail);
        pd.parentregist5(motherPhone);
        pd.parentregist6(motherEmail);
        pd.parentregihalf(fatherOcc);
        pd.parentregi1(motherOcc);
        pd.parentregi2(childName);
        pd.parentregi3(childNameT);
        pd.parentregi4(childPhone);
        pd.parentregi5(address);
        pd.parentregi6(pincode);
        pd.parentregi7();
    }
}
