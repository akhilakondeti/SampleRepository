package excelUtility;

import java.util.HashMap;
import java.util.Map;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Excel_reader {
    
	static Map<String, String> excelData;
	public static Map<String, String> excelData(String filepath,String sheetname ,String scriptname)
	{
		try
		{
	excelData = new HashMap<String, String>();
    Fillo fillo=new Fillo();
	 Connection con = fillo.getConnection(filepath);
	 String strQuery="Select * from " + sheetname + " where TestScriptName='" + scriptname + "'";
	 Recordset recordset=con.executeQuery(strQuery);
	 
	 for (String eachField : recordset.getFieldNames()) {
		 excelData.put(eachField, recordset.getField(eachField));
		}
	 recordset.close();
	 con.close();
	}
		catch(Exception e)
		{
			e.printStackTrace();
        }
		return excelData;
	}
}


