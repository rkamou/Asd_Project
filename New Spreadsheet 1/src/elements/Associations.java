package elements;

import Framework.*;

public class Associations
{
	static public OneToOne<Cell, Contents> cellIsMadeOfContents = new OneToOne<Cell, Contents>("Contains", "Belongs To", "Owner", "Contents");
	static public OneToMany<Cell, Cell> cellIsReferenceOf = new OneToMany<Cell,Cell>("Contains", "reference", "Owner", "Renference");
	
	static public String report()
	{
		StringBuilder str = new StringBuilder();
		
		str.append(cellIsMadeOfContents);
		
		return str.toString();
	}

}
