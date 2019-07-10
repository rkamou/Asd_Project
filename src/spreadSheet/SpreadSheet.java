package spreadSheet;

public class SpreadSheet {
	private Cell[][] sheet; 
	private Integer rows;
	private Integer columns;
	
	public SpreadSheet(Integer rows, Integer columns) { 
		this.rows = rows;
		this.columns = columns;
		sheet = new Cell[rows][columns];
	}
	
	public void  setCell(Coordinate c, Cell cell) {
		if(c != null)
		if(c.getRow()<=this.rows && c.getColumn()<=this.columns)
			sheet[c.getRow()-1][c.getColumn()-1] = cell;
	}
	
	public void  setCell(Cell cell) {
		if(cell != null)
			if(cell.getCoordinate() != null) {
				this.setCell(cell.getCoordinate(), cell); 
			} 
	}

	public Cell[][] getSheet() {
		return sheet;
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}
	
}
