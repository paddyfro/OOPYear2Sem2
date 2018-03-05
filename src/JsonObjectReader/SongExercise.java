/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonObjectReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author patri
 */
public class SongExercise {

    public static void main(String[] args) throws IOException {
        new SongExercise().start();
    }

    public void start() throws IOException {
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Lady", "Styx", 3.54));
        songs.add(new Song("Back in Black", "AC/DC", 4.21));
        songs.add(new Song("Total Eclipse of the Heart", "Bonnie Tyler", 5.32));

        String fileName = "songs.txt";
        String path = "./";     // current directory
        Boolean append = false; // false=>overwrite, true=>append data at end of existing file
        int bufferSize = 512;   // size of buffer in bytes

        demoBufferedWriter(path, fileName, append, bufferSize, songs);  // create and write to file 

        demoBufferedReader(path, fileName, bufferSize); // read from file

    }

    private void demoBufferedWriter(String path, String fileName, boolean append,
            int bufferSize, ArrayList<Song> list) throws IOException {
        File file = new File(path + fileName);

        FileWriter fileWriter = new FileWriter(file, append);

        // 'Wrap' the fileWriter stream in a BufferedWriter
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, bufferSize);

        System.out.println("Writing songs data to file \"songs.txt\"");
        System.out.println(list.size());
        bufferedWriter.write("{ \"songs\" : [");
        int count = 0;
        // best practice:  use the newline() method to write a newline since all 
        // operating systems may not interpret "\r\n" as a new line sequence
        // writes "\r\n" or "\n" or "\n\r" depending on operating system
        for (Song song : list) {
            bufferedWriter.newLine();
            bufferedWriter.write("\t{ \"name\" : \"" + song.getName() + "\",");
            bufferedWriter.newLine();
            bufferedWriter.write("\t  \"artist\" : \"" + song.getArtist() + "\",");
            bufferedWriter.newLine();
            bufferedWriter.write("\t  \"runningTime\" : " + song.getRunTime());
            bufferedWriter.newLine();
            bufferedWriter.write("\t}");
            count++;
            if(count < list.size())
            {
                bufferedWriter.write(",");
            }
            
            System.out.println("count:@ " + count);
        }
        bufferedWriter.newLine();
        bufferedWriter.write("  ]");
        bufferedWriter.newLine();
        bufferedWriter.write("}");

        // flush() will 'flush the buffer' ensuring that all data is written to the file
        bufferedWriter.flush();

        //close the stream
        bufferedWriter.close();
        System.out.println("Buffer flushed and file closed. Find and open the file \"presidents.txt\"");
    }

    private void demoBufferedReader(String path, String fileName,
            int bufferSize) throws IOException {
        File file = new File(path + fileName);  // create a File object

        FileReader fileReader = new FileReader(fileName); // Create input character stream

        BufferedReader bufferedReader = new BufferedReader(fileReader, bufferSize);  // buffered stream

        System.out.println("Reading line-by-line from file \"songs.txt\"");

        String s;
        while ((s = bufferedReader.readLine()) != null) // read one line at a time
        {
            System.out.println(s);
        }
    }

}
