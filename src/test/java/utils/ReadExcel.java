package utils;

import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Hashtable;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
public String path;
public XSSFWorkbook workbook=null;
public XSSFSheet sheet=null;
public XSSFRow row =null;

public ReadExcel(String path)
{
	this.path=path;
	try
	{
		 workbook=new XSSFWorkbook(new FileInputStream(path));
		  sheet = workbook.getSheetAt(0);
	}
	catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
		
	}}
	public static Object[][] getdata(String testcase)
	{
		String sheetName = "TestData";
		String testCase = testcase;
		int testCaseRowNum=1;
		while(!excel.getCellData(sheetName, 0, testCaseRowNum).equalsIgnoreCase(testCase)){	
			testCaseRowNum++;
		}
		int colsStartRowNum=testCaseRowNum+1;
		int dataStartRowNum=colsStartRowNum+1;
		int cols=0;	
		while(!excel.getCellData(sheetName, cols, colsStartRowNum).trim().equals("")){	
			cols++;	
		}	
		
		int rows=0;	
		while(!excel.getCellData(sheetName, 0, dataStartRowNum+rows).trim().equals("")){
			rows++;		
		}
		Object[][] data = new Object[rows][1];
		int i=0;
		for(int row=dataStartRowNum; row<dataStartRowNum+rows;row++){
			Hashtable<String, String> table =new Hashtable<String,String>();
			for(int col=0;col<cols;col++){
			String Testdata = excel.getCellData(sheetName, col, row);
			String colName = excel.getCellData(sheetName, col, colsStartRowNum);
			table.put(colName, Testdata);
			}
		data[i][0] = table;
			i++;
		}
		
		
		return null;
}
	public String getCellData(String sheetName,int colNum,int rowNum){
		try{
			if(rowNum <=0)
			{
				return "";
			}
		int index = workbook.getSheetIndex(sheetName);

		if(index==-1)
			return "";
		
	
		sheet = workbook.getSheetAt(index);
		 row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";
		XSSFCell cell = row.getCell(colNum);
		if(cell==null)
			return "";
		
	  if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		  return cell.getStringCellValue();
	  else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || cell.getCellType()==Cell.CELL_TYPE_FORMULA ){
		  
		  String cellText  = String.valueOf(cell.getNumericCellValue());
		  if (HSSFDateUtil.isCellDateFormatted(cell)) {
			  double d = cell.getNumericCellValue();
			  Calendar cal =Calendar.getInstance();
			  cal.setTime(HSSFDateUtil.getJavaDate(d));
	                  cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
	                  cellText = cal.get(Calendar.MONTH)+1 + "/" +
	                  cal.get(Calendar.DAY_OF_MONTH) + "/" +
	                  cellText;
		  } 
		  return cellText;
	    }else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
	      return "";
	     else 
	     {
		  return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e){
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}
}
