package FileIOimages;

/**
 *   Greyscale
 *   Load a PNG file into a BufferedImage,
 *   For each pixel, get the average of the RGB values,
 *   replace the pixel RGB values with the average.
 *   (This will convert a colored image to grayscale)
 * 
 * */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Greyscale {

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

        //convert to grayscale
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = img.getRGB(x, y);

                int a = (pixel >> 24) & 0xff;  // Alpha
                int r = (pixel >> 16) & 0xff;  // Red
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;

                //calculate average
                int avg = (r + g + b) / 3;

                //replace RGB value with avg
                pixel = (a << 24) | (avg << 16) | (avg << 8) | avg;

                img.setRGB(x, y, pixel);
            }
        }

        //write image
        try {
            f = new File("dilbert_boss_greyscale.png");

            ImageIO.write(img, "png", f);

            System.out.println("Outputted: dilbert_boss_greyscale.png");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
