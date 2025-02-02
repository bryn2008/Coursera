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
    
    public void encryptTwoKeys() {
        //part 2 of the Caesar Cipher is to encrypte a message with two Keys
        //int key = 15          //Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!
        int key1 = 8;           //two keys = k1-8 & k2-21
        int key2 = 21;          //Io iwjv jz dv bcm kjvammmikz mwju edbc twpz pvb wi awm v ncmxmqnm xvzog. TMGT TJCY!
        
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        //String message = "First Legion!^&()";
        char encrypted = 'x';
        String finalString = "";
        // use and if 2%= 0 the use key1 (set this to the key) and if 
        
        for (int i = 0; i < message.length(); i++){

            char input = message.charAt(i);
            //System.out.println( " >> " + input);
            
            if(i%2 == 0){
                int key = key1;
                encrypted = encryptWithTwokeys(input, key);
                //System.out.println(" >> " + key);
                //System.out.println(" >> " + input);
            }
            else if(i%2 != 0){
                int key = key2;
                encrypted = encryptWithTwokeys(input, key);
                //System.out.println(" >> " + key);
                //System.out.println(" >> " + input);
            }
            
            //System.out.println(" >>>> " + encrypted);
            
            //REBUILD THE STRING HERE       
            finalString = finalString + encrypted;
            
            //System.out.println(" > " + finalString);
            
        }
        
        
        System.out.println("The original message is: " + message);
        
        System.out.println("The encrypted message is: " + finalString);
        
        //String decrypted = encrypt(finalString, 26-key);
        //System.out.println(decrypted);
    }
    
    
    // rebuild to only decrypt one char at a time
    public char encryptWithTwokeys(char input, int key) {      
        //Preserve the case of the original char input
        char originalIO = input;
        //Make the input a capital
        input = Character.toUpperCase(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);

            //take the char from the message and call it currChar
            char currChar = input;
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            
            char encrypted = 'a';
            
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the char of encrypted with newChar
                encrypted = newChar;
            }else{
                encrypted = input;
            }
            
            //Check the case of the input char to see if it is an upper or lowwer case char
            if(Character.isUpperCase(originalIO) != true ){
                //if tie original input char is lower case then change the encrypted to lower case
                encrypted = Character.toLowerCase(encrypted);
            }
            
        //return encrypted char
        return encrypted;
    }
    
    public void eyeballDecrypt(){//String encrpted){
        FileResource fr = new FileResource();
        String encrpted = fr.asString();
        
        CaesarCipher cipher = new CaesarCipher();
        for(int k = 0; k < 26; k++){
            String s = cipher.encrypt(encrpted,k);
            System.out.println(k+""+s);
        }
    }
    
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int k=0; k<vals.length; k++){
            if (vals[k] > vals[maxDex]){
                maxDex= k;
            }
        }
        return maxDex;
    }
    
    public void testdecrypt() {
        String alph = "abcdefghijklmnopqurstxyz";
        int[] counts = new int[26];
        for(int k = 0; k < message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] +=1;
            }
        }
        
    }
    
    public String decrypt(String encrypted){
        CaesarCipher cipher = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4){
            dkey = 26 - (4-maxDex); 
        }
        return cc.encrypt(encrypted,26-dkey);
    }
    
    public void textFingerPrint(String s){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counters = new int[26];
        for(int k=0; k < s.length(); k++){
            char ch = s.charAt(k);
            int index = alpha.indexOf(Character.toLowerCase(ch));
            if(index != -1){
                counters[index] +=1;
            }
        }
        for(int k=0; k < counters.length; k++){
            System.out.println(alpha.charAt(k)+"\t"+counters[k]);
        }
    }
    
    //for loop used with an index example from the summary
    public int indexOf(String[] list, String word) {
        for(int k=0; k<list.length; k++){
            return k;
        }
    }
    return -1;
}

