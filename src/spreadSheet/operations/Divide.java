package spreadSheet.operations;

import java.util.List;

import spreadSheet.Contents;
import spreadSheet.ContentCell.NumOperator; 

public class Divide extends NumOperator {

 

	@Override
	public String value() {
		List<Contents> list = super.listRefences();
		if (list != null)
			return String.valueOf(list.stream().map(e -> Double.parseDouble(e.value())).reduce((a, b) -> a / b).orElse(null));
		return "";
	}
	
	@Override
	public String formula() {
		List<Contents> list = listRefences();
		if (list != null) return list.stream().map(a->a.formula()).reduce((a,b)->a+"/"+b).orElse("");
		return "";
	}

}
