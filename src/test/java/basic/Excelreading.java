package basic;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelreading {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("D:\\data\\test11.xlsx");
		Workbook book = WorkbookFactory.create(fis);
          String str= book.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
           System.out.println(str);
	}

	
}
