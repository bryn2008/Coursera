
//import sdu.duke.*;
import java.util.*;

public class WordPlay {
    
    public boolean isVowel (char ch) {
        //Checks the char passed into the method isVowel to see if the char is a vowel
        //note both upper and lower case vowels have been checked in the if statment
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
            || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;    
        }    	
        return false;
        //Returns true if the char is a vowel and false if it is not a vowel
    }    
 
    public void replaceVowels(){
        //Created a String named phase for the input phrase and converted to a char Array named ch
        String phase = "Hello World, HOW IS YOUR DAY?";
        char[] ch = phase.toCharArray();
        
        //A for loop to loop through each instace of a char in the string phase
        for(int i = 0; i < phase.length(); i++){
            if (isVowel(ch[i])) {   //calls the isVowel method to check if th char is a vowel
                ch[i] = '*';     //replace the letter with *
            }
        }
        //Print out the new ch
        System.out.println(ch);

    }    

    public boolean isOdd (char ch) {
        //Checks the char passed into the method isVowel to see if the char is a vowel
        //note both upper and lower case vowels have been checked in the if statment
        if (ch == 'a' || ch == 'A' ) {
            return true;    
        }    	
        return false;
        //Returns true if the char is a vowel and false if it is not a vowel
    }
    
    public boolean isEven (char ch) {
        //Checks the char passed into the method isVowel to see if the char is a vowel
        //note both upper and lower case vowels have been checked in the if statment
        if (ch == 'a' || ch == 'A' ) {
            return true;    
        }    	
        return false;
        //Returns true if the char is a vowel and false if it is not a vowel
    }     
    
    public void emphasize(){
        //Created a String named phase for the input phrase and converted to a char Array named character
        String phase = "Mary Bella Abracadabra";
        char[] character = phase.toCharArray();
        
        //A for loop to loop through each instace of a char in the string phase
        for(int i = 0; i < phase.length(); i++){
            if (isOdd(character[i])) {    //calls the isOdd method to check if th char is.......
                character[i] = '*';       //replace the letter with *
                if(isEven(character[i])){ //calls the isOdd method to check if th char is.......
                    character[i] = '+';   //replace the letter with +
                }
            }
            

        }
        //Print out the new ch
        System.out.println(character);
    }    

    //Area for testing code
    public void testArea(){
        //String ch = "ABCDASDFAW";
        //ch = ch.toLowerCase();
        //System.out.println(ch);

        
    }
    
}
