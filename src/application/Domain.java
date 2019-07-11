package application;

import spreadSheet.Cell;
import spreadSheet.ConstantValue;
import spreadSheet.Coordinate;
import spreadSheet.SpreadSheet;

public class Domain {
	public SpreadSheet Construct() {
		SpreadSheet spreadsheet = new SpreadSheet(5, 2);
		Cell c11 = new Cell(new Coordinate(1, 1), new ConstantValue("AirFare"));
		Cell c12 = new Cell(new Coordinate(1, 2), new ConstantValue(487.5));
		Cell c21 = new Cell(new Coordinate(2, 1), new ConstantValue("Taxi"));
		Cell c22 = new Cell(new Coordinate(2, 2), new ConstantValue(118));
		Cell c31 = new Cell(new Coordinate(3, 1), new ConstantValue("Rental Car"));
		Cell c32 = new Cell(new Coordinate(3, 2), new ConstantValue(295.85));
		Cell c41 = new Cell(new Coordinate(4, 1), new ConstantValue("Hotel"));
		Cell c42 = new Cell(new Coordinate(4, 2), new ConstantValue(432));
		Cell c51 = new Cell(new Coordinate(5, 1), new ConstantValue("Meals"));
		Cell c52 = new Cell(new Coordinate(5, 2), new ConstantValue(150));
		spreadsheet.setCell(c11);
		spreadsheet.setCell(c12);
		spreadsheet.setCell(c21);
		spreadsheet.setCell(c22);
		spreadsheet.setCell(c31);
		spreadsheet.setCell(c32);
		spreadsheet.setCell(c41);
		spreadsheet.setCell(c42);
		spreadsheet.setCell(c51);
		spreadsheet.setCell(c52);
		
		return spreadsheet;
	}
}
