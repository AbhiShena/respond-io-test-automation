import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://app.respond.io/user/login");
    }

    @Test
    public void testValidLogin() {
        driver.findElement(By.id("email")).sendKeys("testuser@example.com");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("loginButton")).click();

        String expectedUrl = "https://app.respond.io/dashboard";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed or URL did not match");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

