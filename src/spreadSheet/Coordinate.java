package spreadSheet;

public class Coordinate {
	private Integer row;
	private Integer column;
	private Cell cell;
	public Coordinate(Integer row, Integer column) { 
		this.row = row;
		this.column = column;
	}
	public Integer getRow() {
		return row;
	}
	public void setRow(Integer row) {
		this.row = row;
	}
	public Integer getColumn() {
		return column;
	}
	public void setColumn(Integer column) {
		this.column = column;
	}
	public Cell getCell() {
		return cell;
	}
	

}
