//package listeners;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import concito.Doceodirect;
//
//public class TestListener extends Doceodirect implements ITestListener {
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        System.out.println("STARTED: " + result.getName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        System.out.println("PASSED: " + result.getName());
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        System.out.println("FAILED: " + result.getName());
//
//        WebDriver driver = Doceodirect.driver;  
//        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        try {
//            File dest = new File("screenshots/" + result.getName() + ".png");
//            dest.getParentFile().mkdirs();
//            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        System.out.println("SKIPPED: " + result.getName());
//    }
//
//    @Override
//    public void onStart(ITestContext context) {
//        System.out.println("===== TEST EXECUTION STARTED =====");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        System.out.println("===== TEST EXECUTION FINISHED =====");
//    }
//}

package listeners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import concito.Doceodirect;

public class TestListener extends Doceodirect implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED: " + result.getName());

        // ✅ CHANGE: get thread-safe driver
        WebDriver driver = getDriver();

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            File dest = new File("screenshots/" + result.getName() + ".png");
            dest.getParentFile().mkdirs();

            Files.copy(
                src.toPath(),
                dest.toPath(),
                StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("===== TEST EXECUTION STARTED =====");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("===== TEST EXECUTION FINISHED =====");
    }
}
