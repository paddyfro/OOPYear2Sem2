package FileIOCharacterStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainApp 
{

	public static void main(String[] args) 
	{
		MainApp theApp = new MainApp();
		try {
			theApp.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void start() throws IOException 
	{
		/************************** File Writer & Reader **************************/
		String strName = "demoFileWriterReader.txt";
		String strPath = "c:/temp/";
		boolean bAppend = false;
		demoFileWriter(strPath, strName, bAppend);
		demoFileReader(strPath, strName);
		
		
		/************************** Buffered Writer & Reader **************************/
		strName = "demoBufferedWriterReader.txt";
		strPath = "c:/temp/";
		bAppend = false;
		int bufferSize = 10;
		demoBufferedWriter(strPath, strName, bAppend, bufferSize);
		
		//to do...
		demoBufferedReader(strPath, strName, bufferSize);
		
		/************************** PrintWriter **************************/
		strName = "demoPrintWriter.csv";
		strPath = "c:/temp/";
		bAppend = false;
		bufferSize = 1024;
		demoPrintWriter(strPath, strName, bAppend, bufferSize);	
		
		/************************** XML **************************/
		//song data in a list!
		List<Song> list = new ArrayList<Song>();
		list.add(new Song("name1", "artist1", (float)3.25));
		list.add(new Song("name2", "artist2", (float)2.85));
		list.add(new Song("name3", "artist3", (float)2.6));
		
		//serialize song data from a list to XML
		strName = "demoListToXML.xml";
		strPath = "c:/temp/";	
		demoListToXML(strPath, strName, list);

		/************************** HTML **************************/
		//serialize song data from a list to HTML
		strName = "demoListToHTML.html";
		strPath = "c:/temp/";	
		demoListToHTML(strPath, strName, list);
		
		System.out.println("done!");
	}

	private void demoListToXML(String strPath, 
			String strName, List<Song> list) throws FileNotFoundException 
	{
		PrintWriter pWriter = new PrintWriter(strPath + strName);
		
		pWriter.println("<xml>");
		pWriter.println("<catalogue>");
		for(Song s : list)
		{
			pWriter.println("<song>");
			pWriter.println(s.toXML());
			pWriter.println("</song>");
		}
		pWriter.println("</catalogue>");
		pWriter.println("</xml>");
		pWriter.close();	
	}
	
	private void demoListToHTML(String strPath, 
			String strName, List<Song> list) throws FileNotFoundException 
	{	
		PrintWriter pWriter = new PrintWriter(strPath + strName);
			
		pWriter.println("<html>");
		pWriter.println("<head><title>Songs</title></head>");
		pWriter.println("<body>");
		pWriter.println("<table border='1'>");		
		pWriter.println("<tr><td>Name</td><td>Artist</td><td>Running Time</td></tr>");

		for(Song s : list)
		{
			pWriter.println("<tr>");
			pWriter.println(s.toHTMLTableData());
			pWriter.println("</tr>");
		}

		pWriter.println("</table>");
		pWriter.println("</body>");
		pWriter.println("</html>");
		pWriter.close();	
	}

	private void demoPrintWriter(String strPath, 
			String strName, boolean bAppend, int bufferSize) throws IOException 
	{		
		File file = new File(strPath, strName);
		FileWriter fWriter = new FileWriter(file, bAppend);	
		BufferedWriter bWriter = new BufferedWriter(fWriter, bufferSize);
		PrintWriter pWriter = new PrintWriter(bWriter);

				
		pWriter.println("Name, CA, Exam");
		pWriter.println("John Smith, 45, 56");
		pWriter.println("Jane Doe, 78, 89");
				
		//ensure all data is written out
		pWriter.flush();
		//close the stream
		pWriter.close();	
	}

	private void demoBufferedReader(String strPath, 
			String strName, int bufferSize) 
	{

		
	}

	private void demoBufferedWriter(String strPath, 
			String strName, boolean bAppend, int bufferSize) throws IOException 
	{		
		File file = new File(strPath + strName);
		
		FileWriter fWriter 
					= new FileWriter(file, bAppend);	
		BufferedWriter bWriter 
					= new BufferedWriter(fWriter, bufferSize);
		
		bWriter.write("Niall");
		//use the newline method to write a newline since all operating systems may not interpret "\r\n" as a new line sequence
		bWriter.newLine(); //"\r\n" "\n" "\n\r"
		
		bWriter.write("John");
		//use the newline method to write a newline since all operating systems may not interpret "\r\n" as a new line sequence
		bWriter.newLine(); 
		
		bWriter.write("May");
		
		//ensure all data is written out
		bWriter.flush();
		//close the stream
		bWriter.close();
	
	}

	private void demoFileReader(String strPath, String strName) throws IOException 
	{		
		File file = new File(strPath, strName);
		FileReader fReader = new FileReader(file);
		

		//make a buffer
		char[] cbuf = new char[1024]; //QWERTY
		//read in the contents
		fReader.read(cbuf);		
		//convert to a string
		String s = String.valueOf(cbuf);	
		//print
		System.out.println(s);
		//close the stream
		fReader.close();
	}

	private void demoFileWriter(String strPath, String strName, boolean bAppend) throws IOException 
	{
		File file = new File(strPath, strName);
		FileWriter fWriter = new FileWriter(file, bAppend);
		

		/*
		fWriter.write((int)'z');
		*/
		
		/*
		char[] cArr = {'1','%','b','h'};
		//or initialize like this...
		char[] cbuf = new char[4];
		cbuf[0] = '1'; 
		cbuf[1] = '%'; 
		cbuf[2] = 'b'; 
		cbuf[3] = 'h';
		fWriter.write(cbuf, 1, 2);
		*/
		
		//write string contents out
		String s = "QWERTY";
		fWriter.write(s, 0, s.length());
		//ensure all data is written out
		fWriter.flush();
		//close the stream
		fWriter.close();		
	}
	
	
}










