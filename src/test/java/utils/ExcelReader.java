package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.api.services.sheets.v4.model.Sheet;
import com.sun.rowset.internal.Row;

public class ExcelReader {
	public static List<String[]> readExcel(String path, String sheetName) {
		List<String[]> data = new ArrayList<>();
		
		try(FileInputStream fis = new FileInputStream(path));
				Workbook wb = new XSSFWorkbook(fis)) {
					Sheet sht = Workbook.getSheet(sheetName);
					Iterator<Row> rows = sheet.iterator();
					
					//Skip header.
					if(rows.hasNext() rows.next());
					
					while (rows.hasNext()) {
						Row row = rows.next();
						String searchTerm = row.getCell(0).getStringCellValue();
						String expected = row.getCell(1).getStringCellValue();
						data.add(new String[]{searchTerm, expected});
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return data;
		
	}
}
