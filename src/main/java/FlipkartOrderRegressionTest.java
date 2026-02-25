
	

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

	import java.io.InputStream;
	import java.time.Duration;
	import java.util.Properties;

	public class FlipkartOrderRegressionTest {

	    private WebDriver driver;
	    private WebDriverWait wait;
	    private String phoneNumber;
	    private String totpSecret;

	    @BeforeTest
	    public void setup() throws Exception {
	    	
	    	try {
				
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("setup failed:"+e.getMessage());
				
				// TODO: handle exception
			}
	        // Load properties from the classpath
	        Properties properties = new Properties();
	        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
	        if (input == null) {
	            throw new RuntimeException("config.properties not found in classpath");
	        }
	        properties.load(input);
	        phoneNumber = properties.getProperty("flipkart.phone");
	        totpSecret = properties.getProperty("flipkart.totpSecret");

	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        driver.manage().window().maximize();
	        driver.get("https://www.flipkart.com");

	        // Login flow
	        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Login']")));
	        loginBtn.click();

	        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='r4vIwl BV+Dqf']")));
	        phoneField.sendKeys("7993898007");

	        WebElement requestOtpBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Request OTP']")));
	        requestOtpBtn.click();

	        WebElement otpField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='XDRRi5']")));

//	        TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator();
//	        Base32 base32 = new Base32();
//	        SecretKeySpec key = new SecretKeySpec(base32.decode(totpSecret), "HmacSHA1");
//	        String otp = String.format("%06d", totp.generateOneTimePassword(key, Instant.now()));
//
//	        otpField.sendKeys(otp);
	        System.out.println("Please enter the OTP manually within 60 seconds...");

	        // Wait up to 60 seconds for manual OTP entry before continuing
	        for (int i = 0; i < 60; i++) {
	            String enteredOtp = otpField.getAttribute("value");
	            if (enteredOtp != null && !enteredOtp.isEmpty()) {
	                System.out.println("OTP entered: " + enteredOtp);
	                break;  // OTP entered, continue test
	            }
	        // Add a small wait for OTP processing if needed
	        Thread.sleep(2000);
	        }
	    }

	    @Test(priority = 1, description = "Test search and product discovery")
	    public void testSearchAndProductDiscovery() {
	        try {
	            WebElement closePopup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._2doB4z")));
	            closePopup.click();
	        } catch (Exception e) {
	            // popup may not appear
	        }

	        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
	        searchBox.sendKeys("laptop");
	        searchBox.submit();

	        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1AtVbE")));
	        Assert.assertTrue(firstResult.isDisplayed(), "Search results not displayed");
	    }

	    @Test(priority = 2, description = "Test product details and add to cart")
	    public void testAddToCart() {
	        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a._1fQZEK")));
	        firstProduct.click();

	        // Switch tab
	        String originalWindow = driver.getWindowHandle();
	        for(String windowHandle : driver.getWindowHandles()){
	            if(!windowHandle.equals(originalWindow)){
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }

	        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.B_NuCI")));
	        Assert.assertTrue(productTitle.isDisplayed(), "Product details not displayed");

	        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._2U9uOA._3v1-ww")));
	        addToCartButton.click();

	        WebElement cartNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._3g_HeN")));
	        Assert.assertTrue(cartNotification.getText().contains("Added"), "Item not added to cart");
	    }

	    @Test(priority = 3, description = "Test checkout process")
	    public void testCheckout() {
	        driver.get("https://www.flipkart.com/viewcart");

	        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1l2qE_")));
	        Assert.assertTrue(cartItem.isDisplayed(), "Cart is empty");

	        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._2HKlqd._3AWRsL")));
	        placeOrderButton.click();

	        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input._2IX_2-")));
	        emailField.sendKeys("test@email.com");

	        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._1secF9._3AWRsL")));
	        continueButton.click();
	    }

	    @Test(priority = 4, description = "Test payment processing")
	    public void testPayment() {
	        WebElement codOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='COD']")));
	        codOption.click();

	        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._1u95yl._3v1-ww")));
	        confirmButton.click();

	        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p._1jY6hK")));
	        Assert.assertTrue(confirmationMessage.getText().contains("Order Confirmed"), "Payment not processed successfully");
	    }

	    @Test(priority = 5, description = "Test order confirmation and post-order")
	    public void testOrderConfirmation() {
	        driver.get("https://www.flipkart.com/account/orders");

	        WebElement orderItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1lU0Py")));
	        Assert.assertTrue(orderItem.isDisplayed(), "Order not found in history");

	        WebElement trackButton = driver.findElement(By.cssSelector("span._3QANLW"));
	        trackButton.click();
	    }

	    @AfterTest
	    public void teardown() {
	        if(driver != null) {
	            driver.quit();
	        }
	    }
	}



