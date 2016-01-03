package ss.week6;

import java.util.Scanner;

public class Hello {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		while(true){ 
			System.out.print("Line (or \"end\"): ");
			
			String sentence = in.nextLine();
			if(sentence.equals("end")){
				System.out.println("End of programme.");
				break;
			}
			
			String[] words = sentence.split(" ");
			for(int i = 0; i < words.length; i++){
				System.out.println("Words " + i + ": " + words[i]);
			}
		}
		in.close();
	}
}
