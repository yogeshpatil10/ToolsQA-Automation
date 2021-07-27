package utility;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadCSVFileUtility {

	public static List<String[]> readFromCSVFile(String csvFile) {
		try {
			CSVReader csvReader = new CSVReader(new FileReader(csvFile));
			List<String[]> data = csvReader.readAll();
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
