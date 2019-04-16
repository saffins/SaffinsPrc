package Rought;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Utilities.ExcelReader;

public class App3 {

	public static XSSFWorkbook book = null;
	public static XSSFSheet sheet = null;
	static FileInputStream fs = null;

	public static void main(String[] args) throws IOException {

		fs = new FileInputStream("I:\\suffin\\blanksheet.xlsx");
		book = new XSSFWorkbook(fs);
		sheet = book.getSheetAt(0);

		Map<Integer, String> mp = new HashMap<Integer, String>();

		mp.put(0, "pass");
		mp.put(1, "pass");

		mp.put(2, "fail");

		Set<Integer> values = mp.keySet();

		for (Integer val : values) {

			System.out.println(mp.get(val));

		}
		int rownum = 0;
		int cellnum = 7;

		for (Integer ke1 : values) {

			Row row = sheet.createRow(rownum);
			String objArr = mp.get(ke1);

			Cell cell = row.createCell(cellnum);
			cell.setCellValue(objArr);
			rownum++;
		}

		FileOutputStream out = new FileOutputStream(new File("I:\\suffin\\blanksheet.xlsx"));

		book.write(out);
		out.close();
		System.out.println("writing done");

	}

}
