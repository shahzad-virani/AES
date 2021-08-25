import java.security.*;
import javax.crypto.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class AES {

	public static void main(String[] args) throws IOException, 
	NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
	IllegalBlockSizeException, BadPaddingException {
		System.out.println("Enter Text to Encrypt") ;
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    String inputString = br.readLine();
	    byte[] plainText = inputString.getBytes("UTF-8");
	
	    // generate a private AES key 
	    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	    keyGen.init(128);
	    Key key =keyGen.generateKey();
	
	    // get an AES cipher object and print 
	    Cipher cipher =Cipher.getInstance("AES/ECB/PKCS5Padding");
	
	    // encrypt using the key 
	    cipher.init(Cipher.ENCRYPT_MODE,key);
	    byte[] cipherText =cipher.doFinal(plainText);
	    System.out.println( "Encrypted text: ");
	    System.out.println( new String(cipherText, "UTF-8"));
        
        System.out.println("\n\nText to Dencrypt") ;
        //String input = br.readLine(); 
        System.out.println( new String(cipherText, "UTF-8"));

	    // decrypt the ciphertext using the same
	    cipher.init(Cipher.DECRYPT_MODE,key);
	    byte[] newPlainText =cipher.doFinal(cipherText);
	    System.out.println( "Decrypted text: ");
	    System.out.println( new String(newPlainText, "UTF-8") );
	    }
	}


