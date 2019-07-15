package spreadSheet.util;

import Framework.*;
import spreadSheet.Cell;
import spreadSheet.Contents;
import spreadSheet.ContentCell.NumOperator; 

public class Associations
{
	static public OneToOne<Cell, Contents> cellIsMadeOfContents = new OneToOne<Cell, Contents>("Contains", "Belongs To", "Owner", "Contents");
	static public OneToMany<NumOperator, Contents> cellsOperateOn = new OneToMany<NumOperator, Contents>("Operation", "operates", "Content", "Renference");
	
	static public String report()
	{
		StringBuilder str = new StringBuilder();
		
		str.append(cellIsMadeOfContents);
		
		return str.toString();
	}

}
