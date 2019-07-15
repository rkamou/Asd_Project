package spreadSheet.operations;

import java.util.List;

import spreadSheet.Contents;
import spreadSheet.ContentCell.NumOperator;

public class Add extends NumOperator {

	public String value() {
		List<Contents> list = super.listRefences();
		if (list != null)
			return String.valueOf(list.stream().map(e -> Double.parseDouble(e.value())).reduce(0.0, (a, b) ->{return a + b;}));
		return "";
	}

	@Override
	public String formula() {
		List<Contents> list = listRefences();
		if (list != null)
			return list.stream().map(a -> a.formula()).reduce((a, b) -> a + "+" + b).orElse("");
		return "";
	}
}
