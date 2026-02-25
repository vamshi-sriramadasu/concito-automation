

package tests_doceo;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import concito.Doceodirect;
import pages_doceo.Directory_page;

public class Directory_test extends Doceodirect {

    @DataProvider(name = "studentExcelData")
    public Object[][] getstudentExcelData() throws Exception {
        String filePath = "C:\\Users\\user\\Desktop\\studentfortest.xlsx";
        return utilities.ExcelUtils.getExcelData(filePath, "Sheet1");
    }

    @Test(priority = 1, dataProvider = "studentExcelData")
    public void registerStudentTest(String name, String namet, String tutionfee, String discountfee,
                                    String amount, String totalamount, String dateVal, String dateVal1,
                                    String bloodgr, String genderselection, String casteeng, String castetelugu,
                                    String religioneng, String religionte, String nationalityeng, String nationalitytel,
                                    String authorisedeng, String authorisedtel, String relationauthoreng,
                                    String relationauthortel, String relationmobile, String spath, String apath) throws Exception {

        Directory_page dp = new Directory_page();

       
        dp.directory_student();
        Thread.sleep(2000);

        dp.studentdrop();
        Thread.sleep(2000);
        dp.studentaddbutt();
        Thread.sleep(2000);

        dp.register_student(name, namet);
        Thread.sleep(1000);

        dp.afterclassdrop(tutionfee, discountfee);
        Thread.sleep(1000);

        dp.aftereference(amount, totalamount);
        Thread.sleep(1000);

        WebElement dojElement = dp.dojtik;
        dp.selectdatebyjs(dojElement, dateVal);

        WebElement dobElement = dp.dob1;
        dp.selectdatebyjsdob(dobElement, dateVal1);

        dp.blood(bloodgr);
        dp.genderdrop(genderselection);
        dp.castesel(casteeng);
        dp.casteselt(castetelugu);
        dp.religionengsel(religioneng);
        dp.religiontelugusel(religionte);
        dp.nationalityeng(nationalityeng);
        dp.nationality(nationalitytel);
        dp.busdrop();
        dp.authorisedperson(authorisedeng);
        dp.authorisedpersontel(authorisedtel);
        dp.relationauthor(relationauthoreng);
        dp.relationauthtel(relationauthortel, relationmobile);

        dp.studentpic(spath);
        dp.authpic(apath);

        dp.studentsavebutton();
    }
}

