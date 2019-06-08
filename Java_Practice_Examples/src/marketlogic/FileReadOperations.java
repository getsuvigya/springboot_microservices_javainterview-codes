package marketlogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class FileReadOperations {
private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String args[]) throws Exception {
        // read the string filename
    	BufferedReader bufferedReader;
    	BufferedWriter bufferedWriter;
        String filename;
        filename = scan.nextLine();
        try{
        	bufferedReader = new BufferedReader(new FileReader(filename));
        	String line = bufferedReader.readLine();
        	Map<String, Integer> hostRequestMap = new HashMap<>();
        	while (line != null) {
				String host = line.split(" ")[0];
				if(!hostRequestMap.containsKey(host)){
					hostRequestMap.put(host, 1);
				}else{
					int noOfRequests = hostRequestMap.get(host)+1;
					hostRequestMap.put(host, noOfRequests);
				}
			}
        	bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("records_"+filename),"utf-8"));
        	Set<Map.Entry<String, Integer>> recordSet = hostRequestMap.entrySet();
        	Iterator<Map.Entry<String, Integer>> itr =recordSet.iterator();
        	while(itr.hasNext()){
        		Entry<String, Integer> entry = itr.next();
        		bufferedWriter.write(entry.getKey()+" "+entry.getValue());
        		bufferedWriter.newLine();
        	}
        	
        }catch(IOException exception){
        	exception.printStackTrace();
        }
        
    }
}
