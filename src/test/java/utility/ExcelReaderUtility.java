package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtility {

	public static void readExcel() {

		try {
			File file = new File(
					"C:\\Users\\Lenovo\\eclipse-workspace\\ToolsQA-Automation-Testing\\src\\test\\resources\\StudentInfo.xlsx");

			FileInputStream inputStream = new FileInputStream(file);

			XSSFWorkbook wb = new XSSFWorkbook(inputStream);

			XSSFSheet sheet = wb.getSheet("StudentInfo");

			XSSFRow row = sheet.getRow(1);

			XSSFCell cell = row.getCell(5);

			String firstName = cell.getStringCellValue();

			System.out.println("First Name: " + firstName);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void readEntireExcel(int totalCells) {

		try {
			File file = new File(
					"C:\\Users\\Lenovo\\eclipse-workspace\\ToolsQA-Automation-Testing\\src\\test\\resources\\StudentInfo.xlsx");

			FileInputStream inputStream = new FileInputStream(file);
			String[][] tabArray = null;

			XSSFWorkbook wb = new XSSFWorkbook(inputStream);

			XSSFSheet sheet = wb.getSheet("StudentInfo");

			int rowCount = sheet.getLastRowNum() + 1;
			tabArray = new String[rowCount][totalCells];

			for (int i = 0; i < rowCount; i++) {

				System.out.println("Row " + i + " data is: ");

				for (int j = 0; j < totalCells; j++) {

					XSSFCell cell = sheet.getRow(i).getCell(j);
					System.out.print(cell + " ");

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public static void main(String[] args) {

		readExcel();
		readEntireExcel(6);
	}

}
