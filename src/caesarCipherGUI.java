package encryption;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class caesarCipherGUI extends JPanel{
	
	/**
	 * This is here since the class is serializable.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The variables that are going to store the user's input are declared.
	 */
	private String textToEncrypt;
	private String textToDecrypt;
	
	/**
	 * The label and text area for the shift are declared and instantiated.
	 */
	private JLabel shift = new JLabel("Enter shift:");
	private JTextArea shiftText = new JTextArea(1, 3);
	
	/**
	 * The label and text area for the textToEncrypt are declared and instantiated.
	 */
	private JLabel encrypt = new JLabel("Enter text to encrypt:");
	private JTextArea encryptText = new JTextArea(1, 8);
	
	/**
	 * The label and text area for the textToDecrypt are declared and instantiated.
	 */
	private JLabel decrypt = new JLabel("Enter text to decrypt:");
	private JTextArea decryptText = new JTextArea(1, 8);
	
	/**
	 * The buttons for the user to click are declared and instantiated.
	 */
	private JButton encryptButton = new JButton("Encrypt!");
	private JButton decryptButton = new JButton("Decrypt!");
	
	/**
	 * The label showing the result is declared and instantiated.
	 */
	private JLabel result = new JLabel("");
	
	/**
	 * An inner class for encryption is created.
	 */
	private class EncryptListener implements ActionListener {
		
		/**
		 * The method takes the input for the encryptText text field, shifts it, and shows
		 * the result.
		 */
		public void actionPerformed(ActionEvent a) {
			textToEncrypt = encryptText.getText().toLowerCase();
			int shiftAsInt = Integer.parseInt(shiftText.getText());
			
			String s = "";
			
			for (int i = 0; i < textToEncrypt.length(); i++) {
				char c = (char) (textToEncrypt.charAt(i) + shiftAsInt);
				
				if (c > 'z') {
					s += (char)(textToEncrypt.charAt(i) - (26-shiftAsInt));
				}
				else {
					 s += c;
				}
					
			}

			result.setText("Your text encrypted is " + s);
		}
	}
	
	/**
	 * An inner class for decryption is created.
	 */
	private class DecryptListener implements ActionListener {
		
		/**
		 * The method takes the input for the decryptText text field, shifts it, and shows
		 * the result.
		 */
		public void actionPerformed(ActionEvent a) {
			textToDecrypt = decryptText.getText().toLowerCase();
			int shiftAsInt = Integer.parseInt(shiftText.getText());
			
			String s = "";
			
			for (int i = 0; i < textToDecrypt.length(); i++)
			{
				char c = (char) (textToDecrypt.charAt(i) - shiftAsInt);
				
				if (c < 'a') {
					s += (char)(textToDecrypt.charAt(i) + (26-shiftAsInt));
				}
				else {
					s += c;
				}
					 
			}
	
			result.setText("Your text decrypted is " + s);
		}
	}

	/**
	 * The labels, text areas, and buttons are added to the container in the constructor.
	 */
	public caesarCipherGUI() {
		add(shift);
		add(shiftText);
		
		add(encrypt);
		add(encryptText);
		add(encryptButton);
		
		add(decrypt);
		add(decryptText);
		add(decryptButton);
		add(result);
		encryptButton.addActionListener(new EncryptListener());
		decryptButton.addActionListener(new DecryptListener());
	}

	/**
	 * This method sets the frame for the GUI.
	 */
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Encryption and Decryption");
		frame.setSize(new Dimension(800, 150));
		
		frame.setContentPane(new caesarCipherGUI());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);			
		frame.setVisible(true);
	}
	
	/**
	 * The Event-Dispatch Thread creates and shows the GUI.
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}