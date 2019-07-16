package spreadSheet.ContentCell.parser.concrete.text;

import spreadSheet.Contents;
import spreadSheet.ContentCell.Text;
import spreadSheet.ContentCell.parser.abstracts.CellParserEngine;

public class StringParserEngine  implements CellParserEngine{

	@Override
	public Contents parser(String expression) {
		return new Text(expression); 
	}

}
