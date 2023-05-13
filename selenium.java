import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExampleTest {

    public static void main(String[] args) {

        // Test case 1: Buka halaman utama
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.github.com");
        assert "Example".equals(driver.getTitle());

        // Test case 2: Klik tombol "Sign Up"
        WebElement signupButton = driver.findElement(By.cssSelector("a[href='/signup']"));
        signupButton.click();
        assert "Sign Up".equals(driver.getTitle());

        // Test case 3: Masukkan informasi yang valid pada halaman Sign Up
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Toyly");
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("toylyashyyev@gmail.com");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("toylyashyyev");
        WebElement signupButton2 = driver.findElement(By.cssSelector("button[type='submit']"));
        signupButton2.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        assert "Dashboard".equals(driver.getTitle());

        // Test case 4: Logout dari aplikasi
        WebElement logoutButton = driver.findElement(By.cssSelector("a[href='/logout']"));
        logoutButton.click();
        assert "Logout".equals(driver.getTitle());

        // Test case 5: Verifikasi bahwa halaman login muncul setelah logout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Toyly")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("toylyashyyev")));

        // Close browser
        driver.quit();
    }
}
