package elements;

public class Reference extends Contents{

	private Cell cell;

	public Reference(Cell cell) {
		this.cell = cell;
	}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	@Override
	public String value() {
		
		return String.valueOf(cell.data());
	}

	@Override
	public String formula() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float data() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
