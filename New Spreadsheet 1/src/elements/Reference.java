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
		if(!cell.isEmpty()) {
			this.cell = cell;
		}
		
	}


	@Override
	public String value() {		
		
		String val=new String();

			val = this.getCell().value();

		return val;
	}

	@Override
	public String formula() {
		return null;
	}

	@Override
	public float data() {
		float ret = 0;

		Contents contents = this.cell.getContent();

		if (contents != null)
			ret = contents.data();

		return ret;
	}
	
	
}
