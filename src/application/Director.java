package application;

import spreadSheet.Cell;
import spreadSheet.Spreadsheet; 
import spreadSheet.ContentCell.Numeric;
import spreadSheet.ContentCell.Reference;
import spreadSheet.ContentCell.Text;
import spreadSheet.factory.concrete.contents.FContents;
import spreadSheet.operations.Add;
import spreadSheet.operations.Multiply;

public class Director
{
	private static Spreadsheet spreadsheet;	
	
	private FContents cellFactory = new FContents();
	
	public Director(Spreadsheet sps)
	{
	spreadsheet = sps;
	}

	public static Spreadsheet getSpreadsheet() { return spreadsheet; }

	public void writeInCellText(int r, int c, String text)
	{
		if (text != null)
			spreadsheet.cell(r, c).setContent(new Text(text));	
	}
	public void writeInCellNumber(int r, int c, float number) {
		
			spreadsheet.cell(r, c).setContent(new Numeric(number));
	}

	public Cell cell(int row, int col) 							// Get a reference to cell at (row,col)
	{ 
		return spreadsheet.cell(row, col); 
	}		

	public String contents()
	{
		return spreadsheet.show();
	}

	public String describe()
	{
		return spreadsheet.describe();
	}

	public String examine()
	{
		return spreadsheet.examine();
	}
	
	public void buildSample()										// Build sample data for development purpose
	{
		writeInCellText(1, 1, "Airfare:");
		writeInCellNumber(1, 2, 485.15F);

		writeInCellText(1, 3, "");
		writeInCellText(1, 4, "What we pay to the airlines");

		writeInCellText(2, 1, "Taxi:");
		writeInCellNumber(2, 2, 118);

		writeInCellText(3, 1, "Rental Car:");
		writeInCellNumber(3, 2, 295.85F);
		writeInCellText(4, 1, "Hotel:");
		writeInCellNumber(4, 2, 431);

		writeInCellText(5, 1, "Meals:");
		writeInCellNumber(5, 2, 150);
		writeInCellText(5, 3, "");
		writeInCellText(5, 4, "This is all our meals");
		

		writeInCellText(7, 1, "Sub-total:");
		Add add = new Add();
		add.appends(new Reference(cell(1,2)));
		add.appends(new Reference(cell(2, 2)));
		add.appends(new Reference(cell(3, 2)));
		add.appends(new Reference(cell(4, 2)));
		add.appends(new Reference(cell(5, 2)));
		cell(7,2).setContent(add);
		spreadsheet.cell(7, 3).setContent(cellFactory.CreateContent("[1,2]+[2,2]+[3,2]+[4,2]+[5,2]"));
		writeInCellText(7, 4, " Subtotal of items listed above");

		
		//writeInCellText(7, 4, "This is just a refernce to [1,2], to test the \"Reference\" class and mechanism");

		writeInCellText(9, 1, "Tax:");	
		writeInCellNumber(9, 2, 0.15F);// Tax factor label

		writeInCellText(10, 1, "Total:");//(T = st(1-refTax) = st-st*refTax 
		spreadsheet.cell(10, 2).setContent(cellFactory.CreateContent("[7,2]-[7,2]*[9,2]"));
//		writeInCellNumber(9, 2, (float)(Double.valueOf(cell(7, 2).value())*Double.valueOf(cell(8, 2).value())));
//		Reference ref=new Reference(cell(8, 2));
//		cell(9,2).setContent(ref);
//		writeInCellText(12, 4, "This is just a refernce to [1,2], to test the \"Reference\" class and mechanism");

		//writeInCellText(12, 1, "Partners: ");
		spreadsheet.cell(12, 1).setContent(cellFactory.CreateContent("Partners: "));
		spreadsheet.cell(12, 2).setContent(cellFactory.CreateContent("4"));
		
		spreadsheet.cell(13, 1).setContent(cellFactory.CreateContent("Months: "));
		spreadsheet.cell(13, 2).setContent(cellFactory.CreateContent("12"));
		
		spreadsheet.cell(15, 1).setContent(cellFactory.CreateContent("Instalments: "));
		spreadsheet.cell(15, 2).setContent(cellFactory.CreateContent("[10,2]/[12,2]/[13,2]"));
		spreadsheet.cell(15, 4).setContent(cellFactory.CreateContent("Instalments Computation : SubTotal / Partners / Months"));
//		Reference ref=new Reference(cell(9, 2));
//		cell(12,2).setContent(ref);
//		writeInCellNumber(10, 2, 4);
//
//		writeInCellText(11, 1, "Months: ");
//		writeInCellNumber(11, 2, 12);
//
//		writeInCellText(12, 1, "Installments:");
//		//writeInCellNumber(12, 2, 0);
//		 
//		Multiply mult = new Multiply();
//		mult.appends(new Reference(cell(7, 2)));
//		mult.appends(new Reference(cell(8, 2)));
//		writeInCellText(13, 1, "Total * Partners:");
//		spreadsheet.cell(13, 2).setContent(cellFactory.CreateContent("[1,2]+6.1+2*2-5+[2,2]"));

		//cell(13, 2).setContent(mult);
		//spreadsheet.cell(11, 2).setContent(new Complex());  
		//spreadsheet.cell(11, 2).setFormula("5.1+6.1+2*2-5");
		//spreadsheet.cell(11, 2).setContent(cellFactory.CreateContent("4.2+6.1+2*2-5"));
		//spreadsheet.cell(12, 2).setContent(cellFactory.CreateContent("[1,2]+6.1+2*2-5+[2,2]"));
		//cellFactory
	}

}
