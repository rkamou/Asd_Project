package elements;

import java.util.regex.Pattern;
 

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Numeric extends Contents {
	private float number;

	public Numeric(float number) {
		this.number = number;
	}

	@Override
	public String value() {
		if (this.formula() != "" && isNumericFormulas(this.formula().trim()))
			number = this.computeFormulas(this.formula()).floatValue(); 
		return number + "";
	}
	
	public boolean isNumericFormulas(String formulas) {
		Pattern p = Pattern.compile("\\d+[\\+\\-\\/\\*]\\d+([\\+\\-\\/\\*]\\d+)*");
		return p.matcher(formulas).matches();   
	}

	@Override
	public String formula() {
		return (super.getCellOwner().formula()!="")?super.getCellOwner().formula():number+"";
	}

	@Override
	public float data() {
		return number;
	}

	/**
	 * Compute an arithmetical expression
	 * @param formulas
	 * @return Double
	 */
	private Double computeFormulas(String formulas) {
		Expression e = new ExpressionBuilder(formulas).build();
		return e.evaluate();
	}

	boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
