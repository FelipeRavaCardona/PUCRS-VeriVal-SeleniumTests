import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {

    @Test
    void findOwnerTest() {
        WebDriver browser = new ChromeDriver();

        browser.manage().window().maximize();

        browser.get("http://localhost:8080");

        // Find and click on FIND OWNERS on the NavBar
        browser.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a")).click();

        // Find the search bar and type "Franklin"
        browser.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Franklin");

        // Find the button to search and click on it
        browser.findElement(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button")).click();

        // Take the name element, if it doest not exist, an exception will be thrown
        WebElement name = browser.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b"));

        assertEquals("George Franklin", name.getText());

        browser.close();
    }

    @Test
    void createOwnerTest() {
        WebDriver browser = new ChromeDriver();

        browser.manage().window().maximize();

        browser.get("http://localhost:8080");

        // Find and click on FIND OWNERS on the NavBar
        browser.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a")).click();

        // Find and click on ADD OWNERS button
        browser.findElement(By.xpath("//*[@id=\"search-owner-form\"]/a")).click();

        browser.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Felipe");
        browser.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Cardona");
        browser.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Casa do Cardona");
        browser.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Porto Alegre");
        browser.findElement(By.xpath("//*[@id=\"telephone\"]")).sendKeys("123456789");

        browser.findElement(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button")).click();

        // Take the name element, if it doest not exist, an exception will be thrown
        WebElement name = browser.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b"));

        assertEquals("Felipe Cardona", name.getText());

        browser.close();
    }
}

