package bankProject;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class bankProject {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		manager_Loging();
		driver_close();
		
		
	}
	
	
	public static void manager_Loging() throws Exception   {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Engineering\\JAVA\\chomedriver_21Nov_2022\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://103.16.152.254/");//BSCCL 
		driver.get("https://demo.guru99.com/V1/index.php"); //Demo
		
		String excelFilePath=".\\datafiles\\Selenium.xlsx";
		FileInputStream inputstream= new FileInputStream(excelFilePath);
		XSSFWorkbook workbook= new XSSFWorkbook(inputstream);
		//XSSFSheet sheet= workbook.getSheetAt(0);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		//String data0=sheet.getRow(0).getCell(0).getStringCellValue();
		//System.out.println("1ST ROW IS:" +data0);
		for(int i=0;i<excelFilePath.length();i++) {
				String data0=sheet.getRow(i).getCell(0).getStringCellValue();
				System.out.println("ROW IS:" +data0);
				Cell cell1=sheet.getRow(i).getCell(1);
				cell1.setCellType(Cell.CELL_TYPE_STRING);
				String data1= cell1.getStringCellValue();
			   //driver.findElement(By.name("password")).sendKeys(data1);
			//String data1=sheet.getRow(i).getCell(1).getStringCellValue();
				System.out.println("COL IS:" +data1);
		//driver.findElement(By.name("uid")).sendKeys("mngr416907 ")

			//Demo Project from guru99
			driver.findElement(By.name("uid")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			Thread.sleep(3000);
			//driver.findElement(By.name("password")).sendKeys("qerAgen ");
			driver.findElement(By.name("password")).sendKeys(data1);
			Thread.sleep(3000);
			driver.findElement(By.name("btnLogin")).click();
			driver.findElement(By.linkText("Log out")).click();
			
			
			//BSCCL
		/*driver.findElement(By.name("email")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
		Thread.sleep(3000);
		//driver.findElement(By.name("password")).sendKeys("qerAgen ");
		driver.findElement(By.name("password")).sendKeys(data1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/form[1]/div[3]/div[2]/button[1]")).click();
		driver.findElement(By.className("far fa-user")).click();
		//driver.findElement(By.linkText("Log out")).click();
		 */
		//Thread.sleep(2000);
		//driver.navigate().refresh();		
		}
		
	}
	
	public static void driver_close() {
		driver_close();
		
	}

}
