package apchpoi;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writedata {
	public static void main(String[] args) throws IOException {
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\pJJ.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("data");
		XSSFRow row1=sheet.createRow(0);
		
		row1.createCell(0).setCellValue("java");
		row1.createCell(1).setCellValue(12);
		row1.createCell(2).setCellValue("automation");
		row1.createCell(3).setCellValue("pegan");

	//	row1.createCell(0).setCellValue("testing");
		XSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue("python");
		row2.createCell(1).setCellValue(34);
		row2.createCell(2).setCellValue("automation");
		row2.createCell(3).setCellValue("tarika");
		
		XSSFRow row3=sheet.createRow(2);
		row3.createCell(0).setCellValue("c");
		row3.createCell(1).setCellValue(14);
		row3.createCell(2).setCellValue("automation");
		row3.createCell(3).setCellValue("vall");
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("file is created .....");
	}

}
