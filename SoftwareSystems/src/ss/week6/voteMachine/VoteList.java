package ss.week6.voteMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class VoteList extends Observable{

	private Map<String, Integer> votes;
	
	public VoteList(){
		votes = new HashMap<String, Integer>();
	}
	
	public void addVote(String party){
		if(votes.containsKey(party)){
			int no_votes = votes.remove(party);
			votes.put(party, no_votes + 1);
		} else {
			return;
		}
		
		setChanged();
		notifyObservers("vote");
	}
	
	public void newParty(String party, int voteCount){
		votes.put(party, voteCount);
	}
	
	public Map<String, Integer> getVotes(){
		return votes;
	}
}
