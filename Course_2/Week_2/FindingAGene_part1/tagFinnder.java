
/**
 * Write a description of tagFinnder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class tagFinnder {
    public String findProtein(String dna){
        int start = dna.indexOf("atg");
        if(start == -1){
            return"";
        }
        int stop = dna.indexOf("tag",start+3);
        if((stop - start) % 3 == 0){
            return dna.substring(start,stop+3);
        }
        else{
            return "";
        }
    }
    
    public void testing(){
        //String a = "cccatggggtttaaataataataggagagagagagagagttt";
        //String ap = "atggggtttaaataataatag";
        //String a = "atgcctag";
        //String ap = "";
        String a = "ATGCCCTAG";
        String ap = "ATGCCCTAG";
        String result = findProtein(a.toLowerCase());
        if(ap.equals(result)){
            System.out.println("Success for " + ap + " length " + ap.length());
        }
        else{
            System.out.println("mistake for input" + a);
            System.out.println("got" + result);
            System.out.println("not" + ap);
        }
    }
    
    public void realTeasting(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            String s = fr.asString();
            System.out.println("Read " + s.length() + " characters");
            String result = findProtein(s);
            System.out.println("Found " + result);
        }
    }
}
