import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class FileWordCount {

	public static void main(String[] args) throws IOException{
		
		System.out.println("Welcome to word counter! Please enter the name of the file you would like to access!");
		Scanner scanny = new Scanner(System.in);
		String fileName = scanny.next() + ".txt";
		scanny = new Scanner(new File(fileName));
		String fileString = "";
		while(scanny.hasNext()){
			fileString = fileString + scanny.next() + " ";
		}
		String[] words = fileString.split("[ \n\t\r.,;:!?(){}]");
		Map<String, Integer> map = new TreeMap<>();
		
		for(int i = 0; i < words.length; i++){
			String key = words[i].toLowerCase();
			
			if(key.length() > 0){
				if(!map.containsKey(key)){
					map.put(key, 1);
				}
				else{
					map.put(key, map.get(key) + 1);
				}
			}
		}
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for(Map.Entry<String, Integer> entry: entrySet)
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		
	}
	
}
