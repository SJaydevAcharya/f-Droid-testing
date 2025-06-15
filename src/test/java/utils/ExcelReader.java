package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public static List<String[]> readExcel(String path, String sheetName) {
        List<String[]> data = new ArrayList<>();

        try (
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = new XSSFWorkbook(fis)
        ) {
            Sheet sheet = wb.getSheet(sheetName);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();

                Cell searchTermCell = row.getCell(0);
                Cell expectedCell = row.getCell(1);

                if (searchTermCell != null && expectedCell != null) {
                    String searchTerm = searchTermCell.getStringCellValue();
                    String expected = expectedCell.getStringCellValue();
                    data.add(new String[] { searchTerm, expected });
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
