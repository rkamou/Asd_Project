package spreadSheet.factory.concrete.contents;

import spreadSheet.Contents;
import spreadSheet.ContentCell.parser.abstracts.CellParserEngine;
import spreadSheet.ContentCell.parser.concrete.NumericExpParserEngine;
import spreadSheet.ContentCell.parser.concrete.StringParserEngine;
import spreadSheet.factory.abstracts.contents.AFContents;

public class FContents implements AFContents {

	@Override
	public Contents CreateContent(String expression) {
		String s = removeBlanck(expression);
		Contents c;
		CellParserEngine parser = new NumericExpParserEngine();
		c = parser.parser(s);
		if(c != null) return c;
		parser = new StringParserEngine();
		return parser.parser(s);
	}
	
	private String removeBlanck(String expression) {
		String ret = "";
		if (expression == null) return "";
		int i = 0;
		while(i<expression.length()) {
			if(!(expression.charAt(i)+"").equals(" ")) ret+=(expression.charAt(i)+"");
			i++;
		}
		return ret;
	}

}
