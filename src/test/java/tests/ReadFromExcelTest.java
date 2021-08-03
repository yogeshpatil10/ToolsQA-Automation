package tests;

import java.util.Arrays;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import utility.ExcelReaderUtility;

public class ReadFromExcelTest {
	@Test
	public void readFromExcel() throws InvalidFormatException {
		String[][] data = ExcelReaderUtility.readExcelInto2DArray(".\\src\\test\\resources\\StudentInfo.xlsx",
				"StudentInfo", 6);
		System.out.println(Arrays.deepToString(data) + " ");
	}
}
