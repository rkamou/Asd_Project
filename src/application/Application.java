package application;

import spreadSheet.SpreadSheet;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Domain domain = new Domain();
		SpreadSheet sheet = domain.Construct();
		displaySheet(sheet);
	}
	
	public static void displaySheet(SpreadSheet sheet) {
		Integer rows = sheet.getRows();
		Integer colums = sheet.getColumns();
		for(Integer i = 0; i<rows; i++) {
			System.out.println();
			for(Integer j = 0; j<colums; j++) {
				System.out.print("\t\t"+String.valueOf(sheet.getSheet()[i][j].getValue()));
			}
		}
	}
}
