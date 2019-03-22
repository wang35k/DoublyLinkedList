import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * the scanner can read a file line by line 
 * from the assignment sheet 
 *
 */
public class LineScanner {
	BufferedReader bufferedReader;
	
	public LineScanner(String filename) throws FileNotFoundException {
		bufferedReader = new BufferedReader(new FileReader(filename));
	}
	
	public String readNextLine() throws IOException {
		return bufferedReader.readLine();
	}

}
