package BufferedWriterBufferedReaderDemo;

/**
 * BufferedReader and BufferedWriter for reading Character Streams
 * 
 * To improve I/O efficiency, a FileReader should wrapped in a BufferedReader.
 * Data will be read in 'chunks' from the storage device and stored in a 
 * block of memory called a Buffer. 
 * read() and readLine() calls will read the data from the buffer.
 * 
 * Similarly, a FileWriter should be wrapped in a BufferedWriter. You must 
 * flush() the buffer before closing the file, which ensures that all data 
 * in the Buffer is written to the storage device.
 *
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedDemo
{
    public static void main( String[] args) throws IOException
    {
           new BufferedDemo().start();
    }
        
    private void start() throws IOException
    {
        String fileName = "presidents.txt";
        String path = "./";     // current directory
        Boolean append = false; // false=>overwrite, true=>append data at end of existing file
        int bufferSize = 512;   // size of buffer in bytes
        
        demoBufferedWriter(path, fileName, append, bufferSize);  // create and write to file 

        demoBufferedReader(path, fileName, bufferSize); // read from file
    }

    private void demoBufferedWriter(String path, String fileName, boolean append, 
                                            int bufferSize) throws IOException
    {
        File file = new File(path + fileName);

        FileWriter fileWriter = new FileWriter(file, append);
        
        // 'Wrap' the fileWriter stream in a BufferedWriter
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, bufferSize);
        
        System.out.println("Writing names to file \"presidents.txt\"");

        bufferedWriter.write("Trump");
        
        // best practice:  use the newline() method to write a newline since all 
        // operating systems may not interpret "\r\n" as a new line sequence
        // writes "\r\n" or "\n" or "\n\r" depending on operating system
        bufferedWriter.newLine(); 

        bufferedWriter.write("Clinton");
        
        bufferedWriter.newLine();

        bufferedWriter.write("Bush");

        // flush() will 'flush the buffer' ensuring that all data is written to the file
        bufferedWriter.flush();
        
        //close the stream
        bufferedWriter.close();
        System.out.println("Buffer flushed and file closed. Find and open the file \"presidents.txt\"");
    }

    private void demoBufferedReader(String path, String fileName, 
                                       int bufferSize) throws IOException
    {
        File file = new File(path + fileName);  // create a File object

        FileReader fileReader = new FileReader(fileName); // Create input character stream
        
        BufferedReader bufferedReader = new BufferedReader(fileReader, bufferSize);  // buffered stream
        
        System.out.println("Reading line-by-line from file \"presidents.txt\"");
        
        String s;
        while( (s=bufferedReader.readLine()) != null)  // read one line at a time
        {
            System.out.println( s ); 
        }
    }
}
