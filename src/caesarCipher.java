package encryption;

import java.util.Scanner;

/**
 * This class implements the Caesar cipher algorithm for encrypting and decrypting text based 
 * on user input.
 */
public class caesarCipher {
	
	/**
	 * This instance variable is how many letters the "shift" of the cipher is.
	 */
	private static int shift;
	
	/**
	 * This method encrypts text based on user input. Non-alphabetic symbols are ignored and
	 * the text is returned in lower-case.
	 */
	public static void encrypt() {
		System.out.println("Enter text to encrypt:");
		String toEncrypt = new Scanner(System.in).nextLine();
		toEncrypt = toEncrypt.toLowerCase();

		String s = "";
		for (int i = 0; i < toEncrypt.length(); i++)
		{
			char c = (char) (toEncrypt.charAt(i) + shift);
			if (c > 'z') {
				s += (char)(toEncrypt.charAt(i) - (26-shift));
			}
			else {
				 s += c;
			}
		}
		
		System.out.print("Text encrypted: ");
		System.out.println(s);
	}
	
	/**
	 * This method decrypts text based on user input. Non-alphabetic symbols are ignored and
	 * the text is returned in lower-case.
	 */
	public static void decrypt() {
		System.out.println("Enter text to decrypt:");
		
		String toDecrypt = new Scanner(System.in).nextLine();
		toDecrypt = toDecrypt.toLowerCase();

		String s = "";
		for (int i = 0; i < toDecrypt.length(); i++)
		{
			char c = (char) (toDecrypt.charAt(i) - shift);
			
			if (c < 'a') {
				s += (char)(toDecrypt.charAt(i) + (26-shift));
			}
				
			else {
				 s += c;
			}
		}
		
		System.out.print("Text decrypted: ");
		System.out.println(s);
	}

	/**
	 * The user is prompted for input in the main() method.
	 */
	public static void main(String[] args) {
		
		while (shift <= 0) {
			System.out.println("Enter a rotation number for encryption or decryption.");
			shift = (new Scanner(System.in).nextInt() % 26);
		} 
		
		char response = 0;
		
		while (response != 'e' && response != 'd') {
			System.out.println("Enter e to encrypt and d to decrypt.");
			response = new Scanner(System.in).next().charAt(0);
		}
		
		if (response == 'e') {
			encrypt();	
		}
		
		else {
			decrypt();
		}
	}
}