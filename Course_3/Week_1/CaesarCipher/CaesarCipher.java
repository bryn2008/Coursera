import edu.duke.*;
//import java.util.*;

public class CaesarCipher {
    
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);        
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    
    public void testCaesar() {
        int key = 15;        
        FileResource fr = new FileResource();
        String messageInput = fr.asString();
        
       //makes the message upper case
        String message = messageInput.toUpperCase();
        
        //make the input String all in capitials
        System.out.println("This is the message: " + messageInput);
        System.out.println("This is the New message: " + message);        
        
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        
        //make the string a lower case again if not originally lower case
        //use a for loop or compare the two char
        for(int k=0; k < messageInput.length(); k++){
            //check to see if the messageInput case is equal case to the message output
            //if(messageInput){
                
            //}
              
        }
        
        //need to accomodate for the char not being the same
        //use the isUpperCase(char ch) method
        
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    
    public void encryptTwoKeys(String input, int key1, int key2) {
        //part 2 of the Caesar Cipher is to encrypte with two Keys
    }
}

