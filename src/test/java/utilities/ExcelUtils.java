//package utilities;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelUtils {
//
//    @SuppressWarnings("deprecation")
//	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
//        FileInputStream fis = new FileInputStream(filePath);
//        Workbook workbook = new XSSFWorkbook(fis);
//        Sheet sheet = workbook.getSheet(sheetName);
//
//        int rows = sheet.getPhysicalNumberOfRows();
//        int cols = sheet.getRow(0).getPhysicalNumberOfCells();
//        
//
//        Object[][] data = new Object[rows - 1][cols]; // Skip header row
//
//        for (int i = 1; i < rows; i++) {
//            Row row = sheet.getRow(i);
//            for (int j = 0; j < cols; j++) {
//                Cell cell = row.getCell(j);
//                if (cell == null) {
//                    data[i - 1][j] = "";
//                } else {
//                    cell.setCellType(CellType.STRING);
//                    data[i - 1][j] = cell.getStringCellValue();
//                }
//            }
//        }
//
//        workbook.close();
//        fis.close();
//        return data;
//    }
//}
package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows - 1][cols];

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);
                    if (cell == null) {
                        data[i - 1][j] = "";
                    } else {
                        switch (cell.getCellType()) {
                            case STRING: data[i - 1][j] = cell.getStringCellValue(); break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell))
                                    data[i - 1][j] = cell.getDateCellValue().toString();
                                else
                                    data[i - 1][j] = String.valueOf(cell.getNumericCellValue());
                                break;
                            case BOOLEAN: data[i - 1][j] = String.valueOf(cell.getBooleanCellValue()); break;
                            case FORMULA: data[i - 1][j] = cell.getCellFormula(); break;
                            default: data[i - 1][j] = "";
                        }
                    }
                }
            }
            return data;
        }
    }
}

