package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

        public static String getData(int row, int cell) throws IOException, IOException {

            FileInputStream file =
                    new FileInputStream("src/test/resources/testData.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("Sheet1");

            String value = sheet.getRow(row).getCell(cell).getStringCellValue();

            workbook.close();

            return value;
        }
    }

