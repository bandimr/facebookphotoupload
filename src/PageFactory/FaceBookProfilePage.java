package PageFactory;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageFactory.BasePage;

public class FaceBookProfilePage extends BasePage {
	
	@FindBy(id="email")
	public WebElement fBookEmail;
	
	@FindBy(id="pass")
	public WebElement fBookPassword;
			
	 @FindBy(xpath="//input[@value='Log In']")
     public WebElement fBookSubmit;
	 
	 @FindBy(xpath="//input[@type='file']")
     public WebElement fBookPhoto;
	 
	 @FindBy(xpath="//div[contains(text(),'Write something here')]")
     public WebElement fBookMEnabler;
	 
	 @FindBy(xpath="//div[contains(text(),'Write something here')]/../../div[2]/div")
     public WebElement fBookMessage;
	 
	 @FindBy(xpath="//li[@data-destination='STORIES']/div/div[1]/div")
     public WebElement fBookMyStories;
	 
	 @FindBy(xpath="//button[@type='submit']/span[contains(text(),'Share')]")
     public WebElement fBookMessageSubmit;

	 @FindBy(xpath="//span[contains(text(),'Bandim')]")
     public WebElement fBookStoryHome;
	 
	// Initializing the Page Objects:
	public FaceBookProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String fbookTitle() {
		return driver.getTitle();
	}
	 
     public boolean isMessagePresent(String message) {
    	 try {
    		 driver.findElement(By.xpath("//p[contains(text(), '"+ message + "')]"));
 	    } catch (NoSuchElementException e) {
 	        return false;
 	    }
 	    return true;
     }
     
     public boolean isPhotoPresent(String message) {
    	 try {
    		 driver.findElement(By.xpath("//p[contains(text(), '"+ message + "')]/../../div[3]"));
 	    } catch (NoSuchElementException e) {
 	        return false;
 	    }
 	    return true;
     }
     	
	public static void tearDown() {
	driver.quit();
	}
	
}
