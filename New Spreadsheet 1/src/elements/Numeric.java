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
	public Numeric append(Double nbr)
	{
		if (nbr != null)
			number+=nbr;
		return this;
	}

	@Override
	public String formula() {
		StringBuilder ret = new StringBuilder();

		ret.append('\"').append(number.toString()).append('\"');

		return ret.toString();
	}

	@Override
	public float data() {
		return 0;
	}
	

}
