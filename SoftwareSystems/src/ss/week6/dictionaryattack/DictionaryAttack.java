package ss.week6.dictionaryattack;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.codec.binary.Hex;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	
	public DictionaryAttack(){
		this.passwordMap = new HashMap<String, String>();
		this.hashDictionary = new HashMap<String, String>();
	}
	
	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws FileNotFoundException 
	 */
	public void readPasswords(String filename) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(filename));
		
		while(scanner.hasNext()){
			String[] data = scanner.nextLine().split(": ");
			passwordMap.put(data[0], data[1]);
		}
		scanner.close();
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
    	MessageDigest md;
    	try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	return Hex.encodeHexString(md.digest(password.getBytes()));
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        if(passwordMap.containsKey(user)){
        	if(passwordMap.get(user).equals(getPasswordHash(password))){
        		return true;
        	}
        }
        return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 * @throws FileNotFoundException 
	 */
    	public void addToHashDictionary(String filename) throws FileNotFoundException {
    	Scanner scanner = new Scanner(new File(filename));
        
        while(scanner.hasNext()){
        	String pass = scanner.nextLine();
        	hashDictionary.put(getPasswordHash(pass), pass);
        }
        scanner.close();
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		for(Map.Entry<String, String> userEntry: passwordMap.entrySet()){
			for(Map.Entry<String, String> passEntry: hashDictionary.entrySet()){
				if(checkPassword(userEntry.getKey(), passEntry.getValue())){
					System.out.println("username: " + userEntry.getKey() + ", password: " + passEntry.getValue());
				}
			}
		}
	}
			
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		try {
			da.readPasswords("C:\\Users\\Jeroen\\Documents\\Studie\\Module2\\newWorkspace\\SS\\SoftwareSystems\\src\\ss\\week6\\test\\leakedPasswords.txt");
			da.addToHashDictionary("C:\\Users\\Jeroen\\Documents\\Studie\\Module2\\newWorkspace\\SS\\SoftwareSystems\\src\\ss\\week6\\dictionaryattack\\commonpasses.txt");
		} catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}
		da.doDictionaryAttack();
	}

}
