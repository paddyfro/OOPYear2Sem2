package FileIOimages;

/**
 * This program checks whether a file is a PNG type file or not, 
 * by analyzing its first 8 bytes.
 *
 * All PNG files start with the same 8 bytes (the signature): 
 * In decimal:    137, 80, 78, 71, 13, 10, 26, 10 or 
 * In Hexadecimal: 89, 50, 4E, 47, 0D, 0A, 1A, 0A
 *
 * The second, third and fourth characters are the ASCII values for "PNG", 
 * which have the values 80, 78, 71 (decimal)
 *
 * Lookup PNG File Header on Wikipedia for details.
 *
 */
import java.io.*;
import java.util.Scanner;


public class CheckPNG {

    // first 8 byte values in decimal
    private static int[] pngSignature = {137, 80, 78, 71, 13, 10, 26, 10};

    public static void main(String[] args)
    {
        System.out.print("Please enter file name: ");

        Scanner in = new Scanner(System.in);
        String inputFile = in.nextLine();

        // try with resources
        try (InputStream inputStream = new FileInputStream(inputFile);) {

            int[] headerBytes = new int[8];

            boolean isPNG = true;

            // Read first 8 bytes, one by one, and compare each one
            // with the corresponding expected signature value.
            // If we find a mismatch, then it's not a PNG file
            for (int i = 0; i < 8; i++) {
                headerBytes[i] = inputStream.read();
                if (headerBytes[i] != pngSignature[i]) {
                    isPNG = false;
                    break;
                }
            }

            System.out.println("Is PNG file? " + isPNG); // true or false?

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
