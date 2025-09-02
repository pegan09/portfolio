package apchpoi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writedynamicdata {
	public static void main(String[] args) throws IOException {
		FileOutputStream file1=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile_dynamic.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("dynamic_Data");
		 Scanner sc =new Scanner(System.in);
		System.out.println("how many rows");
		int noofrows=sc.nextInt();
		System.out.println("how many cells");
		int noofcells=sc.nextInt();
		for(int r=0;r<=noofrows;r++) {
		XSSFRow currentrow	=sheet.createRow(r);
			for(int c=0;c<noofcells;c++) {
				XSSFCell cell=currentrow.createCell(c);
				cell.setCellValue(sc.next());	
			}
		}
		workbook.write(file1);
		workbook.close();
		file1.close();
		System.out.println("file is created.....");
	}

}
