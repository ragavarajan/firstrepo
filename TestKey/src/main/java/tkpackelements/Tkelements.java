package tkpackelements;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import tkpackbase.Tkbase;

public class Tkelements {
	WebDriver driver;
	WebElement element;

	public void initiate(String sheetvalue) throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\J\\clients_pws.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook (fis);
		XSSFSheet sheet = wb.getSheet(sheetvalue);
		int k = 0;
		for(int i=1; i<6; i++)
		{
			String Locator = sheet.getRow(i).getCell(k+1).getStringCellValue();
			String Locator_value = sheet.getRow(i).getCell(k+2).getStringCellValue();
			String Action = sheet.getRow(i).getCell(k+3).getStringCellValue().toString().trim();
			String Data = sheet.getRow(i).getCell(k+4).getStringCellValue();

			switch(Action) 
			{
			case "Open browser":

				Tkbase bclass = new Tkbase();
				driver = bclass.openbrowser();
				break;

			case "Open url":

				driver.get(Data);
				break;

			case "Quit":

				driver.quit();
				break;

			default:
				break;
			}

			switch(Locator)
			{
			case "id":
				element = driver.findElement(By.id(Locator_value));
				if(Action.equalsIgnoreCase("write"))
				{
					element.clear();
					element.sendKeys(Data);
				}else if(Action.equalsIgnoreCase("click"))
				{
					element.click();
				}
				break;
			case "xpath":
				element = driver.findElement(By.xpath(Locator_value));
				if(Action.equalsIgnoreCase("write"))
				{
					element.clear();
					element.sendKeys(Data);
				}else if(Action.equalsIgnoreCase("click"))
				{
					element.click();
				}
				break;

			default:
				break;
			}
		}
	}
}
