package apchpoi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readdata {
	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\Book1.xlsx");
		//open workbook
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//getting sheet
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		//XSSFSheet sheet=workbook.getSheetAt(0);
		int norows=sheet.getLastRowNum();//getting number of rows
		int totalcelss=sheet.getRow(0).getLastCellNum();//getting number of cells
		System.out.println("number of rows"+norows);//5
		System.out.println("number of cells"+totalcelss);//4
	for(int r=0;r<=norows;r++) {
	XSSFRow	currentrow=sheet.getRow(r);
		for(int c=0;c<totalcelss;c++) {
		XSSFCell cell=currentrow.getCell(c);
		System.out.print(cell.toString()+"\t");
		}
		System.out.println();
	}
 workbook.close();
 file.close();
		
		
	}

}
