package concito2;

import org.apache.commons.codec.binary.Base32;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;

import java.io.FileInputStream;
import java.time.Duration;
import java.time.Instant;
import java.util.Properties;

import javax.crypto.spec.SecretKeySpec;

public class FlipkartOrderRegressionTest {

    private WebDriver driver;
    private WebDriverWait wait;

//    @BeforeTest
//    public void setup() {
//        // Set up ChromeDriver (ensure chromedriver is in your PATH)
//        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.manage().window().maximize();
////        Properties properties=new Properties();
////        FileInputStream 
//        driver.get("https://www.flipkart.com");  // Navigate to Flipkart homepage
//        driver.findElement(By.xpath("//div[@class='uiU-ZX']")).click();
//        driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']")).sendKeys("7993898007");
//        
//    }}
    @BeforeTest
    public void setup() throws Exception {
        // Load properties
    	driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com");
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        properties.load(fis);
        String phoneNumber = properties.getProperty("flipkart.phone");
        String totpSecret = properties.getProperty("flipkart.totpSecret");

        

        // Login button and enter phone
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Login']")));
        loginBtn.click();
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input._2IX_2-")));
        phoneField.sendKeys(phoneNumber);

        // Request OTP
        WebElement requestOtpBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[text()='Request OTP']")));
        requestOtpBtn.click();

        // Wait for OTP input field
        WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input._2IX_2-")));

        // Generate TOTP
        TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator();
        Base32 base32 = new Base32();
        SecretKeySpec key = new SecretKeySpec(base32.decode(totpSecret), "HmacSHA1");
        String otp = String.format("%06d", totp.generateOneTimePassword(key, Instant.now()));

        otpField.sendKeys(otp);

        // Submit OTP if needed
        // WebElement submitButton = ...;
        // submitButton.click();
    }


    @Test(priority = 1, description = "Test search and product discovery")
    public void testSearchAndProductDiscovery() {
        // Close any login popup if it appears
        try {
            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._2doB4z")));
            closePopup.click();
        } catch (Exception e) {
            // Popup might not appear
        }

        // Search for a product (e.g., "laptop")
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys("laptop");
        searchBox.submit();

        // Verify search results are displayed
        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1AtVbE")));
        Assert.assertTrue(firstResult.isDisplayed(), "Search results not displayed");
    }

    @Test(priority = 2, description = "Test product details and add to cart")
    public void testAddToCart() {
        // Assuming from search results, click on the first product
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a._1fQZEK")));
        firstProduct.click();

        // Switch to new tab if opened
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Verify product details page
        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.B_NuCI")));
        Assert.assertTrue(productTitle.isDisplayed(), "Product details not displayed");

        // Add to cart
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._2U9uOA._3v1-ww")));
        addToCartButton.click();

        // Verify cart update
        WebElement cartNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._3g_HeN")));
        Assert.assertTrue(cartNotification.getText().contains("Added"), "Item not added to cart");
    }

    @Test(priority = 3, description = "Test checkout process")
    public void testCheckout() {
        // Navigate to cart
        driver.get("https://www.flipkart.com/viewcart");

        // Verify cart contents
        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1l2qE_")));
        Assert.assertTrue(cartItem.isDisplayed(), "Cart is empty");

        // Proceed to checkout
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL")));
        placeOrderButton.click();

        // Assuming login is required; enter credentials (use test account)
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input._2IX_2-")));
        emailField.sendKeys("test@email.com");
        // Continue with phone/OTP or password as needed (simulated here)

        // Select address (assuming one is saved)
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._1secF9._3AWRsL")));
        continueButton.click();
    }

    @Test(priority = 4, description = "Test payment processing")
    public void testPayment() {
        // Assuming on payment page after checkout
        // Select payment method (e.g., COD for simplicity)
        WebElement codOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='COD']")));
        codOption.click();

        // Confirm payment
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._1u95yl._3v1-ww")));
        confirmButton.click();

        // Verify redirection to confirmation
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p._1jY6hK")));
        Assert.assertTrue(confirmationMessage.getText().contains("Order Confirmed"), "Payment not processed");
    }

    @Test(priority = 5, description = "Test order confirmation and post-order")
    public void testOrderConfirmation() {
        // Navigate to order history (assuming after confirmation)
        driver.get("https://www.flipkart.com/account/orders");

        // Verify order is listed
        WebElement orderItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1lU0Py")));
        Assert.assertTrue(orderItem.isDisplayed(), "Order not found in history");

        // Test tracking (simulated click)
        WebElement trackButton = driver.findElement(By.cssSelector("span._3QANLW"));
        trackButton.click();
        // Add assertions for status if needed
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
