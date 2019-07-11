package elements;

public class Director
{
	private Spreadsheet spreadsheet;	

	public Director(Spreadsheet sps)
	{
	spreadsheet = sps;
	}

	public Spreadsheet getSpreadsheet() { return spreadsheet; }

	public void writeInCellText(int r, int c, String text)
	{
		if (text != null)
			spreadsheet.cell(r, c).setContent(new Text(text));	
	}
	public void writeInCellNumber(int r, int c, Double number) {
		if(number!=null)
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
		writeInCellNumber(1, 2, 485.15);

		writeInCellText(1, 3, "");
		writeInCellText(1, 4, "What we pay to the airlines");

		writeInCellText(2, 1, "Taxi:");
		writeInCellNumber(2, 2, 118.0);

		writeInCellText(3, 1, "Rental Car:");
		writeInCellNumber(3, 2, 295.85);
		writeInCellText(4, 1, "Hotel:");
		writeInCellNumber(4, 2, 431.0);

		writeInCellText(5, 1, "Meals:");
		writeInCellNumber(5, 2, 150.0);
		writeInCellText(5, 3, "");
		writeInCellText(5, 4, "This is all our meals");
		

		writeInCellText(7, 1, "Sub-total:");
		Reference ref=new Reference(new Cell(1,2));
		cell(7,2).setContent(ref);

		writeInCellText(8, 1, "Tax:");	
		writeInCellNumber(8, 2, 0.15);// Tax factor label

		writeInCellText(9, 1, "Total:");

		writeInCellText(10, 1, "Partners: ");
		writeInCellNumber(10, 2, 4.0);

		writeInCellText(11, 1, "Months: ");
		writeInCellNumber(11, 2, 12.0);

		writeInCellText(12, 1, "Installments:");

	}

}
