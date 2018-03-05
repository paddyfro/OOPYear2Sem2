package FileIOimages;

/**
 * Opens a PNG image file and loads the image data,
 * Extracts the A-RGB values form the first pixel
 * and displays those values. 
 * Modifies the first pixel of the image and writes
 * the modified image to new output PNG file.
 * 
*/
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageRGB {

    public static void main(String args[]) throws IOException
    {
        BufferedImage img = null;
        File f = null;

        //read image
        try {
            f = new File("dilbert_boss.png");
            
            img = ImageIO.read(f);  //read all the image pixels
            
        } catch (IOException e) {
            System.out.println(e);
        }

        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();

        //get first pixel value - four bytes stored in an int
        int pixel = img.getRGB(0, 0);  // formatted in ARGB order 

        //get alpha value
        int alpha = (pixel >> 24) & 0xff; // move leftmost byte right by 24 bits.
                                      // apply logical AND to zero out all 
                                      // but the rightmost 8 bits.

        //get red value
        int red = (pixel >> 16) & 0xff; // move second byte right by 16 bits

        //get green 
        int green = (pixel >> 8) & 0xff;  // move third byte right by 8 bits 

        //get blue
        int blue = pixel & 0xff;
        
        System.out.println("Info on First Pixel - ARGB values:");
        System.out.println("Alpha value (decimal): " + alpha);
        System.out.println("Red value (decimal): " + red);
        System.out.println("Green value (decimal): " + green);
        System.out.println("Blue value (decimal): " + blue);
 
        
        /**
         * to keep the project simple we will set the ARGB 
         * value of the first pixel to Red 
         * (i.e. 255, 255, 0 and 0 respectively)
         */
        alpha = 255;  // opaque (i.e. no transparent)
        red = 255;    // full-on red !
        green = 0;    // no green 
        blue = 0;     // no blue

        //set the pixel value
        pixel = (alpha << 24) | (red << 16) | (green << 8) | blue;

        img.setRGB(0, 0, pixel);  // set pixel at (0,0) to new value

        //write image to a file
        try {
            f = new File("dilbert_boss_modified.png");
            
            ImageIO.write(img, "png", f);
            
            System.out.println("Outputted: dilbert_boss_modified.png");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
