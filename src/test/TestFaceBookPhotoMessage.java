package test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import PageFactory.FaceBookProfilePage;
import PageFactory.BasePage;


public class TestFaceBookPhotoMessage extends BasePage{
	
	FaceBookProfilePage faceBookPage;
	
	public TestFaceBookPhotoMessage() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		faceBookPage = new FaceBookProfilePage() ;
	}
	
	@Test(priority=0)
	public void testfaceBookPageLogin() {
		
		Assert.assertEquals(faceBookPage.fbookTitle(),"Facebook – log in or sign up");
		faceBookPage.fBookEmail.clear();
		faceBookPage.fBookEmail.sendKeys(fbookLogin);
		faceBookPage.fBookPassword.clear();
		faceBookPage.fBookPassword.sendKeys(fbookPassword);
		faceBookPage.fBookSubmit.click();
		Assert.assertEquals(faceBookPage.fbookTitle(),"Facebook");
	}
	
	@Test(priority=1)
	public void testFacebookmessagePhoto() throws InterruptedException {
		faceBookPage.fBookMEnabler.click();
		faceBookPage.fBookMessage.sendKeys(fbookMessage);
		faceBookPage.fBookPhoto.sendKeys(pictureuploadlink);
	    Thread.sleep(30000);
		faceBookPage.fBookMyStories.click();
		faceBookPage.fBookMessageSubmit.click();
	    Thread.sleep(30000);
		faceBookPage.fBookStoryHome.click();
	    Thread.sleep(30000);
	    Assert.assertTrue(faceBookPage.isMessagePresent(fbookMessage),"Message not present in my stories of Facebook");
	    Assert.assertTrue(faceBookPage.isPhotoPresent(fbookMessage),"Photo not present in my stories of Facebook");
	}
	
	@AfterClass
	public void tearDown(){
		
		faceBookPage.tearDown();
		driver = null ;
		faceBookPage = null ;
	}
}


