package com.crm.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UpLoadDownLoad {
	public static void uplaodFile() throws AWTException
	{
		//use SendKeys
		//Use Robot class
		StringSelection ss = new StringSelection("filepathtogetFile");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		
		Robot rob=new Robot();
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_V);
		
		rob.keyRelease(KeyEvent.VK_V);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void downloadFile() throws InterruptedException
	{
		HashMap<String, Object> prefs=new HashMap<>();
		prefs.put("download.default_directory", "C:\\Downloads");
		prefs.put("download.prompt_for_download", false);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		//trigger the download
		//driver.findElement(By.id("download")).click();
		
		//Verify Download
		
		File file=new File("C:\\Downloads\\Report.pdf");
		
		if(file.exists())
		{
			System.out.println("downloaded successful");
		}
		else
			System.out.println("downloaded failed");
		
		
		//if download still processing
		//File file = new File("C:\\Downloads\\Report.pdf");

		int count = 0;

		while(!file.exists() && count < 30)
		{
		    Thread.sleep(1000);
		    count++;
		}

		System.out.println(file.exists());
		
		//download multiple files
		prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
	}
	
		
}


