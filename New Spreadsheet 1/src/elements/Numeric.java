package elements;

public class Numeric extends Contents{
	private Double number;

	public Numeric(Double number) {
		this.number = number;
	}

	public Boolean isNumber() { return true; }

	@Override
	public String value() {
		return String.valueOf(number);
	}

	@Override
	public String formula() {
		return null;
	}

	@Override
	public float data() {
		return 0;
	}
	

}
