package testNG;

import java.io.FileOutputStream;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ListenerDemo implements ITestListener{

	WebDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestStart + testName: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSuccess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		

		
		
		
		try {
			System.out.println("Test Passed:" + result.getName());

			String fileName = "C:\\Selenium\\"+result.getName()+".pdf";
			FileOutputStream fos = new FileOutputStream(fileName);
			Document doc = new Document();
			PdfWriter.getInstance(doc, fos);

			doc.open();
			doc.addAuthor("Dhaval Desai");
			doc.addTitle("Test Failure Report");
			doc.addSubject("Failure Report 29th April 2021");
			doc.add(new Paragraph("Test Failed:" + result.getName()));

			/*
			BufferedImage wall;
			wall = ImageIO.read(new File("C:\\Users\\dhava\\Desktop/Dhaval_Desai_CU2020.png"));
			*/

			doc.close();


			}
			catch(Exception e) {
			System.out.println(e.toString());

			}
	
}
		


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSkipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onFinish");
	}

}
