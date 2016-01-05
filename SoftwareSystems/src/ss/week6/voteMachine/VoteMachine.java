package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

import ss.week6.voteMachine.gui.VoteGUIView;

public class VoteMachine {

	private PartyList partyList;
	private VoteList voteList;
	private VoteView ui;
	
	public VoteMachine(){
		ui = new VoteTUIView(this);
		partyList = new PartyList();
		partyList.addObserver(ui);
		voteList = new VoteList();
		voteList.addObserver(ui);
	}
	
	public void start(){
		ui.start();
	}
	
	public void addParty(String party){
		partyList.addParty(party);
		voteList.newParty(party, 0);
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
