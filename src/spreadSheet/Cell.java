package spreadSheet;

public class Cell {
	private Coordinate coordinate;
	private Value value;
	
	public Cell(Coordinate coordinate, Value value) { 
		this.coordinate = coordinate;
		this.value = value;
	}
	public Cell(Coordinate coordinate) { 
		this.coordinate = coordinate; 
	}
	public Cell(Value value) {  
		this.value = value;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	public Object getValue() {
		return value.getValue();
	}
	public void setValue(Value value) {
		this.value = value;
	}
}
