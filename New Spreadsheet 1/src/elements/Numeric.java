package elements;

public class Numeric extends Contents{
	private float number;

	public Numeric(float number) {
		this.number = number;
	}


	@Override
	public String value() {
		return number+"";
	}
	@Override
	public String formula() {
		return value();
	}

	@Override
	public float data() {
		return number;
	}
	

}
