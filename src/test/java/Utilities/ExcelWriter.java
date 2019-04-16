package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {
	

	static XSSFWorkbook book = null;
	static XSSFSheet sheet = null;
	FileInputStream fs = null;
	
	public ExcelWriter(String path) throws IOException {
		fs = new FileInputStream(path);
		book = new XSSFWorkbook(fs);
		sheet = book.getSheetAt(0);

	}
	
	
	


}
