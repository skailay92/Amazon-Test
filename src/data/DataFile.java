package data;

import utilities.Xls_Reader;

public class DataFile {

	Xls_Reader d = new Xls_Reader("C:\\testing\\Amazon Test.xlsx");
	
	public String search = d.getCellData("Sheet1", "search", 2);
	public String email = d.getCellData("Sheet1", "email", 2);
	public String emailerror = d.getCellData("Sheet1", "errormessage", 2);
}
