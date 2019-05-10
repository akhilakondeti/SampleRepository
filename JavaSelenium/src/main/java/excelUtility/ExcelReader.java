package excelUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

import globalConstants.Constants;


public class ExcelReader {
	
	public static Workbook wb = null;
	public static Sheet ws = null;
	public static Row row = null;
	public static Cell cell = null;
	public static FileInputStream fis = null;
	public static FileOutputStream fos = null;
	
public static Map<String, Object> getExcelData(String scriptname)
{
        String key = "";
        Object value = "";
       
        Map<String, Object> excelData = new LinkedHashMap<String, Object>();
        try {
        	ws=ExcelReader.getSheet(Constants.filepath,Constants.sheet_name);
            row=ws.getRow(0);
            for(int i=0; i<=ws.getLastRowNum(); i++)
            {
            	if(ws.getRow(i).getCell(0).toString().equalsIgnoreCase(scriptname))
            	{
            	for(int j=0; j<row.getLastCellNum();j++)
            	{
            			key = ws.getRow(0).getCell(j).getStringCellValue();
            			value = ws.getRow(i).getCell(j).getStringCellValue();
            			excelData.put(key, value);
            	}
            	}
            	
            }
            
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return excelData;
    }



public static Sheet getSheet(String filepath,String sheetname) throws IOException
{
wb=ExcelReader.excelWorkbook(filepath);
ws=null;
int no_of_sheet=wb.getNumberOfSheets();
for(int i=0;i<no_of_sheet;i++)
{
	if(wb.getSheetName(i).toString().equalsIgnoreCase(sheetname))
	{
		ws=(Sheet) wb.getSheetAt(i);
	}
}
return ws;
}



public static Workbook excelWorkbook(String filepath)
{
try
{
fis=new FileInputStream(new File(filepath));
if(filepath.endsWith(".xls"))
{
	wb = new HSSFWorkbook(fis);
} else {
	wb = new XSSFWorkbook(fis);
}

}
catch(Exception e){
	e.printStackTrace();
}
return wb;
}


public static String getKeyValue(Map<String, Object> getExcelData,String key)
{
return getExcelData.get(key).toString();
}

}

