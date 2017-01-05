package encryption;

import java.util.Scanner;

/**
 * This class implements the rotation-13 algorithm for encrypting and decrypting text based on
 * user input.
 */
public class ROT13 {
	
	/**
	 * This method encrypts text based on user input. Non-alphabetic symbols are ignored and
	 * the text is returned in lower-case.
	 */
	public static void encrypt() {
		
		System.out.println("Enter text to encrypt in ROT13:");
		
		Scanner sc1 = new Scanner(System.in);
		String toEncrypt = sc1.nextLine();
		toEncrypt = toEncrypt.toLowerCase();

		char[] newText = new char[toEncrypt.length()];
		
		for (int i = 0; i < toEncrypt.length(); i++) {
			char c = toEncrypt.charAt(i);
			
			if (c >= 'a' && c <= 'm') { 
				c+= 13;
			
			}
			
			else if (c >= 'n' && c <= 'z') {
				c-= 13;
			}
			
			newText[i] = c;
		}
		
		System.out.print("Text encrypted: ");
		System.out.println(newText);
	}
	
	/**
	 * This method decrypts text based on user input. Non-alphabetic symbols are ignored and
	 * the text is returned in lower-case.
	 */
	public static void decrypt() {
		System.out.println("Enter text to decrypt in ROT13:");
		
		Scanner sc1 = new Scanner(System.in);
		String toDecrypt = sc1.nextLine();
		toDecrypt = toDecrypt.toLowerCase();

		char[] newText = new char[toDecrypt.length()];
		
		for (int i = 0; i < toDecrypt.length(); i++) {
			char c = toDecrypt.charAt(i);
			
			if (c >= 'a' && c <= 'm') {
				c+= 13;
			}
			
			else if ( c >= 'n' && c <= 'z') {
				c-= 13;
			}
			
			newText[i] = c;
		}
		
		System.out.print("Text decrypted: ");
		System.out.println(newText);
	}
	
	/**
	 * The user is prompted for input in the main() method.
	 */
	public static void main(String[] args) {
		
		char response = 0;
		
		while (response != 'e' && response != 'd') {
			
			System.out.println("Enter e to encrypt and d to decrypt.");
			
			Scanner sc = new Scanner(System.in);
			response = sc.next().charAt(0);
		}
		
		if (response == 'e') {
			encrypt();
		}
		
		else {
			decrypt();
		}
	}

}