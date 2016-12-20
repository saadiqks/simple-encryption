package encryption;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ROT13GUI extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private String textToEncrypt;
	private String textToDecrypt;
	
	private JLabel encrypt = new JLabel("Enter text to encrypt:");
	private JTextArea encryptText = new JTextArea(1, 8);
	
	private JLabel decrypt = new JLabel("Enter text to decrypt:");
	private JTextArea decryptText = new JTextArea(1, 8);
	
	private JButton encryptButton = new JButton("Encrypt!");
	private JButton decryptButton = new JButton("Decrypt!");
	
	private JLabel result = new JLabel("");
	
	private class EncryptListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			textToEncrypt = encryptText.getText().toLowerCase();
			
			char[] newText = new char[textToEncrypt.length()];
			
			for(int i = 0; i < textToEncrypt.length(); i++)
			{
				char c = textToEncrypt.charAt(i);
				if (c >= 'a' && c <= 'm') c+= 13;
				else if ( c >= 'n' && c <= 'z') c-= 13;
				
				newText[i] = c;
			}
			
			String newTextString = new String(newText);
			result.setText("Your text encrypted is " + newTextString);
		}
	}
	
	private class DecryptListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			textToDecrypt = decryptText.getText().toLowerCase();
			
			char[] newText = new char[textToDecrypt.length()];
			
			for(int i = 0; i < textToDecrypt.length(); i++)
			{
				char c = textToDecrypt.charAt(i);
				if (c >= 'a' && c <= 'm') c+= 13;
				else if ( c >= 'n' && c <= 'z') c-= 13;
				
				newText[i] = c;
			}
			
			String newTextString = new String(newText);
			result.setText("Your text decrypted is " + newTextString);
		}
	}

	public ROT13GUI() {
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
	
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Encryption and Decryption");
		frame.setSize(new Dimension(700, 150));
		
		frame.setContentPane(new ROT13GUI());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);			
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
