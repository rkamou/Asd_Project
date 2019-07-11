package spreadSheet;

public class ConstantValue extends Value {
	public Object value;
	public ConstantValue(Object value) {
		this.value = value;
	}
	@Override
	public Object getValue() {
		return value;
	}

}
