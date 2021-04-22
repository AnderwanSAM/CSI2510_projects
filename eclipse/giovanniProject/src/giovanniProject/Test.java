package giovanniProject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //save("test.txt");
		ArrayList<Integer> max_heap = new ArrayList<Integer>();
		System.out.println(max_heap.size());
		max_heap.add(5);
		//System.out.println(max_heap.size());
		//max_heap.remove(0);
		//System.out.println(max_heap.size()); 
		max_heap.add(0,15);
		//System.out.println(max_heap.get(0));
		System.out.println(max_heap);
		
	
	}
	
	public static void save(String file_name) 
	   {
		   try {
			PrintWriter writer = new PrintWriter(file_name);
			
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }

}
