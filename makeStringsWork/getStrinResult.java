
/**
 * Write a description of getStrinResult here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class getStrinResult 
{
    public void doStringOutput(){
        StringBuilder sb = new StringBuilder("Start");
        sb.insert(4,"le");
        System.out.println(sb);
    }
    
        public void doFirstStringOutput(){
        String s = "Start";
        s = s.substring(0,4) + "le" + s.substring(4);
        System.out.println(s);
    }
    
        public void doFirstSubStringOutput(){
        String s = "cgatgaliyfitydytduydthkreiuyk";
        s = s.substring(1,7);
        System.out.println(s);
    }
    
    public String reverse(String s){
        String ret = "";
        for(int k=0; k < s.length(); k+=2){
            ret = s.charAt(k) + ret;
        }
        return ret;
    }
    
    public void runString(){
            System.out.println(reverse("computer")); 
            
    }
}
