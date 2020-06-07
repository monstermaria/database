package databasePackage;

public class DataTypeBean {

	private String dataType = "customer";
	private String[] dataTypeNames = {"customer", "drive", "settings"};
	
	public DataTypeBean() {
		
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
