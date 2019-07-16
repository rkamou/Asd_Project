package spreadSheet.ContentCell.parser.concrete.text.numericExp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import application.Director;
import spreadSheet.Contents;
import spreadSheet.ContentCell.Numeric;
import spreadSheet.ContentCell.Reference;
import spreadSheet.ContentCell.Text;
import spreadSheet.ContentCell.parser.abstracts.CellParserEngine;
import spreadSheet.operations.Add;
import spreadSheet.operations.Divide;
import spreadSheet.operations.Multiply;
import spreadSheet.operations.Substract;
import spreadSheet.util.UtilMethods;
import spreadSheet.util.iterator.SimpleList;

public class NumericComplexExpParser implements CellParserEngine {

	@Override
	public Contents parser(String expression) {
		Contents contents = parseParenthesisExpression(expression);
		if (contents != null)
			return contents;
		return null;
	}

	public List<Contents> referenceInExpression(String expression) {
		List<Contents> listContents = new ArrayList<Contents>();
		int i = 0;
		String term = "";
		boolean indexUsed = true;
		while (i < expression.length() && indexUsed) {
			if ((expression.charAt(i) + "").equals("[")) {
				i++;
				int row = 0, col = 0;
				term = "";
				boolean end = false;
				while (i < expression.length() && end == false) {
					if ((expression.charAt(i) + "").matches("\\d"))
						term += (expression.charAt(i) + "");
					if ((expression.charAt(i) + "").equals(","))
						if (UtilMethods.isDouble(term)) {
							row = Integer.parseInt(term);
							term = "";
						} else
							return null;
					if ((expression.charAt(i) + "").equals("]")) {
						if (UtilMethods.isDouble(term)) {
							col = Integer.parseInt(term);
							term = "";
						} else
							return null;
						end = true;
					}
					i++;
				}
				if (end == false)
					return null;
				if (row != 0 && col != 0) {
					listContents.add(new Reference(Director.getSpreadsheet().cell(row, col)));
				} else
					return null;
				i--;
			} else if ((expression.charAt(i) + "").matches("\\d") || (expression.charAt(i) + "").equals(".")) {
				term += (expression.charAt(i) + "");
				if (i == expression.length() - 1) {

					listContents.add(new Numeric(Float.valueOf(term).floatValue()));
				}
			} else if (!(expression.charAt(i) + "").matches("\\d")) {
				if (term.equals("")) {
					//
				} else {
					listContents.add(new Numeric(Float.valueOf(term).floatValue()));
				}
				if ((expression.charAt(i) + "").equals("+")) {
					listContents.add(new Add());
				} else if ((expression.charAt(i) + "").equals("-")) {
					listContents.add(new Substract());
				} else if ((expression.charAt(i) + "").equals("*")) {
					listContents.add(new Multiply());
				} else if ((expression.charAt(i) + "").equals("/")) {
					listContents.add(new Divide());
				} else
					indexUsed = false;
				term = "";
			}
			i++;
		}

		return listContents;
	}

	public static List<Contents> reverseList(List<Contents> list) {
		return IntStream.range(0, list.size()).mapToObj(i -> list.get(list.size() - 1 - i))
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public Contents parseParenthesisExpression(String expression) {
		SimpleList file = new SimpleList(expression.length());
		int i = 0;
		String term = "";
		while (i < expression.length()) {
			if ((expression.charAt(i) + "").equals("[")) {
				i++;
				int row = 0, col = 0;
				term = "";
				boolean end = false;
				while (i < expression.length() && end == false) {
					if ((expression.charAt(i) + "").matches("\\d"))
						term += (expression.charAt(i) + "");
					if ((expression.charAt(i) + "").equals(","))
						if (UtilMethods.isDouble(term)) {
							row = Integer.parseInt(term);
							term = "";
						} else
							return null;
					if ((expression.charAt(i) + "").equals("]")) {
						if (UtilMethods.isDouble(term)) {
							col = Integer.parseInt(term);
							term = "";
						} else
							return null;
						end = true;
					}
					i++;
				}
				if (end == false)
					return null;
				if (row != 0 && col != 0) {
					file.push(new Numeric(
							(float) Double.parseDouble(Director.getSpreadsheet().cell(row, col).getContent().value())));
				} else
					return null;
				i--;
			} else if ((expression.charAt(i) + "").equals("(")) {
				file.push(new Text(expression.charAt(i) + ""));

			} else if ((expression.charAt(i) + "").equals(")")) {
				List<Contents> lcont = new ArrayList<Contents>();
				if ((expression.charAt(i - 1) + "").matches("\\d")) {//|| ((expression.charAt(i-1) + "").equals("]"))) {
//					System.out.println(term);
					lcont.add(new Numeric((float) Double.parseDouble(term)));
				} //else
//					file.pop();
				while (!(file.getLast() instanceof Text)) {
					Contents c = file.pop();

					lcont.add(c);
				}

				file.pop();

				Contents[] tcont = NumericExpParser.tContents(reverseList(lcont));

//				for (Contents cont : tcont)
//					System.out.print(" : " + cont.getClass().getSimpleName());

				file.push(new Numeric((float) Double.parseDouble(NumericExpParser.sortList(tcont).value())));
				term = "";

			} else { 
				if ((expression.charAt(i) + "").equals("+") || (expression.charAt(i) + "").equals("-")
						|| (expression.charAt(i) + "").equals("*") || (expression.charAt(i) + "").equals("/")) {
					if (UtilMethods.isDouble(term)) {
						file.push(new Numeric((float) Double.parseDouble(term)));
						// System.out.println(" Number " + Double.parseDouble(term) + ", Index : " + i);
					}
					// else return null;
					term = "";
				}
				if ((expression.charAt(i) + "").equals("+")) {
					file.push(new Add());
					// System.out.println("Pass add");
				} else if ((expression.charAt(i) + "").equals("-")) {
					file.push(new Substract());
					// System.out.println("Pass minus");
				} else if ((expression.charAt(i) + "").equals("*")) {
					file.push(new Multiply());
				} else if ((expression.charAt(i) + "").equals("/")) {
					file.push(new Divide());
				} else {
					term += (expression.charAt(i) + "");
					if (i == expression.length() - 1)
						if (UtilMethods.isDouble(term))
							file.push(new Numeric((float) Double.parseDouble(term)));
						else
							return null;
					// System.out.println("Set Term "+ term+" Index : "+i);
				}
			}
			// System.out.println(term + " index :" + i);
			// if(file!=null)System.out.println(file.getFirst().getItem().getClass().getSimpleName());
			// System.out.println(file.getFirst().getItem().value());
			i++;
		}
		// System.out.println("Size list : "+file.getIndex()+1);
		// List<Contents> lcont = new ArrayList<Contents>();
		// while (file != null) {
		// Contents c = file.pop().getItem();
		// lcont.add(c);
		// System.out.println(c.value()+" Type : "+c.getClass().getSimpleName());
		// }
		// Contents[] tcont = NumericExpParser.tContents(file.getElements());
		Contents[] tcont = file.getElements();
		// System.out.println("Index : "+file.getIndex());
		// System.out.println("Lenght T result : "+tcont.length);
		//// if( tcont != null )System.out.println("Content First :
		// "+file.getFirst().getClass().getSimpleName());
//		for (int j = 0; j < tcont.length; j++) {
//			System.out.println(tcont[j].getClass().getSimpleName());
//		}

		if (tcont.length == 1)
			return tcont[0];
		return NumericExpParser.sortList(tcont);
	}

	// someString.chars().filter(ch -> ch == 'e').count();
}
