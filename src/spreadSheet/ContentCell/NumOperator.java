package spreadSheet.ContentCell;

import java.util.List;

import Framework.OneToMany;
import spreadSheet.Contents;
import spreadSheet.util.Associations;

public abstract class NumOperator extends Contents{
	// cellIsReferenceOf is used for association OneToMany with Refences
	public void appends(Reference reference) {
		if(reference != null) Associations.cellIsReferenceOf.link(this, reference);
	}
	
	public List<Reference> listRefences(){
		return Associations.cellIsReferenceOf.leftToRights(this);
	}
	
	 

	

	@Override
	public float data() {
		
		return 0;
	}

}
