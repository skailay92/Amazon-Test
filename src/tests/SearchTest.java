package tests;



import org.testng.annotations.Test;
import data.DataFile;
import pages.HomePageTest;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.grid.ActualMain;

public class SearchTest {
	
	WebDriver driver;
	HomePageTest hp = new HomePageTest();
	DataFile d = new DataFile();
	@BeforeMethod
  public void beforeMethod() throws IOException {
	 hp.OpenBrowser();
	 hp.OpenHomePage();
	  //Open the browser
  }

   @AfterMethod
  public void afterMethod() {
	  //close the browser
	  hp.CloseBrowser();
  }

  

 
   @Test(priority = 1)
  public void searchItemTest() throws InterruptedException {
	//1.Search in the search box
	  hp.Search(d.search);
	//2.Print the drop down list
	//3.If the list is printed, then the test will be passed
	//4.Implicit Wait
	  
  }
  
  @Test (priority = 2)
  public void hoverTest() {
	  //hover on Sign In Button
	  hp.HoverTest();
	  //Get Size of both the lists
	  //using both implicit and explicit wait
	  //print both the lists in text file
  }
  
 @Test (priority = 3)
  public void customerServiceTest() throws InterruptedException {
	  //Click on customer service and open in new tab
	  //click on your orders
	  //enter wrong email 
	  //compare the error msg
	  hp.NewTab(d.email);
	//  String actual = hp.error.getText();
	 // Thread.sleep(2000);
	  Assert.assertEquals(hp.errormessage(), d.emailerror);
	 //Thread.sleep(5000);
	 //Assert.assertEquals(hp.errormessage(), d.emailerror);
	  
  }
  
  @Test (priority = 4)
  public void screenShotTest() throws InterruptedException, IOException {
	  hp.BestSeller();
	  //click on Best Seller and open in new tab
	  //scroll down to Video Games
	  //Click on it
	  //Scroll down and screen shot
	  //scroll up and screen shot
  }
  
}
