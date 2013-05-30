package berryh.moltencore.common.trigger;

import buildcraft.api.gates.Trigger;


public abstract class TriggerMCM extends Trigger {
	
	public boolean needsID = true;
	
	public TriggerMCM() {
		super(900);
	}
	
	public void setID(int theID){
		this.id = theID;
		buildcraft.api.gates.ActionManager.triggers[this.id] = this;
		this.needsID = true;
	}
	
	public boolean needsID(){
		return this.needsID;
	}

}
