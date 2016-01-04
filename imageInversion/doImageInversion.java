import edu.duke.*;
import java.io.*;
/**
 * doImageInversion is a program that will invert any image selected and save a new image.
 * 
 * Bryn Lloyd 
 * v0.01 16/12/2015
 */
public class doImageInversion {
    //I Start with the image wanted {inImage}
    public ImageResource makeInveted(ImageResource inImage)
    {
        //I made a blank image of the same size
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        //for each opixel in outImage    
            for(Pixel pixel: outImage.pixels()){
                //look at the corrosponding pixel in inImage
                Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
                //computer inPixel's red + inPixel's blue + inPixel's green
                //devode that sum by 3 (call it averagws)
                int average = (inPixel.getRed()+inPixel.getBlue()+inPixel.getGreen())/3;
                //set pixels's red to average
                pixel.setRed(average);
                //set pixel's green to average
                pixel.setGreen(average);
                //set pixel's blue to average
                pixel.setBlue(average);
            }
        //outImage is your answer
        return outImage;
    }
    /*
        public void selectAndConvertAndSave()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            
          //System.out.println(inImage); 
          
            //Gets the file name and sets the string fname to it 
            String fname = inImage.getFileName();
            //Sets the string newName to contain the "gray-" and the old name
            String newName = "gray-" + fname;
            
          //System.out.println(fname + " is the old name and the new name is " + newName);
            
            //sets the file name of the new image resource to the new "gray-" file name
            gray.setFileName(newName); 
            //draws the new image resources
            gray.draw();
            
          //System.out.println(gray);
          
            //saves the image resources to the root folder of the program
            gray.save();
            //note, this method overwites any files old with the new name
            //this means any image would have to be placed in the root folder
            //this would avoid overwiting any old files
        }
    }
    */
}