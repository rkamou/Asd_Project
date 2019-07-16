package spreadSheet.operations;

import java.util.List;

import spreadSheet.Contents;
import spreadSheet.ContentCell.NumOperator; 

public class Substract extends NumOperator {


	
	@Override
	public String value() {
		List<Contents> list = super.listRefences();
		if (list != null)
			return String.valueOf(list.stream().map(e -> Double.parseDouble(e.value())).reduce((a, b) -> {return a - b;}).orElse(0.0));
		return "";
	}

	@Override
	public String formula() {
		if(!super.formula().equals("")) return super.formula();
		List<Contents> list = listRefences();
		if (list != null) return list.stream().map(a->a.formula()).reduce((a,b)->"("+ a + "-" + b + ")").orElse("");
		return "";
	}
}
