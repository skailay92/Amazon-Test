package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import data.DataFile;

public class HomePageTest {
	WebDriver driver;
	
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement search;
	@FindBy(className = "s-suggestion-container")
	public List<WebElement> laptop;
	@FindBy(id = "nav-link-accountList")
	public WebElement hover;
	@FindBy(xpath = "//div[@id=\"nav-al-wishlist\"]/a")
	public List<WebElement> wishlist;
	@FindBy(xpath = "//div[@id=\"nav-al-your-account\"]/a")
     public List<WebElement> yourlist;
	@FindBy(linkText = "Customer Service")
	public WebElement customerservice;
	@FindBy(className = "a-box-inner")
	public WebElement yourorder;
	@FindBy(id = "ap_email")
	public WebElement enteremail;
	@FindBy(id = "continue")
	public WebElement login;
	@FindBy(xpath = "//a[@data-csa-c-slot-id='nav_cs_0']")
	public WebElement bestseller;
	@FindBy(className = "a-list-item")
	public WebElement error;
	@FindBy (linkText = "Video Games")
	public WebElement videogames;
	
	public void OpenBrowser() throws IOException{
		FileInputStream f = new FileInputStream("C:\\testing\\MultipleBrowserTest.properties");
		  Properties prop = new Properties();
		  prop.load(f);
		  
		  String browser = prop.getProperty("browser");

			if(browser.equals("FireFox")){
				System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
				driver = new FirefoxDriver();
			}else {
				System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
				
				driver = new ChromeDriver();
			}
			PageFactory.initElements(driver, this);
	}
			 
			public void OpenHomePage() {
				     driver.get("https://www.amazon.ca/");	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}
        
			public void CloseBrowser() {
	        driver.quit();
            }
        public void Search(String a) throws InterruptedException {  
        	search.sendKeys(a);
        	System.out.println(laptop.size());
        	Thread.sleep(1000);
        	for(WebElement s : laptop) {
        		System.out.println(s.getText());
        	}
        }
        	 public void HoverTest() {
        	
        		Actions move = new Actions(driver);
        		move.moveToElement(hover).perform();
        		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        		System.out.println(wishlist.size());
        		for(WebElement w : wishlist) {
        			System.out.println(w.getText());
        		}
        		System.out.println("___________________________________________");
        		System.out.println(yourlist.size());
        		for(WebElement y : yourlist) {
        			System.out.println(y.getText());
        		}
        	 }
        	public void NewTab(String b) throws InterruptedException {
        		 String s = Keys.chord(Keys.CONTROL,Keys.ENTER);
        	customerservice.sendKeys(s);
        	Set<String> allwindows = driver.getWindowHandles();
    		
    		System.out.println(allwindows.size());
    		Iterator<String> itr = allwindows.iterator();
    		String parentwindow = itr.next();
    		String childwindow = itr.next();
    		System.out.println(parentwindow);
    		System.out.println(childwindow);
    		Thread.sleep(3000);
    		driver.switchTo().window(childwindow);
           yourorder.click();
           enteremail.sendKeys(b);
           login.click();
           
           
           
        	}
        	public String errormessage() {
        	String actual = error.getText();
			return actual;
				
        	}
        		
				
				
        	
        	public void BestSeller() throws InterruptedException, IOException {
        		
        		 String s = Keys.chord(Keys.CONTROL,Keys.ENTER);
             	bestseller.sendKeys(s);
             	Set<String> allwindows = driver.getWindowHandles();
         		
         		System.out.println(allwindows.size());
         		Iterator<String> itr = allwindows.iterator();
         		String parentwindow = itr.next();
         		String childwindow = itr.next();
         		System.out.println(parentwindow);
         		System.out.println(childwindow);
         		Thread.sleep(3000);
         		driver.switchTo().window(childwindow);
         		
         	//scroll down
         		JavascriptExecutor js = (JavascriptExecutor) driver;
         		js.executeScript("arguments[0].scrollIntoView();", videogames);
         		videogames.click();
         		js.executeScript("window.scrollBy(0,8000)", "");
         		
         		//screenshot 
         		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         		FileUtils.copyFile(screenshot, new File("C:\\testing\\screenshot.png"));
        	}

			
			}
        	
        	 
        
    
