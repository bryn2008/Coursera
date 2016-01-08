import edu.duke.*;
import java.io.File;
public class GrayScaleConverter {
    //I started with the image I wanted (inImage)
    public ImageResource makeGray(ImageResource inImage)
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
    
    public void testGray()
    {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    
    public void selectAndConvert()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource gray = makeGray(inImage);
            gray.draw();
        }
    }

    public void doSave()
    {
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fname = image.getFileName();
            String newName = "copy-" + fname;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }
    
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
}