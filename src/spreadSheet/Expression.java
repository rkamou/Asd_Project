package spreadSheet;

public class Expression {
	public Operator operator;
	public Cell cell;
	public Expression next;
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Cell getCell() {
		return cell;
	}
	public void setCell(Cell cell) {
		this.cell = cell;
	}
	public Expression getNext() {
		return next;
	}
	public void setNext(Expression next) {
		this.next = next;
	}
	
}
