package projectCSI2510_300209487;

import java.nio.file.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadTextAsString 
{ 
  /*public static String readFileAsString(String fileName)throws Exception 
  { 
    String data = ""; 
    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    return data; 
  } 
  
  public static void main(String[] args) throws Exception 
  { 
    String data = readFileAsString("C:\\Users\\erwan\\OneDrive\\Documents\\ApprenonsJava\\CSI2510\\EssaiLectureFichier.txt");
    
    System.out.println(data); 
  } 
  */
  public static void main(String[] args) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(
					"C:\\\\Users\\\\erwan\\\\OneDrive\\\\Documents\\\\ApprenonsJava\\\\CSI2510\\\\EssaiLectureFichier.txt"));
			String line = reader.readLine();
			System.out.println(line);
			/*while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}*/
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
} 