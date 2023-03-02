package Tata_AIA_Utility_Classes;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Tata_DDF {
	
	public static String getTestData(int rowNum,int cellNum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Nikhil\\Desktop\\Maven Project\\Extent_Report\\target\\Test_Data\\TestData_Tata_AIA.xlsx");
		Sheet sh = WorkbookFactory.create(fis).getSheet("sheet1");

		String data = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		
		return data;
		
	}
	
	public static double getMobNumbers(int rowNum,int cellNum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Nikhil\\Desktop\\Maven Project\\Extent_Report\\target\\Test_Data\\TestData_Tata_AIA.xlsx");
		Sheet sh = WorkbookFactory.create(fis).getSheet("sheet1");
		
		double Mob=sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();
				
		return Mob;
		
	}

}
