package spreadSheet.ContentCell;

//import java.util.regex.Pattern;
 

//import net.objecthunter.exp4j.Expression;
//import net.objecthunter.exp4j.ExpressionBuilder;
import spreadSheet.Contents;

public class Numeric extends Contents {
	private float number;

	public Numeric(float number) {
		this.number = number;
	}
   
	@Override
	public String value() {
//		if (this.formula() != "" && isNumericFormulas(this.formula().trim()))
//			number = this.computeFormulas(this.formula().trim()).floatValue(); 
		return number + "";
	}
	 /**
	  * 
	  * @param formulas = 2-3+5*7
	  * @return
	  */
//	public boolean isNumericFormulas(String formulas) {
//		Pattern p = Pattern.compile("\\d+(\\.\\d)?+[\\+\\-\\/\\*]\\d+(\\.\\d+)?([\\+\\-\\/\\*]\\d+(\\.\\d+)?)*");
//		return p.matcher(formulas).matches();   
//	}

	@Override
	public String formula() {
		String g;
		try {
			g = (super.getCellOwner().formula()!="")?super.getCellOwner().formula():number+"";
		} catch (Exception e) {
			g = number+"";
		}
		return g;
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
//	private Double computeFormulas(String formulas) {
//		Expression e = new ExpressionBuilder(formulas).build();
//		return e.evaluate();
//	}
//
//	boolean isDouble(String str) {
//		try {
//			Double.parseDouble(str);
//			return true;
//		} catch (NumberFormatException e) {
//			return false;
//		}
//	}

}
