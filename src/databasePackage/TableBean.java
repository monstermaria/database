package databasePackage;

public class TableBean {

	private String table = "customer";
	private String[] tableNames = {"customer", "drive", "settings"};
	
	public TableBean() {
		
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String[] getTableNames() {
		return tableNames;
	}

}
