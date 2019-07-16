package spreadSheet.ContentCell;

import java.util.List;

//import Framework.OneToMany;
import spreadSheet.Contents;
import spreadSheet.util.Associations;

public abstract class NumOperator extends Contents{
	// cellIsReferenceOf is used for association OneToMany with Refences
	public void appends(Contents contents) {
		if(contents != null) Associations.cellsOperateOn.link(this, contents);
	}
	
	public List<Contents> listRefences(){
		return Associations.cellsOperateOn.leftToRights(this);
	}
	
	 

	

	@Override
	public float data() {
		
		return 0;
	}

}
