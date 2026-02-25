package pages_doceo;

import java.time.Month;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePickerPage {
    WebDriver driver;

    // Locators (update according to your widget)
    By dateField = By.id("doj");  // Date of Joining field
    By monthYearLabel = By.xpath("//div[@class='ui-datepicker-title']");
    By nextButton = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
    By prevButton = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']");
    By days = By.xpath("//table[@class='ui-datepicker-calendar']//td/a");

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
    }
  //div[@class='datepicker -bottom-left- -from-bottom- active']//nav[@class='datepicker--nav']//div[1]//*[name()='svg']
   
    
    public void selectDate(int targetDay, int targetMonth, int targetYear) throws InterruptedException {
        // Click on date field to open widget
        driver.findElement(dateField).click();
        Thread.sleep(1000);

        // Current displayed month & year
        while (true) {
            String monthYear = driver.findElement(monthYearLabel).getText();
            String[] parts = monthYear.split(" ");
            String monthText = parts[0].trim();
            int year = Integer.parseInt(parts[1].trim());

            int month = Month.valueOf(monthText.toUpperCase()).getValue();

            if (year == targetYear && month == targetMonth) {
                break; // Correct month & year found
            }

            // Navigate
            if (year > targetYear || (year == targetYear && month > targetMonth)) {
                driver.findElement(prevButton).click(); // Go backward
            } else {
                driver.findElement(nextButton).click(); // Go forward
            }
            Thread.sleep(500);
        }

        // Select the day
        List<WebElement> allDays = driver.findElements(days);
        for (WebElement d : allDays) {
            if (d.getText().equals(String.valueOf(targetDay))) {
                d.click();
                break;
            }
        }
    }
}
