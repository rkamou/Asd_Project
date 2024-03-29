package spreadSheet.ContentCell;

import spreadSheet.Cell;
import spreadSheet.Contents;

public class Reference extends Contents{

	private Cell cell;
	
	public Reference(Cell cell) {
		this.cell = cell;
	}

	@Override
	public String value() {		
		return cell.value();
	}

	@Override
	public String formula() {
		return cell.getCoordinates();
	}

	@Override
	public float data() {
		return cell.data();
	}
	
	
}
