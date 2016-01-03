package ss.week6.voteMachine;

import java.util.LinkedList;
import java.util.List;

public class PartyList {

	private List<String> parties;
	
	public PartyList(){
		parties = new LinkedList<String>();
	}
	
	public void addParty(String party){
		parties.add(party);
	}
	
	public boolean hasParty(String party){
		return parties.contains(party);
	}
	
	public List<String> getParties(){
		return parties;
	}
}
