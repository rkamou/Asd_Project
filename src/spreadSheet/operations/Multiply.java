package spreadSheet.operations;

import java.util.List;

import spreadSheet.ContentCell.NumOperator;
import spreadSheet.ContentCell.Reference;

public class Multiply extends NumOperator {

	@Override
	public String value() {
		List<Reference> list = super.listRefences();
		if (list != null)
			return String.valueOf(list.stream().map(e -> Double.parseDouble(e.value())).reduce(0.0, (a, b) -> a * b));
		return "";
	}

	
	@Override
	public String formula() {
		List<Reference> list = listRefences();
		if (list != null) return list.stream().map(a->a.formula()).reduce((a,b)->a+"*"+b).orElse("");
		return "";
	}
}
