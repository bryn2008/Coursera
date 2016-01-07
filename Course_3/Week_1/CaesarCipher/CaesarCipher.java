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
        int key = 17;        
        FileResource fr = new FileResource();
        String messageInput = fr.asString();
        //makes the message upper case
        String message = messageInput.toUpperCase();
        //make the input String all in capitials
        System.out.println("This is the messageInput: " + messageInput);
        System.out.println("This is the message in capials: " + message);        
        //call the encrypt method
        String encrypted = encrypt(message, key);
        //show the new encrypted string#
        System.out.println("This is the encrypted string: " + encrypted);
        //Make the nee encrypted message all in lower case
        String eToLowCase = encrypted.toLowerCase();
        String finalString = "";
        System.out.println("This is the encrypted method all in lower case: " + eToLowCase);
        
        //make the string a lower case again if not originally lower case
        //use a for loop or compare the two char
        //need to accomodate for the char not being the same
        //use the Character.isUpperCase(char ch) method
        for(int k=0; k < messageInput.length(); k++){
            //Loop through and see if the char is a capital
            System.out.println(Character.isUpperCase(messageInput.charAt(k)));
            //check to see if the messageInput case is equal case to the message output
            if(Character.isUpperCase(messageInput.charAt(k)) == true ){
                //set the caracter in the new encrypted string to uppercase 
                //eToLowCase = eToLowCase.substring(k).toUpperCase();
                
                //Character.toUpperCase(eToLowCase.charAt(k));
                
                //// eToLowCase = Character.toUpperCase(eToLowCase.charAt(k)) + eToLowCase.substring(1); 
                System.out.println( ">> " + Character.toUpperCase(eToLowCase.charAt(k)) );
                System.out.println( ">> " + eToLowCase.substring(1) ); 
                finalString = finalString + eToLowCase.substring(k,k+1).toUpperCase();
                
                //char first = Character.toUpperCase(eToLowCase.charAt(k));
                
            }    else {
                finalString = finalString + eToLowCase.substring(k,k+1);
            }
            
        }
        
        System.out.println( "finalString = " + finalString );
        
        //original message input
        System.out.println("The messageInput is: " + messageInput);
        
        //System.out.println(Character.isUpperCase('c'));
        System.out.println("The new encrypted message output is: " + eToLowCase);

        System.out.println("The original encrypted message: " + encrypted);    //old original string
        String decrypted = encrypt(finalString, 26-key);      //encrypted should be replaced with finalString
        System.out.println(decrypted);
    }
    
    public void encryptTwoKeys(String input, int key1, int key2) {
        //part 2 of the Caesar Cipher is to encrypte with two Keys
    }
}

