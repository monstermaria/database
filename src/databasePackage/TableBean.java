package databasePackage;

public class TableBean {

	private String dataType = "customer";
	private String[] dataTypeNames = {"customer", "drive", "settings"};
	
	public TableBean() {
		
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String[] getDataTypeNames() {
		return dataTypeNames;
	}


}
