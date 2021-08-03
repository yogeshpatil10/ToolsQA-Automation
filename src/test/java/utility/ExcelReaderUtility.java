package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtility {

	static XSSFRow row;

	public static void readExcel() {

		try {
			File file = new File(
					"C:\\Users\\Lenovo\\eclipse-workspace\\ToolsQA-Automation-Testing\\src\\test\\resources\\StudentInfo.xlsx");

			FileInputStream inputStream = new FileInputStream(file);

			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(inputStream);

			XSSFSheet sheet = wb.getSheet("StudentInfo");

			row = sheet.getRow(1);

			XSSFCell cell = row.getCell(5);

			String firstName = cell.getStringCellValue();

			System.out.println("First Name: " + firstName);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String[][] readExcelInto2DArray(String excelFilePath, String sheetName, int totalCols)
			throws InvalidFormatException {

		File file = new File(excelFilePath);

		String[][] tabArray = null;

		try {
			OPCPackage opcPackage = OPCPackage.open(file.getAbsolutePath());

			Workbook wb = WorkbookFactory.create(opcPackage);

			Sheet sheet = wb.getSheet(sheetName);

			int totalRows = sheet.getLastRowNum() + 1;

			tabArray = new String[totalRows][totalCols];

			for (int i = 0; i < totalRows; i++) {

				for (int j = 0; j < totalCols; j++) {

					XSSFCell cell = (XSSFCell) sheet.getRow(i).getCell(j);

					if (cell == null) {
						continue;
					}

					switch (cell.getCellType()) {
					case BOOLEAN:

						tabArray[i][j] = String.valueOf(cell.getBooleanCellValue());
						break;
					case NUMERIC:
						tabArray[i][j] = String.valueOf(cell.getNumericCellValue());
						break;
					case STRING:
						tabArray[i][j] = cell.getStringCellValue();
						break;
					default:
						tabArray[i][j] = "";
						break;
					}

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return tabArray;
	}

}
