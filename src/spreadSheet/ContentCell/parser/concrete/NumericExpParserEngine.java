package spreadSheet.ContentCell.parser.concrete;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import application.Director;
//import net.objecthunter.exp4j.Expression;
//import net.objecthunter.exp4j.ExpressionBuilder;
import spreadSheet.Contents;
import spreadSheet.ContentCell.Numeric;
import spreadSheet.ContentCell.Reference;
import spreadSheet.ContentCell.Text;
import spreadSheet.ContentCell.parser.abstracts.CellParserEngine;
import spreadSheet.operations.Add;
import spreadSheet.operations.Divide;
import spreadSheet.operations.Multiply;
import spreadSheet.operations.Substract;

public class NumericExpParserEngine implements CellParserEngine {
	private List<Contents> listContents = new ArrayList<Contents>();

	@Override
	public Contents parser(String expression) {

		if (isDouble(expression))
			return new Numeric((float) Double.parseDouble(expression));

		if (isNumericFormulas(expression))
			if (isConstantInExpression(expression))
				return sortList(this.tContents(listContents));

		if (isReferenceInExpression(expression))
			return sortList(this.tContents(listContents));
		return null;
	}

	boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean isNumericFormulas(String formulas) {
		Pattern p = Pattern.compile("\\d+(\\.\\d)?+[\\+\\-\\/\\*]\\d+(\\.\\d+)?([\\+\\-\\/\\*]\\d+(\\.\\d+)?)*");
		return p.matcher(formulas).matches();
	}

	// private Double computeFormulas(String formulas) {
	// Expression e = new ExpressionBuilder(formulas).build();
	// return e.evaluate();
	// }

	public Contents sortList(Contents[] tcontents) {
		List<Integer> listIndexUsed = new ArrayList<>();
		int i = 0;
		int j;
		i = 0;
		while (i < tcontents.length) {
			i++;
		}
		i = 0;
		while (i < tcontents.length) {
			if (tcontents[i] != null) {
				if (tcontents[i] instanceof Numeric)
					;
				if (tcontents[i] instanceof Divide) {
					j = i - 1;
					while (j >= 0 && listIndexUsed.contains(j))
						j--;
					Divide d = new Divide();
					d.appends(tcontents[j]);
					listIndexUsed.add(j);
					j = i + 1;
					while (j < tcontents.length && listIndexUsed.contains(j))
						j++;
					d.appends(tcontents[j]);
					tcontents[i] = d;
					listIndexUsed.add(j);   
					i++;
				}
			}
			i++;
		}
		i = 0;
		while (i < tcontents.length) {
			if (tcontents[i] != null) {
				if (tcontents[i] instanceof Numeric)
					;
				// System.out.println("Item : " + tcontents[i].value());
				if (tcontents[i] instanceof Multiply) {

					j = i - 1;
					while (j >= 0 && listIndexUsed.contains(j))
						j--;
					// System.out.println("Multiply Occurs index " + i + " Index " + j);
					Multiply d = new Multiply();
					d.appends(tcontents[j]);
					listIndexUsed.add(j);
					j = i + 1;
					while (j < tcontents.length && listIndexUsed.contains(j))
						j++;
					// System.out.println("Multiply Occurs index " + i + " Index " + j);
					d.appends(tcontents[j]);
					tcontents[i] = d;
					listIndexUsed.add(j);
					i++;
				}
			}
			i++;
		}
		i = 0;
		while (i < tcontents.length) {
			if (tcontents[i] != null) {
				if (tcontents[i] instanceof Numeric)
					;
				// System.out.println("Item : " + tcontents[i].value());
				if (tcontents[i] instanceof Add) {

					j = i - 1;
					while (j >= 0 && listIndexUsed.contains(j))
						j--;
					// System.out.println("Add Occurs index " + i + " Index " + j);
					Add d = new Add();
					d.appends(tcontents[j]);
					listIndexUsed.add(j);
					// tcontents[j] = null;
					j = i + 1;
					while (j < tcontents.length && listIndexUsed.contains(j))
						j++;
					// System.out.println("Add Occurs index " + i + " Index " + j);
					d.appends(tcontents[j]);
					tcontents[i] = d;
					listIndexUsed.add(j);
					// tcontents[i+1] = null;
					i++;
				}
			}
			i++;
		}
		i = 0;
		while (i < tcontents.length) {
			if (tcontents[i] != null) {
				if (tcontents[i] instanceof Numeric)
					;
				// System.out.println("Item : " + tcontents[i].value());
				if (tcontents[i] instanceof Substract) {

					j = i - 1;
					while (j >= 0 && listIndexUsed.contains(j))
						j--;
					// System.out.println("Substraction Occurs index " + i + " Index " + j);
					Substract d = new Substract();
					d.appends(tcontents[j]);
					listIndexUsed.add(j);
					// tcontents[j] = null;
					j = i + 1;
					while (j < tcontents.length && listIndexUsed.contains(j))
						j++;
					// System.out.println("Substraction Occurs index " + i + " Index " + j);
					d.appends(tcontents[j]);
					tcontents[i] = d;
					listIndexUsed.add(j);
					// tcontents[i+1] = null;
					i++;
				}
			}
			i++;
		}
		i = 0;
		while (i < tcontents.length) {
			if (!listIndexUsed.contains(i))
				return tcontents[i];
			i++;
		}
		return null;
	}

	public boolean isConstantInExpression(String expression) {
		int i = 0;
		String term = "";
		while (i < expression.length()) {
			if ((expression.charAt(i) + "").matches("\\d") || (expression.charAt(i) + "").equals(".")) {
				term += (expression.charAt(i) + "");
				if (i == expression.length() - 1) {
					listContents.add(new Numeric(Float.valueOf(term).floatValue()));
				}
			} else if (!(expression.charAt(i) + "").matches("[0-9]")) {
				if (term.equals("")) {
					//
				} else {
					listContents.add(new Numeric(Float.valueOf(term).floatValue()));
				}
				if ((expression.charAt(i) + "").equals("+")) {
					listContents.add(new Add());
				}
				if ((expression.charAt(i) + "").equals("-")) {
					listContents.add(new Substract());
				}
				if ((expression.charAt(i) + "").equals("*")) {
					listContents.add(new Multiply());
				}
				if ((expression.charAt(i) + "").equals("/")) {
					listContents.add(new Divide());
				}
				term = "";
			}
			i++;
		}

		return true;
	}

	public boolean isReferenceInExpression(String expression) {

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
						if (isDouble(term)) {
							row = Integer.parseInt(term);
							term = "";
						} else
							return false;
					if ((expression.charAt(i) + "").equals("]")) {
						if (isDouble(term)) {
							col = Integer.parseInt(term);
							term = "";
						} else
							return false;
						end = true;
					}
					i++;
				}
				if (end == false)
					return false;
				if (row != 0 && col != 0) {
					listContents.add(new Reference(Director.getSpreadsheet().cell(row, col)));
				} else
					return false;
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

		return true;
	}

	public boolean isParenthesisExpression(String expression) {
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
						if (isDouble(term)) {
							row = Integer.parseInt(term);
							term = "";
						} else
							return false;
					if ((expression.charAt(i) + "").equals("]")) {
						if (isDouble(term)) {
							col = Integer.parseInt(term);
							term = "";
						} else
							return false;
						end = true;
					}
					i++;
				}
				if (end == false)
					return false;
				if (row != 0 && col != 0) {
					listContents.add(new Reference(Director.getSpreadsheet().cell(row, col)));
				} else
					return false;
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
				} else if ((expression.charAt(i) + "").equals("(") || (expression.charAt(i) + "").equals(")")) {
					listContents.add(new Text((expression.charAt(i) + "")));
				} else
					indexUsed = false;
				term = "";
			}
			i++;
		}

		return true;
	}

	public Contents[] tContents(List<Contents> list2) {
		Contents[] t = new Contents[list2.size()];
		for (int i = 0; i < list2.size(); i++)
			t[i] = list2.get(i);
		return t;
	}
}
