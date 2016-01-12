
import edu.duke.*;

public class readUrlFile {
    
    public void readURL(){
        System.setProperty("http.proxyHost", "webproxy.metoffice.gov.uk" );
        System.setProperty("http.proxyPort", "8080");
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        
        for (String s : ur.lines()) {
             // print or process s
             System.out.println(s);
        }
    }
    
    public void testing(){

    }

}