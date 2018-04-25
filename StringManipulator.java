package lab2;
import java.util.Scanner;

public class StringManipulator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//User's Starting String
		System.out.println("Enter a string to be manipulated");
		String userString;
		userString = input.nextLine();
		
		//Menu loop. Won't exit unless user chooses to quit program.
		while(true) {
			System.out.println("How would you like to manipulate this string?");
			System.out.println("Reverse");
			System.out.println("Replace");
			System.out.println("Remove");
			System.out.println("Replace one.");
			System.out.println("Quit");
			String userChoice = input.nextLine();
			userChoice = userChoice.toLowerCase();
			
			// userChoice goes through if statements to determine which method to call.
			if(userChoice.equals("reverse")) {
				userString = reverseOrder(userString);
				System.out.println("Your new string is: " + userString);
			}
			
			else if(userChoice.equals("replace")) {
				System.out.println("What character would you like to get rid of?");
				String oldLetter = input.nextLine();
				char oldChar = oldLetter.charAt(0);
				
				//Checks to see if character is in the string
				boolean Flag = Check(userString, oldChar);
				if(Flag == true) {
					System.out.println("Sorry, that character isn't in the string");
					continue;
				}
				
				System.out.println("What character would you like to replace it with?");
				String newLetter = input.nextLine();
				char newChar = newLetter.charAt(0);
				userString = replaceAll(userString, oldChar, newChar);
				System.out.println("Your new string is: " + userString);
			}
			
			else if(userChoice.equals("remove")) {
				System.out.println("What character do you want to remove?");
				String strRemove = input.nextLine();
				char charRemove = strRemove.charAt(0);
				
				//Checks to see if character is in the string
				boolean Flag = Check(userString, charRemove);
				if(Flag == true) {
					System.out.println("Sorry, that character isn't in the string");
					continue;
				}
				
				userString = removeChar(userString, charRemove);
				System.out.println("Your new string is: " + userString);
			}
			
			else if(userChoice.equals("replace one")) {
				System.out.println("What character would you like to get rid of?");
				String oldLetter = input.nextLine();
				char oldChar = oldLetter.charAt(0);
				
				//Checks to see if character is in the string
				boolean Flag = Check(userString, oldChar);
				if(Flag == true) {
					System.out.println("Sorry, that character isn't in the string");
					continue;
				}
			
				System.out.println("Which " + oldLetter + " do you want to replace?");
				int number = input.nextInt();
				//Prevents line skip
				input.nextLine();
				
				System.out.println("What character would you like to replace it with?");
				String newLetter = input.nextLine();
				userString = replaceOneChar(userString, oldChar, number, newLetter);
				System.out.println("Your new string is: " + userString);
			}
			//Ends Program
			else if(userChoice.equals("quit")) {
				System.exit(0);
			}
		}
	}
	//reverseOrder method reverses the order of the string the user input
	public static String reverseOrder(String string) {
		//charArray created from string
		char[] tempString = string.toCharArray();
		char[] tempArray = string.toCharArray();
		
		//The swap
		int j = 0;
		for(int i = string.length() - 1;i >= 0; i--) {
			tempString[j] = tempArray[i];
			j++;
	}
		//String created from charArray
		String finalString = new String(tempString);
		return finalString;
}
	//replaceAll Method replaces all instances of one character and replaces it with another character
	public static String replaceAll(String string, char old, char replace) {
		//charArray created from string
		char[] tempString = string.toCharArray();
		
		//Replaces char user selected
		int j = 0;
		for(int i = 0; i <= string.length() - 1; i++ ) {
			if(old == string.charAt(i)) {
				tempString[i] = replace;
			}
		}
		//String created from charArray
		String finalString = new String(tempString);
		return finalString;
	}
	//removerChar method removes all instances of one character
	public static String removeChar(String string, char remove) {
		String finalString = "";
		
		//creates new string without selected character
		for(int i = 0; i < string.length(); i++ ) {
			if(string.charAt(i) != remove) {
				finalString += string.charAt(i);
			}
		}
		return finalString;
}
	//removeOneChar method removes one instance of a char that the user selects
	public static String replaceOneChar(String string, char old, int location, String newChar) {
		String tempString = "";
		String finalString = "";
		int counter = 0;
		
		//Removes one char - creates new string
		for(int i = 0; i < string.length(); i++ ) {
			if(string.charAt(i) == old) {
				counter++;
				//Checks to see if specified character is the designated one to replace.
				if(counter == location) {
					finalString += newChar;
				}
				//continues building the new string if its not the right specified digit.
				else if(counter != location) {
					finalString += string.charAt(i);
				}
			}
			//continues building the new string
			else if(string.charAt(i) != old) {
				finalString += string.charAt(i);
		}
		}
		return finalString;
}
	//Checks to see if user's input character is in the string
	public static boolean Check(String string, char letter) {
		int counter = 0;
		boolean flag = false;
		
		//Adds 1 to the counter if it finds and instance of the character selected
		for(int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == letter) {
				counter++;
			}
		}
		//If none of selected character is found.
		if(counter == 0) {
			flag = true;
		}
		//if true, the program starts over.
		return flag;
		}
	}
