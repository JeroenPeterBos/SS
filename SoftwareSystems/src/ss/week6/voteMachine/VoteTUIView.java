package ss.week6.voteMachine;

import java.io.InvalidClassException;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import ss.week6.WrongArgumentException;

public class VoteTUIView implements Observer, VoteView{

	private Scanner scanner;
	private VoteMachine vm;
	
	public VoteTUIView(VoteMachine vm){
		scanner = new Scanner(System.in);
		this.vm = vm;
	}
	
	public void start(){
		boolean running = true;
		while(running){
			System.out.println("Please input command.");
			
			String[] words = scanner.nextLine().split(" ");
			
			if(words.length == 3 && words[0].equals("ADD") && words[1].equals("PARTY")){
				vm.addParty(words[2]);
			} else if(words.length == 2 && words[0].equals("VOTE")){
				vm.vote(words[1]);
			} else if(words.length == 1){
				if(words[0].equals("VOTES")){
					showVotes(vm.getVotes());
				} else if(words[0].equals("PARTIES")){
					showParties(vm.getParties());
				} else if(words[0].equals("EXIT")){
					running = false;
				} else if(words[0].equals("HELP")){
					showError("HELP");
				}
			}
		}
	}
	
	public void showVotes(Map<String, Integer> votes){
		for(Map.Entry<String, Integer> entry : votes.entrySet()){
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	
	public void showParties(List<String> parties){
		for(String party : parties){
			System.out.println(party);
		}
	}
	
	public void showError(String error){
		System.out.println(error);
	}
	
	public void update(Observable obs, Object arg){
		if(!(arg instanceof String)){
			try {
				throw new InvalidClassException("argument 'arg' should be off type String");
			} catch (InvalidClassException e) {
				e.printStackTrace();
			}
		}
		
		String argument = (String) arg;
		if(argument.equals("vote")){
			
			System.out.println("showVotes");
			showVotes(vm.getVotes());
		} else if(argument.equals("party")){
			showParties(vm.getParties());
		} else {
			try {
				throw new WrongArgumentException();
			} catch (WrongArgumentException e) {
				e.printStackTrace();
			}
		}
	}
}
