package basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.vtiger.IAutoconstants;

public class ExcelPac 
{

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream(IAutoconstants.excelpath);

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");

		int lastrow = sheet.getLastRowNum();
		int lastcell= sheet.getRow(0).getLastCellNum();

		System.out.println(lastrow);
		System.out.println(lastcell);

		for (int i = 0; i <= lastrow; i++) {
			for (int j = 0; j < lastcell; j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+" ");
			}
			System.out.println();

		}

	}
}
