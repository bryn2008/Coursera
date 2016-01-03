
import edu.duke.*;
//import java.util.*;

public class WordPlay {
    
    public void isVowel(char ch){  //pass a String through to be tested for a vowel ||
        
        if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
         || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        return false;
    }
    
    public void replaceVowels (){

        //String phrase = "Hello World";
        //char ch = '*';
        
        StringBuilder sb = new StringBuilder(phrase);
        
        for (int k=0; k < sb.length(); k++) {   
            if (sb.charAt(isVowel(k))) {  
                 sb.setCharAt(k, ch);
            }
        }
    }
    
    public void emphasize (){
        
    }

}
