package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

public class VoteMachine {

	private PartyList partyList;
	private VoteList voteList;
	private VoteTUIView tui;
	
	public VoteMachine(){
		partyList = new PartyList();
		voteList = new VoteList();
		tui = new VoteTUIView(this);
	}
	
	public void start(){
		tui.start();
	}
	
	public void addParty(String party){
		partyList.addParty(party);
		voteList.newParty(party);
	}
	
	public void vote(String party){
		voteList.addVote(party);
	}
	
	public List<String> getParties(){
		return partyList.getParties();
	}
	
	public Map<String, Integer> getVotes(){
		return voteList.getVotes();
	}
	
	public static void main(String[] args){
		VoteMachine voteMachine = new VoteMachine();
		voteMachine.start();
	}
}
