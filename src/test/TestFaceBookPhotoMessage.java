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
		faceBookPage = new FaceBookProfilePage() ;;
	}
	
	@Test(priority=0)
	public void testfaceBookPageLogin() {
		
		Assert.assertEquals(faceBookPage.fbookTitle(),"Facebook – log in or sign up");
		faceBookPage.faceBookEmail.clear();
		faceBookPage.faceBookEmail.sendKeys(facebookLogin);
		faceBookPage.faceBookPassword.clear();
		faceBookPage.faceBookPassword.sendKeys(facebookPassword);
		faceBookPage.faceBookSubmit.click();
		Assert.assertEquals(faceBookPage.fbookTitle(),"Facebook");
	}
	
	@Test(priority=1)
	public void testFacebookmessagePhoto() throws InterruptedException {
		faceBookPage.faceBookMEnabler.click();
		faceBookPage.faceBookMessage.sendKeys(fMessage);
		faceBookPage.faceBookPhoto.sendKeys(pictureuploadlink);
	    Thread.sleep(30000);
		faceBookPage.faceBookMyStories.click();
		faceBookPage.faceBookMessageSubmit.click();
	    Thread.sleep(30000);
		faceBookPage.faceBookStoryHome.click();
	    Thread.sleep(30000);
	    Assert.assertTrue(faceBookPage.isMessageElementPresent(fbookMessage),"Message not present in my stories of Facebook");
	    Assert.assertTrue(faceBookPage.isPhotoElementPresent(fbookMessage),"Photo not present in my stories of Facebook");
	}
	
	@AfterClass
	public void tearDown(){
		
		faceBookPage.tearDown();
		driver = null ;
		faceBookPage = null ;
	}
}


