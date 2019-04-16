package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.selenium.testsuite.W2register;

public class ExcelReader {

	public static XSSFWorkbook book = null;
	public static XSSFSheet sheet = null;
	FileInputStream fs = null;

	public ExcelReader(String path) throws IOException {
		fs = new FileInputStream(path);
		book = new XSSFWorkbook(fs);
		sheet = book.getSheetAt(0);

	}

	public static String getData(int row, int col) {

		String data = sheet.getRow(row).getCell(col).getStringCellValue();

		return data;

	}

	public static int getRow() {

		int count = sheet.getPhysicalNumberOfRows();
		return count;

	}

	public static int getCol() {

		int count = sheet.getRow(0).getPhysicalNumberOfCells();

		return count;

	}
/*
	public static void write(String path) throws IOException {

		W2register reg = new W2register();
		Map<Integer, String> map = reg.getResults();

		Set<Integer> key = map.keySet();
		int rownum = 0;
		int cellnum = 0;
		for (Integer ke1 : key) {

			Row row = sheet.createRow(rownum++);
			String objArr = map.get(ke1);

			Cell cell = row.createCell(cellnum++);
			cell.setCellValue(objArr);

		}

		FileOutputStream out = new FileOutputStream(new File("I:\\suffin\\registrator - Copy.xlsx"));

		System.out.println("writing done");

		book.write(out);
		out.close();

	}*/
}
