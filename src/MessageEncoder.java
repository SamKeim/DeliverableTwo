import java.util.Scanner;

public class MessageEncoder {
	public static void main(String[] args) {
		// Deliverable 2 - Prework
		
		String input;
		String message = ""; // if declared outside of loop, has to be initialized to a null value
		int checkSum = 0; // same as above
		char character;
		String userChoice;
		int ascii;
		
		System.out.println("Would you like to use our A1Z26 Cipher? (Y/N)");
		Scanner scan = new Scanner(System.in);
		
		userChoice = scan.nextLine(); //get user input and assign to variable
		
		//Check for breakage
		while (!(userChoice.equalsIgnoreCase("Y")) && !(userChoice.equalsIgnoreCase("N"))) {
			System.out.println("Please try again (Y/N)");
			userChoice = scan.nextLine();
		}
		
		if (userChoice.equalsIgnoreCase("N")) {
			System.out.println("Thank you, goobye."); //Exit condition
		}
		else {
			while (userChoice.equalsIgnoreCase("Y")) {				
				System.out.println("Please enter the phrase you would like to encode.");
				input = scan.nextLine();
				input = input.toUpperCase(); // Needs to be in uppercase, ascii 'a' evaluates to different integer than 'A'.
				
				for (int i = 0; i < input.length(); i++) {
					character = input.charAt(i); // Assigns i character to char type
					ascii = (int) character; //Casts to int (ascii value)
					checkSum = checkSum + ascii; //Adds to checkSum
					ascii = ascii - 64; //Subtracts starting code, A = 65 - 64 = 1
					message = message + (int) ascii + "-";	// adds '-' to integer and casts to String
				}
			
				message = message.substring(0,message.length() - 1); // removes "-" from end of message
			
				System.out.println("Your message is " + input);
				System.out.println("Your encoded message is " + message);
				System.out.println("Message checkSum is " + checkSum);
				System.out.println("Would you like to encode another message? (Y/N)");
				userChoice = scan.nextLine();
	
				//Test for breakage
				while (!(userChoice.equalsIgnoreCase("Y")) && !(userChoice.equalsIgnoreCase("N"))) {
					System.out.println("Please try again (Y/N)");
					userChoice = scan.nextLine();
				}
			
				//Exit condition
				if(userChoice.equalsIgnoreCase("N")) {
					System.out.println("Thank you, goodbye.");
				}
			}
		}
	}
}
