package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;

public class VoteList {

	private Map<String, Integer> votes;
	
	public VoteList(){
		votes = new HashMap<String, Integer>();
	}
	
	public void addVote(String party){
		if(votes.containsKey(party)){
			votes.replace(party, votes.get(party).intValue() + 1);
		} else {
			votes.put(party, 1);
		}
	}
	
	public void newParty(String party){
		votes.put(party, 0);
	}
	
	public Map<String, Integer> getVotes(){
		return votes;
	}
}
