package berryh.moltencore.common;

import net.minecraft.item.Item;

public class Itemkerogen extends Item{
	
	public Itemkerogen(int i){
		super(i);
	}
	
	public String getTextureFile(){
		return MoltenCoreCommonProxy.ITEM;
	}

}
