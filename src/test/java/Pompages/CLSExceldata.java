package Pompages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CLSExceldata {
	
	
	//static method object mutidimensional return type getexcel datat creating
		public static Object[][] getExceldata(String fpath) throws Exception
		{
			
			Object[][] myExceldata =null; 
		      //pulling the data and store the data in the object array in the form of rows and columns
		      
		      XSSFWorkbook wb = new XSSFWorkbook(fpath);
				
			  XSSFSheet ws = wb.getSheet("Sheet1");
			  
			  int rows = ws.getPhysicalNumberOfRows();//active rows to identify
			  myExceldata = new Object[rows][2]; //how many rows and columns are there array size,matrix array will  be created
			  for(int i=0;i<rows;i++)
			  {
				  
				  myExceldata[i][0]= ws.getRow(i).getCell(0).getStringCellValue();
				  myExceldata[i][1]=ws.getRow(i).getCell(1).getStringCellValue();
			  }
			return myExceldata;
			
			
		}
		
	}


