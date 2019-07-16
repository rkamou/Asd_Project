package spreadSheet.operations;

import java.util.List;

import spreadSheet.Contents;
import spreadSheet.ContentCell.NumOperator; 

public class Multiply extends NumOperator {

	@Override
	public String value() {
		List<Contents> list = super.listRefences();
		if (list != null)
			return String.valueOf(list.stream().map(e -> Double.parseDouble(e.value())).reduce(1.0, (a, b) -> a * b));
		return "";
	}

	
	@Override
	public String formula() {
		if(!super.formula().equals("")) return super.formula();
		List<Contents> list = listRefences();
		if (list != null) return list.stream().map(a->a.formula()).reduce((a,b)->"("+ a + "*" + b + ")").orElse("");
		return "";
	}
}
