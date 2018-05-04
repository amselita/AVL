

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public final class Shell {
	/**
	 * utlilty class
	 */
	private Shell() {
	}
	
	

	private static void execute (BufferedReader stdin)
	throws IOException {
		try {
			boolean quit = false;
			Trie trie = new Trie();
			while (!quit) {
				System.out.print("trie> ");
				String input = stdin.readLine();
				if (input == null) {
					break;
				}
				
				//split input on white spaces
				String [] tokens = input.trim().split("\\s+");
				String command = tokens[0].toUpperCase();
				String key = "";
				int value = -1;
				if(tokens.length >= 2) {
					key = tokens[1];
					if(tokens.length == 3) {
						value = Integer.parseInt(tokens[2]);	
					}
				}
				

				if (command.equals("NEW") || command.equals("N")) {
					trie = new Trie();
				} else if(command.equals("ADD") || command.equals("A")) {
					if(tokens.length > 2) {
						trie.add(key, value);						
					} else {
						System.out.println("Error! ADD requires 2 parameters");
					}
				} else if(command.equals("CHANGE") || command.equals("C")) {
					if(tokens.length > 2) {
						trie.change(key, value);						
					} else {
						System.out.println("Error! CHANGE requires 2 parameters");
					}
				} else if(command.equals("DELETE") || command.equals("D")) {
					if(tokens.length > 1) {
						trie.delete(key);						
					} else {
						System.out.println("Error! DELETE requires 2 parameters");
					}
				} else if(command.equals("POINTS") || command.equals("P")) {
					if(tokens.length > 1) {
						System.out.println(trie.getPoints(key));						
					} else {
						System.out.println("Error! POINTS requires 2 parameters");
					}
				} else if(command.equals("TRIE") || command.equals("T")) {
					System.out.println(trie.toString());
				} else if(command.equals("HELP") || command.equals("H")) {
					System.out.println ("The following commands are supported:");
					System.out.println ("NEW        New (empty) trie is created, if necessary, existing trie is discarded");
					System.out.println ("ADD s x    Add new key s with value x (need to be an integer)");
					System.out.println ("CHANGE s x Sets the value of the key s to x");
					System.out.println ("DELETE S   Deletes key s");
					System.out.println ("POINTS s   Prints value of the key s");
					System.out.println ("TRIE       Prints entire trie");
					System.out.println ("QUIT       Stops the program");
			
				} else if(command.equals("QUIT") || command.equals("Q")) {
					quit = true;
				} else {
					System.out.println("Error! Invalid command.");
				}
			}	
		} catch (IOException e) {
			System.out.println("Error! Execution not possible.");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		execute(stdin);