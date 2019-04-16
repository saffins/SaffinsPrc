package Rought;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {

	static XSSFWorkbook book = null;
	static XSSFSheet sheet = null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fs = new FileInputStream("I:\\suffin\\registrator.xlsx");
		book = new XSSFWorkbook(fs);
		sheet = book.getSheetAt(0);

		int row = getRow();
		int column = getCol();

		Object[][] data = new Object[row - 1][column];

		for (int i = 1; i < row; i++) {

			for (int j = 0; j < column; j++) {
				
				
                   
			//	Object data1 = getData(i,j);
				
				 
				
			}

		}
		
		
		System.out.println(sheet.getLastRowNum());
		/*
		Row row1 = sheet.createRow(7);
		
		Cell cell = row1.createCell(1);
		
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue("faileddd");

		
		FileOutputStream fos = new FileOutputStream("I:\\suffin\\registrator.xlsx");
		book.write(fos);
		fos.close();
		*/
		
	}
	
	public static Object getData(int row,int col){
		
		Object data = sheet.getRow(row).getCell(col).getStringCellValue();
		
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

}
