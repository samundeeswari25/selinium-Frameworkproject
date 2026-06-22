package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    public static Map<String, String> getData(String Filepath, String Sheetname, String Testcase) throws IOException, IOException {
        Map<String,String> data = new HashMap<>();

        try {
            FileInputStream file =
                    new FileInputStream(Filepath);

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet("Sheet1");

            Row headerRow = sheet.getRow(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row.getCell(0).getStringCellValue().equalsIgnoreCase(Testcase)) {
                    for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                        data.put(
                                headerRow.getCell(j)
                                        .getStringCellValue(),
                                row.getCell(j)
                                        .toString());
                    }
                    break;
                }
            }

            workbook.close();
            file.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

            return data;
        }
    }

